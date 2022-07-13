package com.wayne.interestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var inputOne: EditText = findViewById(R.id.principle)
        var inputTwo: EditText = findViewById(R.id.rate)
        var inputThree: EditText = findViewById(R.id.period)
        var myButton: Button = findViewById(R.id.calculate)
        var myResult: TextView = findViewById(R.id.amount)

        myButton.setOnClickListener {
            var firstNumber = inputOne.text.toString().trim()
            var secondNumber = inputTwo.text.toString().trim()
            var thirdNumber = inputThree.text.toString().trim()

            if (firstNumber.isEmpty() || secondNumber.isEmpty() || thirdNumber.isEmpty()) {
                Toast.makeText(applicationContext, "Please enter required values", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try{
                var amount = firstNumber.toDouble()
                var rate = secondNumber.toDouble()
                var period = thirdNumber.toDouble()

                var rateOne = (rate/100)+1
                var power = rateOne.toDouble().pow(period)
                var interest = amount * power

                myResult.text = "Total Amount is ${interest.toInt()}"


            }catch (e:Exception){
                Toast.makeText(applicationContext, "Please enter valid values", Toast.LENGTH_SHORT).show()
            }



        }








    }
}