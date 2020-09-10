package com.bmk.daggerproject.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.bmk.daggerproject.domain.TeamInfo
import com.bmk.daggerproject.ui.about.PlayerFragment

class PagerAdapter(fm: FragmentManager, val data: List<TeamInfo>) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PlayerFragment.newInstance(data[position].nameFull)
            1 -> PlayerFragment.newInstance(data[position].nameFull)
            else -> error("Invalid position $position")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return data[position].nameShort
    }

    override fun getCount(): Int {
        return data.size
    }

}