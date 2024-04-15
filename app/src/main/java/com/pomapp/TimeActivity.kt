package com.pomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.pomapp.databinding.ActivityMainBinding
import com.pomapp.databinding.ActivityTimeBinding

class TimeActivity : AppCompatActivity() {

    lateinit var binding: ActivityTimeBinding

    private lateinit var timer: CountDownTimer
    private var isTimerRunning = false
    private var timeLeftInMillis: Long = 0
    private var currentTime:Long = 0
    private var currentSecuence:Int = 0

    private val WORK_TIME: Long = 25 * 60 * 1000 // 25 minutes
    private val SHORT_BREAK_TIME: Long = 5 * 60 * 1000 // 5 minutes
    private val LONG_BREAK_TIME: Long = 15 * 60 * 1000 // 15 minutes

    private val TEST_TIME_1: Long = 10000 // 2 minutes
    private val TEST_TIME_2: Long = 20000 // 2 minutes
    private val TEST_TIME_3: Long = 30000 // 2 minutes

    private val secuence = arrayOf<Long>(TEST_TIME_1,TEST_TIME_2,TEST_TIME_3)
    //,WORK_TIME,SHORT_BREAK_TIME,WORK_TIME,SHORT_BREAK_TIME,WORK_TIME,SHORT_BREAK_TIME,WORK_TIME

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentTime = secuence[0]

        //Iniciar Temporizador
        startTimer()
        isTimerRunning = true

        binding.btnTimePause.setOnClickListener {
            // Pausar Contador
            if(isTimerRunning){
                pauseTimer()
            }else {
                startTimer()
            }
        }
    }

    private fun startTimer() {

        timeLeftInMillis = currentTime

        timer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }

            override fun onFinish() {
                // Aquí puedes manejar el cambio entre las etapas del Pomodoro
                if(secuence.size == currentSecuence){
                    //Termino el Pomodoro
                }else {
                    currentSecuence++
                    currentTime = secuence[currentSecuence]
                    startTimer()
                }
            }
        }.start()

        isTimerRunning = true
        //startButton.text = "Pause"
    }

    private fun pauseTimer() {
        currentTime = timeLeftInMillis
        timer.cancel()
        isTimerRunning = false
        //startButton.text = "Start"
    }
    private fun updateCountDownText() {
        val minutes = (timeLeftInMillis / 1000) / 60
        val seconds = (timeLeftInMillis / 1000) % 60

        val timeLeftFormatted = String.format("%02d:%02d", minutes, seconds)
        binding.tvTimeTiempo.text = timeLeftFormatted
    }

}