package com.muratdayan.auron

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.muratdayan.auron.navigation.AuronNavRoot
import com.muratdayan.auron.core_ui.ui.theme.AuronTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AuronTheme {
                AuronNavRoot()
            }
        }
    }
}

