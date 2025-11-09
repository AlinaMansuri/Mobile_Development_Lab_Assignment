// MainActivity.kt placeholder 
package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvInput: TextView
    private var currentInput = ""
    private var lastNumeric = false
    private var lastDot = false
    private val helper = CalculatorHelper() // Java class usage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        buttons.forEach {
            findViewById<Button>(it).setOnClickListener {
                val text = (it as Button).text.toString()
                currentInput += text
                tvInput.text = currentInput
                lastNumeric = true
            }
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            currentInput = ""
            tvInput.text = ""
            lastNumeric = false
            lastDot = false
        }

        findViewById<Button>(R.id.btnPlus).setOnClickListener { appendOperator("+") }
        findViewById<Button>(R.id.btnMinus).setOnClickListener { appendOperator("-") }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { appendOperator("*") }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { appendOperator("/") }

        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            val result = helper.calculateResult(currentInput)
            tvInput.text = result
            currentInput = result
        }
    }

    private fun appendOperator(op: String) {
        if (lastNumeric) {
            currentInput += op
            tvInput.text = currentInput
            lastNumeric = false
            lastDot = false
        }
    }
}
