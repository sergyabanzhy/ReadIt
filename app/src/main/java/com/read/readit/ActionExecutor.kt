package com.read.readit

import android.util.Log
import com.read.mvi.actionExecutor.IActionExecutor
import com.read.mvi.intent.Intent
import com.read.mvi.machine.IIntent
import com.read.mvi.machine.IState
import com.read.readit.repo.IRepo
import com.read.readit.state.StateScreen1
import com.read.readit.useCase.UseCase
import com.read.readit.useCase.UseCase2
import kotlinx.coroutines.*

open class ActionExecutor(private val repo: IRepo) : IActionExecutor<StateScreen1> {

    override suspend fun executeAction(state: StateScreen1, newIntent: suspend ((IIntent) -> Unit)) {
        Log.d("ActionExecutor", "executeAction")

        get(state)?.run {
            Log.d("ActionExecutor collect", "$this")
            newIntent.invoke(this)
        }
    }

    suspend fun get(state: IState): IIntent? {

        var intent: IIntent? = null

        when (state) {
            is StateScreen1.Fetching ->

                UseCase(repo).execute().right {
                    intent = Intent.Fetched(it)
                }.left {
                    intent = Intent.Error
                }

            is StateScreen1.Fetching2 ->
                UseCase2(repo).execute().right {
                    intent = Intent.Fetched2(it)
                }.left {
                    intent = Intent.Error
                }
        }

        return intent
    }
}