package com.read.readit.useCase

import com.read.mvi.either.Either
import com.read.readit.repo.IRepo

class UseCase(private val repo: IRepo): IUseCase {

    override suspend fun execute(): Either<String, String> {
        return repo.doJob2()
    }
}