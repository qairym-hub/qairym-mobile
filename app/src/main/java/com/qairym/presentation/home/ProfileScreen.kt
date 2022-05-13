package com.qairym.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.qairym.presentation.home.bottomnavbar.BottomBar
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun ProfileScreen(
    navController: NavController,
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Profile Screen!")
        }
    }
}