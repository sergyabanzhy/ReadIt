package com.read.readit

import com.read.mvi.machine.IIntent
import com.read.readit.intent.Intent

interface UseCaseProvider {
    suspend fun runUseCaseByIntent(state: Intent.LoadSmth, completion: suspend((IIntent) -> Unit))
    suspend fun runUseCaseByIntent(state: Intent.Fetched2, completion: suspend((IIntent) -> Unit))
    suspend fun runUseCaseByIntent(state: Intent.Idle, completion: suspend((IIntent) -> Unit))
}