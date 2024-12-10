package com.example.countermvvm.view

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.countermvvm.R
import com.example.simplecounter.viewmodel.CounterViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel = CounterViewModel()

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        viewModel.count.observe(this, { newCount ->
            Log.d(TAG, "LiveData updated with new count: $newCount")
            findViewById<TextView>(R.id.countText).text = newCount.toString()
        })

        findViewById<TextView>(R.id.incrementButton).setOnClickListener {
            Log.d(TAG, "Button clicked: Incrementing counter")
            viewModel.incrementCounter()
        }

    }
}