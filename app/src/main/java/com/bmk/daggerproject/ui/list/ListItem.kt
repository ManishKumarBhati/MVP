package com.bmk.daggerproject.ui.list

import com.bmk.daggerproject.R
import com.bmk.daggerproject.databinding.ItemLayoutBinding
import com.bmk.daggerproject.models.Post
import com.xwray.groupie.databinding.BindableItem

class ListItem(val data: Post) : BindableItem<ItemLayoutBinding>() {
    override fun getLayout() = R.layout.item_layout

    override fun bind(viewBinding: ItemLayoutBinding, position: Int) {
        viewBinding.apply {
            itemTitle.text = data.title
            itemBody.text = data.body
        }
    }
}