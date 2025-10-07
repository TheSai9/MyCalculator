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
    // main layout for the whole calculator  screen
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // The big number display at the top
        Text(
            text = vm.displayText.value,
            fontSize = 60.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )

        // Space between the display and buttons
        Spacer(Modifier.height(16.dp))

        // All the calculator buttons
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // First row: clear and main operators
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CalculatorButton(text = "C", modifier = Modifier.weight(2f)) {
                    vm.onEvent(CalculatorEvent.Clear)
                }
                CalculatorButton(text = "/", modifier = Modifier.weight(1f)) {
                    vm.onEvent(CalculatorEvent.Operation("/"))
                }
                CalculatorButton(text = "*", modifier = Modifier.weight(1f)) {
                    vm.onEvent(CalculatorEvent.Operation("*"))
                }
            }

            // Second row: 7, 8, 9, and minus
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CalculatorButton(text = "7", modifier = Modifier.weight(1f)) {
                    vm.onEvent(CalculatorEvent.Number(7))
                }
                CalculatorButton(text = "8", modifier = Modifier.weight(1f)) {
                    vm.onEvent(CalculatorEvent.Number(8))
                }
                CalculatorButton(text = "9", modifier = Modifier.weight(1f)) {
                    vm.onEvent(CalculatorEvent.Number(9))
                }
                CalculatorButton(text = "-", modifier = Modifier.weight(1f)) {
                    vm.onEvent(CalculatorEvent.Operation("-"))
                }
            }

            // Third row: 4, 5, 6, and plus
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CalculatorButton(text = "4", modifier = Modifier.weight(1f)) {
                    vm.onEvent(CalculatorEvent.Number(4))
                }
                CalculatorButton(text = "5", modifier = Modifier.weight(1f)) {
                    vm.onEvent(CalculatorEvent.Number(5))
                }
                CalculatorButton(text = "6", modifier = Modifier.weight(1f)) {
                    vm.onEvent(CalculatorEvent.Number(6))
                }
                CalculatorButton(text = "+", modifier = Modifier.weight(1f)) {
                    vm.onEvent(CalculatorEvent.Operation("+"))
                }
            }

            // Last section: 1–3, 0, decimal, and equals
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // Left side: numbers and the dot
                Column(
                    modifier = Modifier.weight(3f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        CalculatorButton(text = "1", modifier = Modifier.weight(1f)) {
                            vm.onEvent(CalculatorEvent.Number(1))
                        }
                        CalculatorButton(text = "2", modifier = Modifier.weight(1f)) {
                            vm.onEvent(CalculatorEvent.Number(2))
                        }
                        CalculatorButton(text = "3", modifier = Modifier.weight(1f)) {
                            vm.onEvent(CalculatorEvent.Number(3))
                        }
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        CalculatorButton(text = "0", modifier = Modifier.weight(2f)) {
                            vm.onEvent(CalculatorEvent.Number(0))
                        }
                        CalculatorButton(text = ".", modifier = Modifier.weight(1f)) {
                            vm.onEvent(CalculatorEvent.Decimal)
                        }
                    }
                }

                // Right side: equals button
                CalculatorButton(text = "=", modifier = Modifier.weight(1f)) {
                    vm.onEvent(CalculatorEvent.Calculate)
                }
            }
        }
    }
}

fun CalculatorButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    // One single calculator button
    Button(
        onClick = onClick,
        modifier = modifier
            .aspectRatio(1f) // Keeps the button square
            .padding(4.dp)
    ) {
        // The text inside the button
        Text(text = text, fontSize = 24.sp)
    }
}
```
