package com.sueleti.androiddemo000

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/** setContent is a function that sets the content view of the activity to a composable function.
 * In this case, it sets the content to a Text composable that displays "Hello world!".
 * The MainActivity class extends ComponentActivity, which is a base class for activities that use Jetpack Compose.
 * The onCreate method is overridden to set the content when the activity is created.
 * The Text composable is part of the Material3 library, which provides Material Design components for Compose.
 * The Text composable is used to display text on the screen, and it takes a string as a parameter.
 * In this case, the string is "Hello world!", which will be displayed when the app is run.
 * This is a simple example of how to use Jetpack Compose to create a basic Android app with a single text view.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessaggeCard("Android")
        }
    }
}

/** A fin de que una función admita composición, debes agregar la anotación @Composable.
 * Para probarlo, define una función MessageCard a la que se le da un nombre que usa para configurar el elemento de texto.
 */
@Composable
fun MessaggeCard(name: String) {
    Text(text = "Hello $name!")
}




