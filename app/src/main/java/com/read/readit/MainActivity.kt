package com.read.readit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.read.mvi.intent.Intent
import com.read.mvi.viewModel.TestViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val v = ViewModelProviders.of(this).get(TestViewModel::class.java)

        tv.setOnClickListener {
            v.machine.triggerWith(Intent.Trigger)
        }

        tv2.setOnClickListener {
            v.machine.triggerWith(Intent.Trigger)
        }
    }
}
