package com.sueleti.androiddemo000

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.Arrangement.SpaceEvenly
import androidx.compose.material3.LinearProgressIndicator
import com.sueleti.androiddemo000.ui.theme.AndroidDemo000Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidDemo000Theme {
                ComponentesGrid()
            }
        }
    }
}

@Composable
fun MainScreen(name: String) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        // Quitamos el parámetro snackbarHost del Scaffold
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(padding)) {

            // Posicionamos manualmente el SnackbarHost arriba
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 48.dp)
            )

            // Contenido principal al centro
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Hello $name!")
                Button(onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("¡Hola, $name! Este es un mensaje arriba.")
                    }
                }) {
                    Text("Mostrar mensaje")
                }
            }
        }
    }
}

@Composable
fun ComponentesGrid() {
    var text by remember { mutableStateOf("Hugo") }
    var checked by remember { mutableStateOf(true) }
    var switchOn by remember { mutableStateOf(true) }
    var sliderValue by remember { mutableStateOf(0.6f) }
    var selectedOption by remember { mutableStateOf(2) }
    val options = listOf("Opción 1", "Opción 2", "Opción 3", "Opción 4")
    var expanded by remember { mutableStateOf(false) }
    var dropdownSelected by remember { mutableStateOf(options[1]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Fila 1
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = SpaceEvenly) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("TextField") },
                modifier = Modifier.width(150.dp)
            )
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
            Switch(
                checked = switchOn,
                onCheckedChange = { switchOn = it }
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        // Fila 2
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = SpaceEvenly) {
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                valueRange = 0f..1f,
                modifier = Modifier.width(150.dp)
            )
            Column {
                options.forEachIndexed { i, option ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectedOption == i,
                            onClick = { selectedOption = i }
                        )
                        Text(option)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        // Fila 3
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = SpaceEvenly) {
            Button(onClick = { expanded = true }) {
                Text(dropdownSelected)
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                options.forEach { label ->
                    DropdownMenuItem(text = { Text(label) }, onClick = {
                        dropdownSelected = label
                        expanded = false
                    })
                }
            }
            CircularProgressIndicator(modifier = Modifier.size(40.dp))
            LinearProgressIndicator(
            progress = { sliderValue },
            modifier = Modifier.width(100.dp),
            color = ProgressIndicatorDefaults.linearColor,
            trackColor = ProgressIndicatorDefaults.linearTrackColor,
            strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        // Fila 4
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = SpaceEvenly) {
            Card(modifier = Modifier.size(80.dp)) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text("Card")
                }
            }
            FloatingActionButton(onClick = {}) {
                Text("+")
            }
        }
    }
}
