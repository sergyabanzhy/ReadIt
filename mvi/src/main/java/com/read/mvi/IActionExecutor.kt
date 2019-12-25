package com.read.mvi

interface IActionExecutor {
    fun executeAction(state: IState, newIntent: ((IIntent) -> Unit))
}