package com.maxresh.shopinglist.domain

interface ShopListRepository {
    fun addShopItem(ShopItem: ShopItem)
    fun deleteShopItem(ShopItemId: ShopItem)
    fun editShopItem(ShopItemId: ShopItem)
    fun getShopItem(ShopItemId: Int): ShopItem
    fun getShopList(): List<ShopItem>
}