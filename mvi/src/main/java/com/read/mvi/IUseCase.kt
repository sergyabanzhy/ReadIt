package com.read.mvi

import kotlinx.coroutines.flow.Flow

interface IUseCase {
    suspend fun execute(): Flow<IIntent>
}