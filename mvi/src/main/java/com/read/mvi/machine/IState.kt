package com.read.mvi.machine

import android.util.Log

interface IState {

    fun isAllowedState(): Boolean {
        return true
    }

    val mutate: (intent: IIntent) -> IState
}

inline fun <T : IState> (T).onMutated(function: (T) -> Unit): T {
    if (isAllowedState()) function.invoke(this)
    return this
}

inline fun <T : IState> (T).onMutationIllegal(function: () -> Unit) {
    if (!isAllowedState()) {
        Log.w(
            "State mutation right:",
            "onMutationIllegal - Intent $this can not impact current state $this."
        )
        function.invoke()
    }
}