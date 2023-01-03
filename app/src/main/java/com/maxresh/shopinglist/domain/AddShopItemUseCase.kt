package com.maxresh.shopinglist.domain

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopItem(shopItemId: Int) {
        shopListRepository.addShopItem(shopItemId)
    }
}