package com.bmk.daggerproject.ui.list

import com.bmk.daggerproject.R
import com.bmk.daggerproject.databinding.ItemPlayersBinding
import com.bmk.daggerproject.domain.ItemList
import com.bmk.daggerproject.util.setImage
import com.xwray.groupie.databinding.BindableItem

class ListItem(val data: ItemList) : BindableItem<ItemPlayersBinding>() {
    override fun getLayout(): Int {
        return R.layout.item_players
    }

    override fun bind(viewBinding: ItemPlayersBinding, position: Int) {
        viewBinding.apply {
            data.expert?.profilePic?.let { ivDp.setImage(it) }
            tvName.text = data.title
            tvInfo.text = data.description
            if (data.thumbnail != null) ivUploadImg.setImage(data.thumbnail)
            else ivUploadImg.setImageResource(R.drawable.ic_image)
            val like = data.actionCounts?.like ?: 0
            tvLikes.text = "$like likes"
            tvViews.text = "${data.actionCounts?.webClick} Views"
            tvMessage.text = data.expert?.shortBio
            tvPeriod.text = data.publishedAt
        }
    }
}