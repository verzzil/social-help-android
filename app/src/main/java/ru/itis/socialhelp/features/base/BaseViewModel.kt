package ru.itis.socialhelp.features.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<S, E>(
    initialState: S
): ViewModel(), EventHandler<E> {

    protected val _viewState: MutableStateFlow<S> = MutableStateFlow(initialState)
    val viewState: StateFlow<S>
        get() = _viewState.asStateFlow()
}