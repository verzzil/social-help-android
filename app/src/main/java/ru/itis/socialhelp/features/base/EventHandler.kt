package ru.itis.socialhelp.features.base

interface EventHandler<E> {

    fun obtainEvent(event: E)
}