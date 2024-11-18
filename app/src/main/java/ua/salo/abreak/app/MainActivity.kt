package ua.salo.abreak.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import ua.salo.abreak.app.ui.theme.BreakTheme
import ua.salo.abreak.domain.model.Break

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val breakViewModel: BreakViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BreakTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier
                            .padding(innerPadding),
                        breakViewModel = breakViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, breakViewModel: BreakViewModel) {
    Text(
        text = "Hello $name!",
        modifier = modifier.clickable(onClick = {
            breakViewModel.addBreak(
                Break(
                    name = "ddd",
                    content = "ddd",
                    timestamp = 1212L
                )
            )
        })
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    BreakTheme {
//        Greeting("Android")
//    }
//}