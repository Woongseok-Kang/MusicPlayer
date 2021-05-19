package com.woong.musicplayer.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.woong.musicplayer.fragment.AllListFragment
import com.woong.musicplayer.fragment.PlaylistFragment

class TabAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->AllListFragment()
            else->PlaylistFragment()

        }
    }

    override fun getItemCount(): Int {
        return 2;
    }

}