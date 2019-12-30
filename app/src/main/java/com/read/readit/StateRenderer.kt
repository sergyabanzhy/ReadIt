package com.read.readit

import com.read.readit.state.StateScreen1

interface StateRenderer {
    fun renderState(state: StateScreen1.Fetching)
    fun renderState(state: StateScreen1.Fetched2)
    fun renderState(state: StateScreen1.Idle)
    fun renderState(state: StateScreen1.Fetched1)
    fun renderState(state: StateScreen1.Fetching2)
}