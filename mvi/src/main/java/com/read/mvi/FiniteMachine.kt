package com.read.mvi

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

abstract class FiniteMachine<S : IStateStorage<IState>, SE : IActionExecutor>(private val storage: IStateStorage<IState>, private val executor: IActionExecutor) {

    fun triggerWith(intent: IIntent) {

        val oldState = storage.state

        oldState.mutate(intent).onMutated { newState ->

            Log.d(getTag(), "onMutated with intent ${intent::class.java.simpleName}, oldState ${oldState::class.java.simpleName} -> newState ${newState::class.java.simpleName}")
            storage.storeState(newState)

            executor.executeAction(storage.state) {
                triggerWith(it)
            }

        }.onMutationIllegal {
            Log.e(getTag(), "onMutationIllegal with intent ${intent::class.java.simpleName}, oldState ${oldState::class.java.simpleName}")
        }
    }

    fun observeState(viewLifecycleOwner: LifecycleOwner, observer: Observer<IState>) {
        storage.observeState(viewLifecycleOwner, observer)
    }

    abstract fun getTag(): String
}
