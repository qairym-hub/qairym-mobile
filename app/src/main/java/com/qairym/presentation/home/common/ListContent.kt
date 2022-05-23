package com.qairym.presentation.home.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.qairym.data.model.Post

@Composable
fun ListContent(items: LazyPagingItems<Post>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = items,
            key = { post ->
                post.postId
            }
        ) { post ->
            post?.let { PostItem(post = post) }
        }
    }
}

@Composable
fun PostItem(post: Post) {
    
    Box(
        modifier = Modifier
            .clickable {

            }
            .height(100.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(text = post.title)
    }
}