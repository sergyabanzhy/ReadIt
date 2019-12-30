package com.read.readit

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.read.mvi.machine.IIntent
import com.read.mvi.machine.IState
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
interface ViewState<S: IState, VM: IStateViewModel<S>>: StateRenderer {

    fun render(state: S)

    val viewModel: VM

    fun observeViewState(lifecycleOwner: LifecycleOwner) {

        viewModel
            .stateMachine
            .state()
            .asLiveData()
            .observe(lifecycleOwner, Observer {
                render(it)
            })
    }

    fun trigger(intent: IIntent) {

        viewModel.apply {
            scope.launch(Dispatchers.IO) {
                viewModel
                    .stateMachine
                    .triggerWith(intent)
            }
        }
    }
}