// In CalculatorViewModel.kt
package com.example.mycalculatorandriod

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    // The text displayed on the calculator screen
    val displayText = mutableStateOf("0")

    private var number1: Double? = null
    private var number2: Double? = null
    private var operation: String? = null

    fun onEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.Number -> processNumber(event.number)
            is CalculatorEvent.Operation -> processOperation(event.op)
            is CalculatorEvent.Decimal -> processDecimal()
            is CalculatorEvent.Clear -> clear()
            is CalculatorEvent.Calculate -> calculate()
        }
    }

    private fun processNumber(number: Int) {
        if (displayText.value == "0") {
            displayText.value = number.toString()
        } else {
            displayText.value += number.toString()
        }
    }

    private fun processOperation(op: String) {
        number1 = displayText.value.toDoubleOrNull()
        operation = op
        displayText.value = "0" // Reset display for the next number
    }

    private fun processDecimal() {
        if (!displayText.value.contains(".")) {
            displayText.value += "."
        }
    }

    private fun clear() {
        displayText.value = "0"
        number1 = null
        number2 = null
        operation = null
    }

    private fun calculate() {
        number2 = displayText.value.toDoubleOrNull()
        val n1 = number1
        val n2 = number2
        if (n1 != null && n2 != null && operation != null) {
            val result = when (operation) {
                "+" -> n1 + n2
                "-" -> n1 - n2
                "*" -> n1 * n2
                "/" -> if (n2 != 0.0) n1 / n2 else Double.NaN // Handle division by zero
                else -> 0.0
            }

            // Display as Integer if it's a whole number, otherwise as Double
            if (result.isNaN()) {
                displayText.value = "Error"
            } else if (result % 1.0 == 0.0) {
                displayText.value = result.toInt().toString()
            } else {
                displayText.value = result.toString()
            }
        }
        operation = null // Ready for a new calculation
    }
}

// Define the events our calculator can handle
sealed class CalculatorEvent {
    data class Number(val number: Int) : CalculatorEvent()
    data class Operation(val op: String) : CalculatorEvent()
    object Decimal : CalculatorEvent()
    object Clear : CalculatorEvent()
    object Calculate : CalculatorEvent()
}
