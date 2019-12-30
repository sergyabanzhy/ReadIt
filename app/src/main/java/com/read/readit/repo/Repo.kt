package com.read.readit.repo

import android.util.Log
import com.read.mvi.either.Either
import kotlinx.coroutines.delay

class Repo: IRepo {
    override suspend fun doJob(): Either<String, Int> {
        Log.d("Repo", "doing doJob ")
        delay(2000)
        Log.d("Repo", "finished doJob")
        return Either.Right(10)
    }

    override suspend fun doJob2(): Either<String, String> {
        Log.d("Repo", "doing doJob2")
        delay(3000)
        Log.d("Repo", "finished doJob2")
        return Either.Right("doJob2")
    }
}