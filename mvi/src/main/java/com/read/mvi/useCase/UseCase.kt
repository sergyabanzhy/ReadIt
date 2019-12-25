package com.read.mvi.useCase

import android.util.Log
import com.read.mvi.IIntent
import com.read.mvi.IUseCase
import com.read.mvi.intent.Intent
import com.read.mvi.repo.IRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UseCase(private val repo: IRepo): IUseCase {

    override suspend fun execute(): Flow<IIntent> {
        return flow {
            repo.doJob().right {
                Log.d("UseCase", "finished $it")
                emit(Intent.Fetched(it))
            }
        }
    }
}