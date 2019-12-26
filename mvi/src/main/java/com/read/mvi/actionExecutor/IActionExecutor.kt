package com.read.mvi.actionExecutor

import com.read.mvi.machine.IIntent
import com.read.mvi.machine.IState

interface IActionExecutor {
    fun executeAction(state: IState, newIntent: ((IIntent) -> Unit))
}