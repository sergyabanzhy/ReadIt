package com.read.mvi.actionExecutor

import com.read.mvi.machine.IIntent
import com.read.mvi.machine.IState

interface IActionExecutor<S: IState> {
    fun executeAction(state: S, newIntent: suspend (IIntent) -> Unit)
}