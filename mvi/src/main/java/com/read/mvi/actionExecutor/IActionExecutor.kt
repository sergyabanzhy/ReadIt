package com.read.mvi.actionExecutor

import com.read.mvi.machine.IIntent
import com.read.mvi.machine.IState

interface IActionExecutor<S: IState> {
    suspend fun executeAction(state: S, newIntent: suspend (IIntent) -> Unit)
}