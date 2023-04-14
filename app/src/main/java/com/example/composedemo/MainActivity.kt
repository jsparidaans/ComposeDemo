package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.ui.theme.ComposeDemoTheme

// Activity is still the entry point for the app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Entry point to Compose
        setContent {
            // Themes are a way to style composable functions
            ComposeDemoTheme {
                // Reusable composable, this cleans up the onCreate function and allows us to use
                // composable elsewhere as well
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

// Best practice when extracting a reusable composable is to always give it a modifier with a default value
@Composable
fun MyApp(modifier: Modifier = Modifier) {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Greeting("Android")
    }
}

// Composables are denoted with this annotation. It enables a function to call other @Composable functions within
@Composable
fun Greeting(name: String) {
    Surface(color = MaterialTheme.colorScheme.primary) {
        // Note how the text automatically changed color from black to white
        Text(
            text = "Hello $name!",
            modifier = Modifier
                // add a padding on al sides of 24dp
                .padding(24.dp)
        )
    }
}

// This annotation allows us to preview our composables in the IDE
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDemoTheme {
        MyApp()
    }
}