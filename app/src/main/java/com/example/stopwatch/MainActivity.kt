package com.example.stopwatch

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var chronometer: Chronometer
    private var running = false
    private lateinit var startButton: Button
    private lateinit var stopButton: Button
    private lateinit var resetButton: Button
    private var seconds=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chronometer = findViewById(R.id.chronometer)
        startButton = findViewById(R.id.start)
        stopButton = findViewById(R.id.pause)
        resetButton = findViewById(R.id.reset)
        startButton.setOnClickListener { onClickStart() }
        stopButton.setOnClickListener { onClickStop() }
        resetButton.setOnClickListener { onClickReset() }

    }
    fun onClickStart() {
        if (!running) {
            chronometer.base = SystemClock.elapsedRealtime() - seconds
            chronometer.start()
            running = true
        }

    }
    fun onClickReset() {
        chronometer.base = SystemClock.elapsedRealtime()
        seconds = 0
        if (running) {
            chronometer.stop()
            running = false
        }

    }

    fun onClickStop() {
        if (running) {
            chronometer.stop()
            seconds = (SystemClock.elapsedRealtime() - chronometer.base).toInt()
            running = false
        }

    }
}