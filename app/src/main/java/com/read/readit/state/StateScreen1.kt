package com.read.readit.state

import com.read.mvi.machine.IIntent
import com.read.mvi.machine.IState
import com.read.readit.intent.Intent
import com.read.readit.viewModel.StateRenderer
import java.lang.RuntimeException

sealed class StateScreen1: IState {

    abstract fun render(visitor: StateRenderer)

    object Idle: StateScreen1() {
        override val mutate: (intent: IIntent) -> IState = {
            when(it) {
                is Intent.LoadSmth -> Fetching
                else -> Idle
            }
        }

        override fun render(visitor: StateRenderer) {
            visitor.renderState(this)
        }
    }

    object Fetching : StateScreen1() {
        override val mutate: (intent: IIntent) -> IState = {
            when(it) {
                is Intent.Fetched -> Fetching2
                else -> throw RuntimeException()
            }
        }

        override fun render(visitor: StateRenderer) {
            visitor.renderState(this)
        }
    }

    data class Fetched1(val value: String): StateScreen1() {
        override val mutate: (intent: IIntent) -> IState = {
            when(it) {
                is Intent.LoadSmth -> Fetching
                else -> throw RuntimeException()
            }
        }

        override fun render(visitor: StateRenderer) {
            visitor.renderState(this)
        }
    }

    data class Fetched2(val value: String): StateScreen1() {
        override val mutate: (intent: IIntent) -> IState = {
            when(it) {
                is Intent.LoadSmth -> Fetching2
                else -> throw RuntimeException()
            }
        }

        override fun render(visitor: StateRenderer) {
            visitor.renderState(this)
        }
    }

    object Fetching2: StateScreen1() {
        override val mutate: (intent: IIntent) -> IState = {
            when(it) {
                is Intent.Fetched2 -> Fetched2(it.string)
                else -> throw RuntimeException()
            }
        }

        override fun render(visitor: StateRenderer) {
            visitor.renderState(this)
        }
    }
}