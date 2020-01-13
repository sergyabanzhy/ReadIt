package com.read.readit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.read.readit.intent.Intent
import com.read.readit.state.StateScreen1
import com.read.readit.viewModel.TestViewModel
import com.read.mvi.viewState.ViewState
import com.read.readit.viewModel.StateRenderer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
class MainActivity : AppCompatActivity(), ViewState<StateScreen1, Intent, TestViewModel>, StateRenderer {

    override val viewModel: TestViewModel by lazy {
        ViewModelProviders.of(this).get(TestViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        Log.d(TAG, "renderState, Fetching")
    }

    override fun renderState(state: StateScreen1.Fetched2) {
        Log.d(TAG, "renderState, Fetched2")

        tv2.text = state.value
    }

    override fun renderState(state: StateScreen1.Idle) {
        Log.d(TAG, "renderState, Idle")
    }

    override fun renderState(state: StateScreen1.Fetched1) {
        Log.d(TAG, "renderState, Fetched1")
    }

    override fun renderState(state: StateScreen1.Fetching2) {
        Log.d(TAG, "renderState, Fetching2")
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
