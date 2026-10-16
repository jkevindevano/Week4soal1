package com.example.week4vp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.week4vp.ui.theme.Week4vpTheme
import com.example.week4vp.ui.screen.CarListScreen
import com.example.week4vp.viewmodel.CarViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Surface(
                modifier = Modifier.fillMaxSize().padding(top = 8.dp),
                color = Color(0xFFF5F5F7)
            ) {
                val viewModel: CarViewModel = viewModel()
                CarListScreen(viewModel = viewModel)
            }
        }
    }
}



