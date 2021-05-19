package com.woong.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.woong.musicplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var allList:AllListFragment
    lateinit var playlist:PlaylistFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showAllList()


        binding.btAllList.setOnClickListener {
            showAllList()
        }

        binding.btPlaylist.setOnClickListener {
            showPlayList()
        }
    }

    private fun showAllList(){
        allList = AllListFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.layout_frag, allList)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

    }

    private fun showPlayList(){

        playlist = PlaylistFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.layout_frag, playlist)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

    }

}