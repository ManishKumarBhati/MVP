package com.bmk.daggerproject.ui.about

import com.bmk.daggerproject.R
import com.bmk.daggerproject.databinding.ItemPlayersBinding
import com.xwray.groupie.databinding.BindableItem

class PlayersItem(val data: String) : BindableItem<ItemPlayersBinding>() {
    override fun getLayout(): Int {
        return R.layout.item_players
    }

    override fun bind(viewBinding: ItemPlayersBinding, position: Int) {
        viewBinding.apply {
            /*tvName.apply {
                text = "${data.nameFull}"
                setTextColor(ContextCompat.getColor(root.context, R.color.black))
                typeface = Typeface.DEFAULT_BOLD
            }

            data.Iscaptain?.let {
                tvName.text = "${data.nameFull} (c)"
                root.setBackgroundColor(
                    ContextCompat.getColor(
                        root.context,
                        R.color.colorAccent
                    )
                )
            }*/
        }
    }
}