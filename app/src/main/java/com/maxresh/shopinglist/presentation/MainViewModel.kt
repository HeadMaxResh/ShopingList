package com.maxresh.shopinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maxresh.shopinglist.data.ShopListRepositoryImpl
import com.maxresh.shopinglist.domain.DeleteShopItemUseCase
import com.maxresh.shopinglist.domain.EditShopItemUseCase
import com.maxresh.shopinglist.domain.GetShopListUseCase
import com.maxresh.shopinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
        getShopList()
    }

    fun changeIsActiveState(shopItem: ShopItem) {
        val newItem = shopItem.copy(isActive = !shopItem.isActive)
        editShopItemUseCase.editShopItem(newItem)
        getShopList()
    }
}