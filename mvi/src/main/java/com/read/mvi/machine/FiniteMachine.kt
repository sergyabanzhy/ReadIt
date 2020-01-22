package com.read.mvi.machine

import android.util.Log
import com.read.mvi.actionExecutor.IActionExecutor
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

@Suppress("UNCHECKED_CAST")
@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
abstract class FiniteMachine<S: IState, I: IIntent>(private var storage: ConflatedBroadcastChannel<S>, private val executor: IActionExecutor<I>) {

    suspend fun triggerWith(intent: I) {

        val oldState = storage.value

        oldState.mutate(intent).onMutated { newState  ->

            storage.offer(newState as S)


            executor.executeAction(intent) {
                triggerWith(it as I)
            }

            }.onMutationIllegal {
            }
        }

    fun state(): Flow<S> {
        return storage.asFlow()
    }
}
