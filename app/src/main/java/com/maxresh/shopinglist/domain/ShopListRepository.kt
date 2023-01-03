package com.maxresh.shopinglist.domain

interface ShopListRepository {
    fun addShopItem(ShopItem: ShopItem)
    fun deleteShopItem(ShopItem: ShopItem)
    fun editShopItem(ShopItem: ShopItem)
    fun getShopItem(ShopItem: Int): ShopItem
    fun getShopList(): List<ShopItem>
}