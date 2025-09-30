package com.example.rowcoldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
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
    Column{
        Row(modifier = modifier.height(300.dp)){
            TextCell("1", Modifier.align(Alignment.Top))
            TextCell("2", Modifier.align(Alignment.CenterVertically))
            TextCell("3", Modifier.align(Alignment.Bottom))
        }
        Spacer(Modifier.padding(16.dp))
        Row{
            Text(
                text = "Large Text",
                Modifier.alignByBaseline(),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Small Text",
                Modifier.alignByBaseline(),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(Modifier.padding(16.dp))
        Row{
            Text(
                text = "Large Text\n\nMore Text",
                Modifier.alignBy(LastBaseline),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Small Text",
                Modifier.alignByBaseline(),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(Modifier.padding(16.dp))
        Row{
            Text(
                text = "Large Text\n\nMore Text",
                Modifier.alignBy(FirstBaseline),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Small Text",
                modifier = Modifier.paddingFrom(
                    alignmentLine = FirstBaseline, before = 80.dp, after = 0.dp),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
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