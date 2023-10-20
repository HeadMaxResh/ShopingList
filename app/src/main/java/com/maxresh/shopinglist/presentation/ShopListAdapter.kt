package com.maxresh.shopinglist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.maxresh.shopinglist.R
import com.maxresh.shopinglist.domain.ShopItem

class ShopListAdapter : androidx.recyclerview.widget.ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {

    var onShopItemClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_ACTIVE -> R.layout.item_shop_active
            VIEW_TYPE_INACTIVE -> R.layout.item_shop_inactive
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent,false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)

        viewHolder.tvName.text = shopItem.name
        viewHolder.tvCount.text = shopItem.count.toString()

        viewHolder.view.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
            true
        }
        viewHolder.view.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }

    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.isActive) {
            VIEW_TYPE_ACTIVE
        } else {
            VIEW_TYPE_INACTIVE
        }
    }

    companion object {

        const val VIEW_TYPE_ACTIVE = 100
        const val VIEW_TYPE_INACTIVE = 101

        const val MAX_POOL_SIZE = 30
    }
}