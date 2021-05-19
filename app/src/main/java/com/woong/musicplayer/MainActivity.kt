package com.woong.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayoutMediator
import com.woong.musicplayer.adapter.TabAdapter
import com.woong.musicplayer.fragment.AllListFragment
import com.woong.musicplayer.fragment.PlaylistFragment
import com.woong.musicplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val tabTextList = arrayListOf("전체목록", "플레이리스트")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabInit()


    }

    private fun tabInit(){
        binding.viewFrag.adapter = TabAdapter(this)
        TabLayoutMediator(binding.tabMain, binding.viewFrag){
            tab, position ->
            tab.text = tabTextList[position]
        }.attach()
    }

}