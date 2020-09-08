package com.bmk.daggerproject.ui.about

import com.bmk.daggerproject.R
import com.bmk.daggerproject.databinding.ItemPlayersBinding
import com.bmk.daggerproject.domain.PlayersInfo
import com.xwray.groupie.databinding.BindableItem

class PlayersItem(val data: PlayersInfo) : BindableItem<ItemPlayersBinding>() {
    override fun getLayout(): Int {
        return R.layout.item_players
    }

    override fun bind(viewBinding: ItemPlayersBinding, position: Int) {
        viewBinding.apply {
            tvName.text = "Name: ${data.nameFull}"
            tvPos.text = "Pos:${data.position}"
        }
    }
}