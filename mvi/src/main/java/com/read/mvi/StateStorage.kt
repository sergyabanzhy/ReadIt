package com.read.mvi

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer


open class StateStorage<S>(initial: S): MutableLiveData<S>(initial), IStateStorage<S> {

    override val state: S
    get() = value ?: throw IllegalStateException("Stored state can not be null")

    @MainThread
    override fun storeState(state: S) {
        value = state
    }

    override fun observeState(viewLifecycleOwner: LifecycleOwner, observer: Observer<S>) {
        observe(viewLifecycleOwner, observer)
    }
}