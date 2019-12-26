package com.read.readit.useCase

import com.read.mvi.machine.IIntent
import com.read.mvi.machine.IState
import com.read.mvi.intent.Intent
import com.read.mvi.machine.IUseCaseManager
import com.read.readit.repo.IRepo
import com.read.readit.state.State
import kotlinx.coroutines.flow.*

class RealUseCaseManager(private val repo: IRepo) :
    IUseCaseManager {

    override suspend fun get(state: IState): Flow<IIntent>? {

        return when (state) {
            is State.Fetching -> flow {
                UseCase(repo).execute().right {
                    emit(Intent.Fetched(it))
                }.left {
                    emit(Intent.Error)
                }
            }

            is State.Fetching2 -> flow {
                UseCase2(repo).execute().right {
                    emit(Intent.Fetched2(it))
                }.left {
                    emit(Intent.Error)
                }
            }
            else -> null
        }
    }
}

