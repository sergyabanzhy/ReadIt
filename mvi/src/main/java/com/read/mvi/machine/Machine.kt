package com.read.mvi.machine

import com.read.mvi.*
import com.read.mvi.repo.Repo
import com.read.mvi.state.State
import kotlinx.coroutines.CoroutineScope

class Machine(scope: CoroutineScope): FiniteMachine<StateStorage<IState>, ActionExecutor>(StateStorage(State.Idle), ActionExecutor(RealUseCaseManager(Repo()), scope)) {
    override fun getTag(): String {
        return "Machine"
    }
}