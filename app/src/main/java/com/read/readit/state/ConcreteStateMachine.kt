package com.read.readit.state

import com.read.mvi.machine.FiniteMachine
import com.read.readit.ActionExecutor
import com.read.readit.intent.Intent
import com.read.readit.repo.Repo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel


@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
class ConcreteStateMachine(idle: StateScreen1): FiniteMachine<StateScreen1, Intent>(ConflatedBroadcastChannel(idle), ActionExecutor(Repo()))