package com.maxresh.shopinglist.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maxresh.shopinglist.domain.ShopItem

@Entity(tableName = "shop_items")
data class ShopItemDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val count: Int,
    val isActive: Boolean
)