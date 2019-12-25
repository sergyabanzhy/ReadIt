package com.read.mvi

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

open class ActionExecutor(private val factory: IUseCaseFactory, private val scope: CoroutineScope): IActionExecutor {

    override fun executeAction(state: IState, newIntent: ((IIntent) -> Unit)) {
        Log.d("ActionExecutor", "executeAction")
        scope.launch((Dispatchers.IO)) {
            factory.get(state)?.collect {
                Log.d("ActionExecutor collect", "$it")
                withContext(Dispatchers.Main) {
                    newIntent.invoke(it)
                }
            }
        }
    }
}