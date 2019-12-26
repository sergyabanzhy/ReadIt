package com.read.readit.useCase

import com.read.mvi.either.Either

interface IUseCase {
    suspend fun execute(): Either<String, String>
}