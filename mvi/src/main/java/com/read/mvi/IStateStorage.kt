package com.read.mvi

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface IStateStorage<S> {
    fun storeState(state: S)
    fun observeState(viewLifecycleOwner: LifecycleOwner, observer: Observer<S>)
    val state: S
}