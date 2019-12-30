package com.read.readit.state

import com.read.mvi.machine.IIntent
import com.read.mvi.machine.IState
import com.read.mvi.intent.Intent
import java.lang.RuntimeException

sealed class StateScreen1: IState {

    object Idle: StateScreen1() {
        override val mutate: (intent: IIntent) -> IState = {
            when(it) {
                is Intent.LoadSmth -> Fetching
                else -> Idle
            }
        }
    }

    object Fetching : StateScreen1() {
        override val mutate: (intent: IIntent) -> IState = {
            when(it) {
                is Intent.Fetched -> Fetched1(it.string)
                else -> throw RuntimeException()
            }
        }
    }

    data class Fetched1(val value: String): StateScreen1() {
        override val mutate: (intent: IIntent) -> IState = {
            when(it) {
                is Intent.LoadSmth -> Fetching
                else -> throw RuntimeException()
            }
        }
    }

    data class Fetched2(val value: String): StateScreen1() {
        override val mutate: (intent: IIntent) -> IState = {
            when(it) {
                is Intent.LoadSmth -> Fetching2
                else -> throw RuntimeException()
            }
        }
    }

    object Fetching2: StateScreen1() {
        override val mutate: (intent: IIntent) -> IState = {
            when(it) {
                is Intent.Fetched2 -> Fetched2(it.string)
                else -> throw RuntimeException()
            }
        }
    }
}