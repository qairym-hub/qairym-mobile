package com.qairym.presentation.home

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.qairym.presentation.ui.theme.Shapes

@Composable
fun ProfileScreen() {

    val context = LocalContext.current

    Scaffold(
        topBar = { TopBar("Profile") },
        content = {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = {
                        setFirstIcon(context)
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Blue
                    ),
                    shape = Shapes.large,
                    modifier = Modifier.wrapContentSize()
                ) {
                    Text(
                        text = "Set 1 Icon",
                        style = MaterialTheme.typography.body2,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {
                        setSecondIcon(context)
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Blue
                    ),
                    shape = Shapes.large,
                    modifier = Modifier.wrapContentSize()
                ) {
                    Text(
                        text = "Set 2 Icon",
                        style = MaterialTheme.typography.body2,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }
            }
        }
    )
}

fun setFirstIcon(context: Context) {
    context.packageManager.setComponentEnabledSetting(ComponentName(context,
        com.qairym.presentation.widget.OneLauncherAlias::class.java),
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP)
    context.packageManager.setComponentEnabledSetting(ComponentName(context,
        com.qairym.presentation.widget.TwoLauncherAlias::class.java),
        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
        PackageManager.DONT_KILL_APP)
}

fun setSecondIcon(context: Context) {
    context.packageManager.setComponentEnabledSetting(ComponentName(context,
        com.qairym.presentation.widget.OneLauncherAlias::class.java),
        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
        PackageManager.DONT_KILL_APP)
    context.packageManager.setComponentEnabledSetting(ComponentName(context,
        com.qairym.presentation.widget.TwoLauncherAlias::class.java),
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP)
}