package com.read.readit

import com.read.mvi.machine.FiniteMachine
import com.read.readit.repo.Repo
import com.read.readit.state.StateScreen1
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel


@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
class ConcreteStateMachine(scope: CoroutineScope, idle: StateScreen1): FiniteMachine<StateScreen1>(ConflatedBroadcastChannel(idle), ActionExecutor(Repo(), scope)) {
    override fun getTag(): String {
        return "ConcreteStateMachine"
    }
}