package com.wdh.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wdh.bmi_calculator.databinding.ActivityResultBinding
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    private lateinit var binding:ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityResultBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setResult()
    }

    private fun setResult(){
        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        val bmi = weight / ((height / 100.0).pow(2.0))

        val resultText = when{
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }

        binding.bmiResultTextView.text = bmi.toString()
        binding.resultTextView.text = resultText
    }
}