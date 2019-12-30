package com.read.readit.viewModel

import androidx.lifecycle.viewModelScope
import com.read.readit.IStateViewModel
import com.read.readit.ConcreteStateMachine
import com.read.readit.state.StateScreen1
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
class TestViewModel:  IStateViewModel<StateScreen1>() {
    override val stateMachine: ConcreteStateMachine = ConcreteStateMachine(viewModelScope, StateScreen1.Idle)
    override val scope: CoroutineScope = viewModelScope
}