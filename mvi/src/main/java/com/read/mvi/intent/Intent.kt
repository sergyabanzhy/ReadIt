package com.read.mvi.intent

import com.read.mvi.machine.IIntent

sealed class Intent: IIntent {

    object Idle: Intent()

    object Error: Intent()

    data class Fetched(val string: String): Intent()

    data class Fetched2(val string: String): Intent()

    object Trigger: Intent()
}