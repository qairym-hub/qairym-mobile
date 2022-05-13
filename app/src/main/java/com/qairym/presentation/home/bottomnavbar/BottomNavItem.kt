package com.qairym.presentation.home.bottomnavbar

import androidx.compose.ui.graphics.vector.ImageVector
import com.ramcosta.composedestinations.spec.Direction

data class BottomNavItem(
    val name: String,
    val destination: Direction,
    val icon: ImageVector,
    val badgeCount: Int = 0
)