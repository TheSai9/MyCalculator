package com.example.mycalculatorandriod

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    // What shows up on the calculator screen
    val displayText = mutableStateOf("0")

    // Stores the first number, second number, and the math operation
    private var number1: Double? = null
    private var number2: Double? = null
    private var operation: String? = null

    // Handles all the button events from the UI
    fun onEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.Number -> processNumber(event.number)
            is CalculatorEvent.Operation -> processOperation(event.op)
            is CalculatorEvent.Decimal -> processDecimal()
            is CalculatorEvent.Clear -> clear()
            is CalculatorEvent.Calculate -> calculate()
        }
    }

    // When a number button is pressed
    private fun processNumber(number: Int) {
        if (displayText.value == "0") {
            // Replace the 0 with the new number
            displayText.value = number.toString()
        } else {
            // Add the new number to the end
            displayText.value += number.toString()
        }
    }

    // When an operator like + or - is pressed
    private fun processOperation(op: String) {
        number1 = displayText.value.toDoubleOrNull()
        operation = op
        // Reset screen so the user can type the next number
        displayText.value = "0"
    }

    // Adds a decimal point if there isn’t one already
    private fun processDecimal() {
        if (!displayText.value.contains(".")) {
            displayText.value += "."
        }
    }

    // Clears everything and resets to default
    private fun clear() {
        displayText.value = "0"
        number1 = null
        number2 = null
        operation = null
    }

    // Runs the calculation when "=" is pressed
    private fun calculate() {
        number2 = displayText.value.toDoubleOrNull()
        val n1 = number1
        val n2 = number2

        if (n1 != null && n2 != null && operation != null) {
            val result = when (operation) {
                "+" -> n1 + n2
                "-" -> n1 - n2
                "*" -> n1 * n2
                "/" -> if (n2 != 0.0) n1 / n2 else Double.NaN // handles the case of the devide by zero
                else -> 0.0
            }

            // Show whole numbers without a decimal point
            if (result.isNaN()) {
                displayText.value = "Error"
            } else if (result % 1.0 == 0.0) {
                displayText.value = result.toInt().toString()
            } else {
                displayText.value = result.toString()
            }
        }

        // Reset operation so a new one can start
        operation = null
    }
}

// The different kinds of button actions the calculator can handle
sealed class CalculatorEvent {
    data class Number(val number: Int) : CalculatorEvent()
    data class Operation(val op: String) : CalculatorEvent()
    object Decimal : CalculatorEvent()
    object Clear : CalculatorEvent()
    object Calculate : CalculatorEvent()
}
