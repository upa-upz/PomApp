package com.pomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pomapp.databinding.ActivityMainBinding
import com.pomapp.databinding.ActivityTimeBinding

class TimeActivity : AppCompatActivity() {

    lateinit var binding: ActivityTimeBinding
    var tempActive:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTimePause.setOnClickListener {

        }
    }

    private fun timerInit(){

    }
    private fun timerPause(){

    }
}