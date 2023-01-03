package com.maxresh.shopinglist.domain

interface ShopListRepository {
    fun addShopItem(ShopItemId: Int)
    fun deleteShopItem(ShopItemId: Int)
    fun editShopItem(ShopItemId: Int)
    fun getShopItem(ShopItemId: Int): ShopItem
    fun getShopList(): List<ShopItem>
}