package com.example.freecustomerdev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.example.freecustomerdev.ui.AnnouncementScreen
import com.example.freecustomerdev.ui.theme.FreeCustomerDevTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreeCustomerDevTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    AnnouncementScreen()
                }
            }
        }
    }
}
