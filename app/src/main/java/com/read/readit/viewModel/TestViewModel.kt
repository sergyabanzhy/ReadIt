package com.read.readit.viewModel


import androidx.lifecycle.viewModelScope
import com.read.mvi.viewState.IStateViewModel
import com.read.readit.intent.Intent
import com.read.readit.state.ConcreteStateMachine
import com.read.readit.state.StateScreen1
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
class TestViewModel:  IStateViewModel<StateScreen1, Intent>() {
    override val stateMachine: ConcreteStateMachine =
        ConcreteStateMachine(StateScreen1.Idle)
    override val scope: CoroutineScope = viewModelScope
}