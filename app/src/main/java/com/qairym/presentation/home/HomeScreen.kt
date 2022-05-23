package com.qairym.presentation.home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi

@ExperimentalPagingApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state = viewModel.state

    Scaffold(
        topBar = { TopBar("Home") },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 50.dp)
            ) {
                items(state.items.size) { i ->
                    val item = state.items[i]
                    if (i >= state.items.size - 1 && !state.endReached && !state.isLoading) {
                        viewModel.loadNextItems()
                    }
                    Column(
                        modifier = Modifier
                            .border(1.dp, Color.Black)
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 12.dp)
                    ) {
                        Box(
                            modifier = Modifier.wrapContentSize(),
                        ) {
                            Text(
                                text = item.title,
                                fontSize = 20.sp,
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row {
                            Text(text = item.text)
                        }
                    }
                }
                item {
                    if (state.isLoading) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }
    )
}

@Composable
@Preview
fun Post() {
    Column(
        modifier = Modifier
            .border(1.dp, Color.Black)
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp)

    ) {
        Box(
            modifier = Modifier.wrapContentSize(),
        ) {
            Text(
                text = "Title of post",
                fontSize = 20.sp,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(text = "Post text")
        }
    }
}