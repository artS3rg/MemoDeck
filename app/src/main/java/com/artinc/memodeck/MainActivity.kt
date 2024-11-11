package com.artinc.memodeck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.toArgb
import com.artinc.memodeck.ui.layouts.CardsActivity
import com.artinc.memodeck.ui.layouts.HomeActivity
import com.artinc.memodeck.ui.theme.MemoDeckTheme
import com.artinc.memodeck.ui.theme.Orange
import com.artinc.memodeck.ui.theme.Purple

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        window.navigationBarColor = Orange.toArgb()

        setContent {
            MemoDeckTheme {
                CardsActivity()
            }
        }
    }
}