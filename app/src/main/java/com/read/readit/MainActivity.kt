package com.read.readit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.library.slogger.FileTree
import com.read.readit.intent.Intent
import com.read.readit.state.StateScreen1
import com.read.readit.viewModel.TestViewModel
import com.read.mvi.viewState.ViewState
import com.read.readit.viewModel.StateRenderer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import timber.log.Timber

@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
class MainActivity : AppCompatActivity(), ViewState<StateScreen1, Intent, TestViewModel>, StateRenderer {

    override val viewModel: TestViewModel by lazy {
        ViewModelProviders.of(this).get(TestViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.plant(FileTree.Builder()
            .filesDir(filesDir)
            .size(1024*1024)
            .build(), Timber.DebugTree())

        setContentView(R.layout.activity_main)

        observeViewState(this)

        tv.setOnClickListener {
            trigger(Intent.LoadSmth)
        }

        tv2.setOnClickListener {
            trigger(Intent.LoadSmth)
        }
    }

    override fun render(state: StateScreen1) {
        state.render(this)
    }

    override fun renderState(state: StateScreen1.Fetching) {
        Timber.d( "renderState, Fetching")
    }

    override fun renderState(state: StateScreen1.Fetched2) {
        Timber.d( "renderState, Fetched2")

        tv2.text = state.value
    }

    override fun renderState(state: StateScreen1.Idle) {
        Timber.d("renderState, Idle")
    }

    override fun renderState(state: StateScreen1.Fetched1) {
        Timber.d( "renderState, Fetched1")
    }

    override fun renderState(state: StateScreen1.Fetching2) {
        Timber.d( "renderState, Fetching2")
    }
}
