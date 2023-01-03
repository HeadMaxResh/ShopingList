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
    private val deleteShopListUseCase = DeleteShopItemUseCase(repository)
    private val editShopListUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }
}