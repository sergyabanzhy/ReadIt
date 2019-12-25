package com.read.mvi.repo

import android.util.Log
import com.autodoc.m13Base.either.Either
import kotlinx.coroutines.delay

class Repo: IRepo {
    override suspend fun doJob(): Either<String, String> {
        Log.d("Repo", "doing doJob ")
        delay(5000)
        Log.d("Repo", "finished doJob")
        return Either.Right("doJob")
    }

    override suspend fun doJob2(): Either<String, String> {
        Log.d("Repo", "doing doJob2")
        delay(6000)
        Log.d("Repo", "finished doJob2")
        return Either.Right("doJob2")
    }
}