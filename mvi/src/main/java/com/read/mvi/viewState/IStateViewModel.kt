package com.read.mvi.viewState

import androidx.lifecycle.ViewModel
import com.read.mvi.machine.FiniteMachine
import com.read.mvi.machine.IIntent
import com.read.mvi.machine.IState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
abstract class IStateViewModel<S: IState, I: IIntent>: ViewModel() {
    abstract val stateMachine: FiniteMachine<S, I>
    abstract val scope: CoroutineScope
}