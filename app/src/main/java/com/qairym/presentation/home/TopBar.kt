package com.qairym.presentation.home

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TopBar(title: String) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = MaterialTheme.colors.background
            )
        },
        backgroundColor = MaterialTheme.colors.primary,

    )
}

@Composable
@Preview
fun HomeTopBarPreview() {
    TopBar("Home")
}