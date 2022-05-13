package com.qairym.presentation.home.bottomnavbar

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.qairym.presentation.NavGraphs
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popUpTo
import com.ramcosta.composedestinations.utils.isRouteOnBackStack

@Composable
fun BottomBar(
    navController: NavController,
) {
    BottomNavigation {
        BottomBarDestination.values().forEach { destination ->
            val isCurrentDestOnBackStack = navController.isRouteOnBackStack(destination.direction)
            BottomNavigationItem(
                selected = isCurrentDestOnBackStack,
                onClick = {
                    navController.navigate(destination.direction) {
//                        if (isCurrentDestOnBackStack) {
//                            navController.popBackStack(destination.direction, false)
//                            return
//                        }
                        popUpTo(NavGraphs.root) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(destination.icon, contentDescription = destination.label) },
                label = { Text(destination.label) },
            )
        }
    }
}