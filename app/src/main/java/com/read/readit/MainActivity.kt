package com.read.readit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.read.mvi.intent.Intent
import com.read.readit.state.StateScreen1
import com.read.readit.viewModel.TestViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
class MainActivity : AppCompatActivity(), ViewState<StateScreen1, TestViewModel> {

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
        when(state) {
            is StateScreen1.Fetching -> Log.d("MainActivity", "Fetching")
            is StateScreen1.Fetching2 -> Log.d("MainActivity", "Fetching2")
            is StateScreen1.Fetched1 -> Log.d("MainActivity", "Fetched1")
            is StateScreen1.Fetched2 -> Log.d("MainActivity", "Fetched2")
            is StateScreen1.Idle -> Log.d("MainActivity", "Idle")
        }
    }

    override val viewModel: TestViewModel by lazy {
        ViewModelProviders.of(this).get(TestViewModel::class.java)
    }
}
