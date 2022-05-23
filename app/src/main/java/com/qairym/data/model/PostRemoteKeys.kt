package com.qairym.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.qairym.common.Constants.POST_REMOTE_KEYS_TABLE

@Entity(tableName = POST_REMOTE_KEYS_TABLE)
data class PostRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
)
