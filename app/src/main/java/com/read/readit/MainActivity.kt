package com.read.readit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.read.mvi.intent.Intent
import com.read.mvi.machine.IState
import com.read.readit.state.State
import com.read.readit.viewModel.TestViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewState<TestViewModel> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeViewState(this)

        tv.setOnClickListener {
            trigger(Intent.Trigger)
        }

        tv2.setOnClickListener {
            trigger(Intent.Trigger)
        }
    }

    override fun render(state: IState) {
        when(state) {
            is State.Fetching -> Log.d("MainActivity", "Fetching")
            is State.Fetching2 -> Log.d("MainActivity", "Fetching2")
            is State.Idle -> Log.d("MainActivity", "Idle")
        }
    }

    override fun provideViewModel(): TestViewModel {
        return ViewModelProviders.of(this).get(TestViewModel::class.java)
    }
}
