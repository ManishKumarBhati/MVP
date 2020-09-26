package com.bmk.daggerproject.ui.list

import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.ScaleAnimation
import com.bmk.daggerproject.R
import com.bmk.daggerproject.databinding.ItemPlayersBinding
import com.bmk.daggerproject.domain.ItemList
import com.bmk.daggerproject.util.setImage
import com.xwray.groupie.databinding.BindableItem

class ListItem(val data: ItemList) : BindableItem<ItemPlayersBinding>() {

    var like: Int = data.actionCounts?.like ?: 0

    override fun getLayout(): Int {
        return R.layout.item_players
    }

    override fun bind(viewBinding: ItemPlayersBinding, position: Int) {
        viewBinding.apply {
            tvName.text = data.title
            tvInfo.text = data.description

            tvLikes.text = "$like likes"
            tvViews.text = "${data.actionCounts?.webClick} Views"
            tvMessage.text = data.expert?.shortBio
            tvPeriod.text = data.publishedAt
            val scaleAnimation = ScaleAnimation(
                0.7f,
                1.0f,
                0.7f,
                1.0f,
                Animation.RELATIVE_TO_SELF,
                0.7f,
                Animation.RELATIVE_TO_SELF,
                0.7f
            )
            scaleAnimation.duration = 500
            val bounceInterpolator = BounceInterpolator()
            scaleAnimation.interpolator = bounceInterpolator
            data.expert?.profilePic?.let { ivDp.setImage(it) }
            if (data.thumbnail != null) ivUploadImg.setImage(data.thumbnail)
            else ivUploadImg.setImageResource(R.drawable.ic_image)
            ivLike.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) like += 1 else like -= 1
                tvLikes.text = "$like likes"

                buttonView.startAnimation(
                    scaleAnimation
                )
            }
        }
    }

    override fun getId(): Long {
        return data.hashCode().toLong()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ListItem

        if (data != other.data) return false

        return true
    }

    override fun hashCode(): Int {
        var result = data.hashCode()
        result = 31 * result + data.hashCode()
        return result
    }
}