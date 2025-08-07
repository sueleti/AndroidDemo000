package com.sueleti.androiddemo000

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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
            MessaggeCard(Message("Android", "Jetpack Compose"))
        }
    }
}

data class Message(val author: String, val body: String)

/** A fin de que una función admita composición, debes agregar la anotación @Composable.
 * Para probarlo, define una función MessageCard a la que se le da un nombre que usa para configurar el elemento de texto.
 */
@Composable
fun MessaggeCard(msg: Message) {
    Row (modifier = Modifier.padding(all = 10.dp)){
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier.size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(text = msg.author)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }

}




