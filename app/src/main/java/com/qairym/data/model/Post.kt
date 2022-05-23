package com.qairym.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.qairym.common.Constants.POST_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = POST_TABLE)
data class Post(
    @PrimaryKey(autoGenerate = false)
    val postId: Int,
    val title: String,
    val text: String,
    val createdAt: String,
    @Embedded
    val author: Author,
)
