// In CalculatorScreen.kt
package com.example.mycalculatorandriod

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CalculatorScreen(modifier: Modifier = Modifier, vm: CalculatorViewModel = viewModel()) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display Text
        Text(
            text = vm.displayText.value,
            fontSize = 60.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )
        Spacer(Modifier.height(16.dp))

        // Calculator Buttons Grid
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Row 1
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CalculatorButton(text = "C", modifier = Modifier.weight(2f)) { vm.onEvent(CalculatorEvent.Clear) }
                CalculatorButton(text = "/", modifier = Modifier.weight(1f)) { vm.onEvent(CalculatorEvent.Operation("/")) }
                CalculatorButton(text = "*", modifier = Modifier.weight(1f)) { vm.onEvent(CalculatorEvent.Operation("*")) }
            }
            // Row 2
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CalculatorButton(text = "7", modifier = Modifier.weight(1f)) { vm.onEvent(CalculatorEvent.Number(7)) }
                CalculatorButton(text = "8", modifier = Modifier.weight(1f)) { vm.onEvent(CalculatorEvent.Number(8)) }
                CalculatorButton(text = "9", modifier = Modifier.weight(1f)) { vm.onEvent(CalculatorEvent.Number(9)) }
                CalculatorButton(text = "-", modifier = Modifier.weight(1f)) { vm.onEvent(CalculatorEvent.Operation("-")) }
            }
            // Row 3
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CalculatorButton(text = "4", modifier = Modifier.weight(1f)) { vm.onEvent(CalculatorEvent.Number(4)) }
                CalculatorButton(text = "5", modifier = Modifier.weight(1f)) { vm.onEvent(CalculatorEvent.Number(5)) }
                CalculatorButton(text = "6", modifier = Modifier.weight(1f)) { vm.onEvent(CalculatorEvent.Number(6)) }
                CalculatorButton(text = "+", modifier = Modifier.weight(1f)) { vm.onEvent(CalculatorEvent.Operation("+")) }
            }
            // Row 4 & 5 combined
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Column(
                    modifier = Modifier.weight(3f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        CalculatorButton(text = "1", modifier = Modifier.weight(1f)) { vm.onEvent(CalculatorEvent.Number(1)) }
                        CalculatorButton(text = "2", modifier = Modifier.weight(1f)) { vm.onEvent(CalculatorEvent.Number(2)) }
                        CalculatorButton(text = "3", modifier = Modifier.weight(1f)) { vm.onEvent(CalculatorEvent.Number(3)) }
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        CalculatorButton(text = "0", modifier = Modifier.weight(2f)) { vm.onEvent(CalculatorEvent.Number(0)) }
                        CalculatorButton(text = ".", modifier = Modifier.weight(1f)) { vm.onEvent(CalculatorEvent.Decimal) }
                    }
                }
                CalculatorButton(text = "=", modifier = Modifier.weight(1f)) { vm.onEvent(CalculatorEvent.Calculate) }
            }
        }
    }
}

@Composable
fun CalculatorButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(onClick = onClick, modifier = modifier.aspectRatio(1f).padding(4.dp)) {
        Text(text = text, fontSize = 24.sp)
    }
}
