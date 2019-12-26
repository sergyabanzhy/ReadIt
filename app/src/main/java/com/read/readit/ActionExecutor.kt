package com.read.readit

import android.util.Log
import com.read.mvi.actionExecutor.IActionExecutor
import com.read.mvi.machine.IIntent
import com.read.mvi.machine.IState
import com.read.mvi.machine.IUseCaseManager
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

open class ActionExecutor(private val factory: IUseCaseManager, private val scope: CoroutineScope):
    IActionExecutor {

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