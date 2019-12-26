package com.read.readit

import com.read.mvi.machine.FiniteMachine
import com.read.mvi.machine.IState
import com.read.readit.repo.Repo
import com.read.readit.state.State
import com.read.readit.useCase.RealUseCaseManager
import kotlinx.coroutines.CoroutineScope

class Machine(scope: CoroutineScope): FiniteMachine<StateStorage<IState>, ActionExecutor>(
    StateStorage(State.Idle),
    ActionExecutor(RealUseCaseManager(Repo()), scope)
) {
    override fun getTag(): String {
        return "Machine"
    }
}