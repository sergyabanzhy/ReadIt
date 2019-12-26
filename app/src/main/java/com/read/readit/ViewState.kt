package com.read.readit

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.read.mvi.machine.IIntent
import com.read.mvi.machine.IState
import com.read.readit.viewModel.TestViewModel

interface ViewState<VM: IStateViewModel<Machine>> {

    fun render(state: IState)

    fun provideViewModel(): VM

    fun observeViewState(lifecycleOwner: LifecycleOwner) {
        provideViewModel().stateMachine.observeState(lifecycleOwner, Observer {
            render(it)
        })
    }

    fun trigger(intent: IIntent) {
        provideViewModel().stateMachine.triggerWith(intent)
    }
}