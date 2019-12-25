package com.read.mvi

import kotlinx.coroutines.flow.Flow

interface IUseCaseFactory {
    suspend fun get(state: IState): Flow<IIntent>?
}