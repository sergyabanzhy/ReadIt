package com.read.mvi.actionExecutor

import com.read.mvi.machine.IIntent


interface IActionExecutor<I: IIntent> {
    suspend fun executeAction(intent: I, newIntent: suspend (IIntent) -> Unit)
}