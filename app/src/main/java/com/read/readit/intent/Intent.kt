package com.read.readit.intent


import com.read.mvi.machine.IIntent
import com.read.readit.UseCaseProvider
sealed class Intent: IIntent {

    open suspend fun dispatch(visitor: UseCaseProvider, completion: suspend((IIntent) -> Unit)) {}

    object Idle: Intent() {
        override suspend fun dispatch(visitor: UseCaseProvider, completion: suspend((IIntent) -> Unit)) {
            visitor.runUseCaseByIntent(this, completion)
        }
    }

    object Error: Intent()

    data class Fetched(val string: String): Intent()

    data class Fetched2(val string: String): Intent()

    object LoadSmth: Intent()
}