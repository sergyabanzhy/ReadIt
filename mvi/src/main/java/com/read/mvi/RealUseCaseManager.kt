package com.read.mvi

import android.util.Log
import com.read.mvi.intent.Intent
import com.read.mvi.repo.IRepo
import com.read.mvi.state.State
import com.read.mvi.useCase.UseCase
import com.read.mvi.useCase.UseCase2
import kotlinx.coroutines.flow.*

class RealUseCaseManager(private val repo: IRepo): UseCaseFactory() {

    var current: Flow<IIntent>? = null

    override suspend fun get(state: IState): Flow<IIntent>? {
        return when (state) {
            is State.Fetching -> run(UseCase(repo))
            is State.Fetching2 -> run2(UseCase2(repo))
            else -> null
        }
    }
}

private suspend fun RealUseCaseManager.run(useCase: IUseCase): Flow<IIntent> {
    Log.d("RealUseCaseManager", "run")

    current = useCase.execute()

    return current!!.map {
        Log.d("RealUseCaseManager", "run, mapping")
        Intent.Fetched("")
    }
}

private suspend fun RealUseCaseManager.run2(useCase: IUseCase): Flow<IIntent> {
    Log.d("RealUseCaseManager", "run")

//    return current!!.map {
//        Log.d("RealUseCaseManager", "run, mapping")
//        Intent.Fetched
//    }

    return current?.run {
        current?.combine(useCase.execute()) { i, s -> Intent.Fetched2("") as IIntent }
    } ?: useCase.execute()

    //flowOf(1, 2, 3).scan(emptyList<Int>()) { acc, value -> acc + value }.toList()
    // will produce `[], [1], [1, 2], [1, 2, 3]]`
}

