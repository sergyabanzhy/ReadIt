package com.read.readit.useCase

import com.read.mvi.either.Either

interface IUseCase<E, S> {
    suspend fun execute(): Either<E, S>
}