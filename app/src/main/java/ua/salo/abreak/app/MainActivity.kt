package ua.salo.abreak.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import ua.salo.abreak.app.ui.theme.BreakTheme
import ua.salo.abreak.domain.model.Break

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BreakTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TestScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TestScreen(
    modifier: Modifier = Modifier,
    breakViewModel: BreakViewModel = hiltViewModel()
) {
    Box() {
        Button(
            modifier = Modifier.padding(
                top = 120.dp,
                start = 48.dp
            ),
            onClick = {
                breakViewModel.addBreak(
                    Break(
                        name = "ddd",
                        content = "ddd",
                        timestamp = System.currentTimeMillis()
                    )
                )
            }
        ) {
            Text(
                text = "Add new break"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestScreenPreview() {
    BreakTheme {
        TestScreen()
    }
}