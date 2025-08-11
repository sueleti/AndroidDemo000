package com.sueleti.androiddemo000

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sueleti.androiddemo000.ui.theme.AndroidDemo000Theme

/**
 * MainActivity is the entry point of the Android application.
 * It sets the content view to the DemoScreen composable function,
 * which displays a text field and a slider.
 * The text field allows the user to input a number,
 * and the slider reflects that number as a float value.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidDemo000Theme {
                DemoScreen()
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun PreviewDemoScreen() {
    AndroidDemo000Theme {
        DemoScreen()
    }
}
@Composable
fun DemoScreen(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("50") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Texto(text = text, actualizaTexto = { text = it })
        Spacer(modifier = Modifier.height(150.dp))
        Deslizador(
            valor = text.toIntOrNull()?.toFloat() ?: 20f
        )
    }
}
@Composable
fun Texto(text: String, actualizaTexto: (String) -> Unit
){
    TextField(
        value = text,
        onValueChange = actualizaTexto,
        label = { Text("Enter text") },
        modifier = Modifier.padding(16.dp)
    )
}
@Composable
fun Deslizador(
    valor: Float
) {
    Slider(
        modifier = Modifier.padding(10.dp),
        valueRange = 0f..100f,
        value = valor,
        onValueChange = {}
    )
}






