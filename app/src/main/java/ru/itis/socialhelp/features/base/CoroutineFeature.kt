package ru.itis.socialhelp.features.base

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CoroutineFeature<S, M, E>(
    initialState: S,
    initialEffects: Set<E>,
    private val update: (S, M) -> Pair<S, Set<E>>,
    private val handler: Handler<E, M>,
    private val scope: CoroutineScope
) {

    private val _state: MutableStateFlow<S> = MutableStateFlow(initialState)
    val state: StateFlow<S>
        get() = _state.asStateFlow()

    private val _mutations: MutableSharedFlow<M> = MutableSharedFlow()
    val mutations: SharedFlow<M>
        get() = _mutations.asSharedFlow()

    init {
        scope.launch {
            mutations
                .onEach { Log.i("asdfasdf", "MUTATION $it") }
                .scan(initialState to initialEffects) { (s, _), m ->
                    update(s, m)
                }
                .collect { (s, eff) ->
                    _state.emit(s)
                    eff.forEach {
                        launch {
                            handler.handle(it, ::mutate)
                        }
                    }
                }
        }
    }

    private fun mutate(mutation: M) {
        scope.launch {
            _mutations.emit(mutation)
        }
    }
}

interface Handler<E, M> {

    suspend fun handle(effect: E, sink: (M) -> Unit)
}
