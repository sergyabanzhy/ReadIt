package com.read.readit

import androidx.lifecycle.ViewModel
import com.read.mvi.machine.FiniteMachine
import com.read.mvi.machine.IState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
abstract class IStateViewModel<S: IState>: ViewModel() {
    abstract val stateMachine: FiniteMachine<S>
    abstract val scope: CoroutineScope
}