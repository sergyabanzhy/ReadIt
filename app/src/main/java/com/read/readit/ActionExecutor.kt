package com.read.readit

import android.util.Log
import com.read.mvi.actionExecutor.IActionExecutor
import com.read.mvi.machine.IIntent
import com.read.readit.intent.Intent
import com.read.readit.repo.IRepo
import com.read.readit.useCase.UseCase

class ActionExecutor(private val repo: IRepo): IActionExecutor<Intent>, UseCaseProvider {

    override suspend fun executeAction(intent: Intent, newIntent: suspend((IIntent) -> Unit)) {
        Log.d("ActionExecutor", "executeAction")
        intent.dispatch(this, newIntent)
    }

    override suspend fun runUseCaseByIntent(state: Intent.LoadSmth, completion: suspend((IIntent) -> Unit)) {
        UseCase(repo).execute().right {
            completion(Intent.Fetched(it))
        }.left {
            completion(Intent.Error)
        }
    }

    override suspend fun runUseCaseByIntent(state: Intent.Fetched2, completion: suspend((IIntent) -> Unit)) {
        UseCase(repo).execute().right {
            completion(Intent.Fetched(it))
        }.left {
            completion(Intent.Error)
        }
    }

    override suspend fun runUseCaseByIntent(state: Intent.Idle, completion: suspend((IIntent) -> Unit)) {
        UseCase(repo).execute().right {
            completion(Intent.Fetched(it))
        }.left {
            completion(Intent.Error)
        }
    }
}