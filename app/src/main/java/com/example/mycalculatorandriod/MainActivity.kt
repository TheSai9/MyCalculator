package com.example.mycalculatorandriod

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.mycalculatorandriod.ui.theme.MyCalculatorAndriodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // makes theapp use the whole screen area
        enableEdgeToEdge()

        // Sets up the main UI of the app
        setContent {
            // Wrap everything in the app’s theme
            MyCalculatorAndriodTheme {
                // Basic layout structure for the screen
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // The main calculator screen goes here
                    CalculatorScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
```
