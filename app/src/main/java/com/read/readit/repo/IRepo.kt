package com.read.readit.repo

import com.read.mvi.either.Either

interface IRepo {
    suspend fun doJob(): Either<String, Int>
    suspend fun doJob2(): Either<String, String>
}