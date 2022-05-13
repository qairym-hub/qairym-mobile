package com.qairym.presentation.home.bottomnavbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.qairym.presentation.destinations.DirectionDestination
import com.qairym.presentation.destinations.HomeScreenDestination
import com.qairym.presentation.destinations.ProfileScreenDestination

enum class BottomBarDestination(
    val direction: DirectionDestination,
    val icon: ImageVector,
    val label: String,
) {
    Home(HomeScreenDestination, Icons.Default.Home, "Home"),
    Profile(ProfileScreenDestination, Icons.Default.Person, "Profile")
}
