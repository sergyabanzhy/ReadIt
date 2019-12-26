package com.read.readit.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.read.mvi.actionExecutor.IActionExecutor
import com.read.mvi.machine.FiniteMachine
import com.read.mvi.machine.IState
import com.read.mvi.machine.IStateStorage
import com.read.readit.IStateViewModel
import com.read.readit.Machine

class TestViewModel : ViewModel(), IStateViewModel<Machine> {

    override val stateMachine: Machine = Machine(viewModelScope)
}