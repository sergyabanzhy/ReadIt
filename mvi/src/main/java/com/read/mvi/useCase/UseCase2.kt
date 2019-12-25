package com.read.mvi.useCase

import android.util.Log
import com.read.mvi.IIntent
import com.read.mvi.IUseCase
import com.read.mvi.intent.Intent
import com.read.mvi.repo.IRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UseCase2(private val repo: IRepo): IUseCase {

    override suspend fun execute(): Flow<IIntent> {
        return flow {
            repo.doJob2().right {
                Log.d("UseCase2", "finished $it")
                emit(Intent.Fetched2(it))
            }
        }
    }
}