package com.read.mvi.repo

import com.autodoc.m13Base.either.Either

interface IRepo {
    suspend fun doJob(): Either<String, String>
    suspend fun doJob2(): Either<String, String>
}