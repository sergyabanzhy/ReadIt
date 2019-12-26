package com.read.mvi.machine

import kotlinx.coroutines.flow.Flow

interface IUseCaseManager {
    suspend fun get(state: IState): Flow<IIntent>?
}