package com.read.readit.repo

import com.read.mvi.either.Either
import kotlinx.coroutines.delay
import timber.log.Timber

class Repo: IRepo {
    override suspend fun doJob(): Either<String, Int> {
        Timber.d( "doing doJob ")
        delay(2000)
        Timber.d( "finished doJob")
        return Either.Right(10)
    }

    override suspend fun doJob2(): Either<String, String> {
        Timber.d("doing doJob2")
        delay(3000)
        Timber.d( "finished doJob2")
        return Either.Right("doJob2")
    }
}