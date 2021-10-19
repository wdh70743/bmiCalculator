package com.wdh.bmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.wdh.bmi_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getResult()
    }

    private fun getResult(){
        binding.resultButton.setOnClickListener {

            if (binding.heightEditText.text.isBlank() || binding.weightEditText.text.isBlank()){
                Toast.makeText(this, "값을 입력해주세요", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val height:Int = binding.heightEditText.text.toString().toInt()
            val weight:Int = binding.weightEditText.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)
        }
    }

}