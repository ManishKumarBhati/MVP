package com.bmk.daggerproject.ui.list

import com.bmk.daggerproject.R
import com.bmk.daggerproject.databinding.ItemLayoutBinding
import com.bmk.daggerproject.domain.TeamInfo
import com.xwray.groupie.databinding.BindableItem
import io.reactivex.subjects.PublishSubject

class ListItem(
    val data: TeamInfo,
    val eventSubject: PublishSubject<TeamInfo>
) : BindableItem<ItemLayoutBinding>() {
    override fun getLayout() = R.layout.item_layout

    override fun bind(viewBinding: ItemLayoutBinding, position: Int) {
        viewBinding.apply {
            tvName.text = data.nameFull
            root.setOnClickListener { eventSubject.onNext(data) }
        }
    }
}