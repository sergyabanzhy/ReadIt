package com.read.mvi.state

import com.read.mvi.IIntent
import com.read.mvi.IState
import com.read.mvi.intent.Intent
import java.lang.RuntimeException

sealed class State: IState {

    object Idle: State() {
        override val mutate: (intent: IIntent) -> IState = {
            when(it) {
                is Intent.Trigger -> Fetching
                else -> Idle
            }
        }
    }

    object Fetching: State() {
        override val mutate: (intent: IIntent) -> IState = {
            when(it) {
                is Intent.Fetched -> Idle
                is Intent.Trigger -> Fetching2
                else -> throw RuntimeException()
            }
        }
    }

    object Fetching2: State() {
        override val mutate: (intent: IIntent) -> IState = {
            when(it) {
                is Intent.Fetched2 -> Idle
                is Intent.Fetched -> Idle
                else -> throw RuntimeException()
            }
        }
    }
}