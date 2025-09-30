package com.example.rowcoldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rowcoldemo.ui.theme.RowColDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RowColDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier){
    Column(modifier){
        Row{
            Column{
                TextCell("1")
                TextCell("2")
                TextCell("3")
            }
            Column{
                TextCell("4")
                TextCell("5")
                TextCell("6")
            }
            Column{
                TextCell("7")
                TextCell("8")
            }
        }
        Row{
            TextCell("9")
            TextCell("10")
            TextCell("11")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RowColDemoTheme{
        MainScreen()
    }
}

@Composable
fun TextCell(text: String, modifier: Modifier = Modifier){
    val cellModifier = modifier
        .padding(4.dp)
        .size(100.dp,100.dp)
        .border(width = 4.dp, color = Color.Black)
    Text(text = text, cellModifier.then(modifier),
        fontSize = 80.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center)
}