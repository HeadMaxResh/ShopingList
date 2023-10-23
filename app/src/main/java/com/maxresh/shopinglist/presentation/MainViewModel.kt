package com.maxresh.shopinglist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxresh.shopinglist.data.ShopListRepositoryImpl
import com.maxresh.shopinglist.domain.DeleteShopItemUseCase
import com.maxresh.shopinglist.domain.EditShopItemUseCase
import com.maxresh.shopinglist.domain.GetShopListUseCase
import com.maxresh.shopinglist.domain.ShopItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }

    fun changeIsActiveState(shopItem: ShopItem) {
        viewModelScope.launch {
            val newItem = shopItem.copy(isActive = !shopItem.isActive)
            editShopItemUseCase.editShopItem(newItem)
        }
    }
}