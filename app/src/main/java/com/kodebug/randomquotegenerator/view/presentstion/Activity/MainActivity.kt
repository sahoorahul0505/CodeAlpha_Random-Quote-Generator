package com.kodebug.randomquotegenerator.view.presentstion.Activity

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.kodebug.randomquotegenerator.ui.theme.RandomQuoteGeneratorTheme
import com.kodebug.randomquotegenerator.view.presentstion.screens.QuoteScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomQuoteGeneratorTheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->

                    Box(modifier = Modifier
                        .background(color = Color(0xFF724fab))
                        .padding(innerPadding)) {
                        QuoteScreen(modifier = Modifier)
                    }
                }
            }
        }
    }
}
