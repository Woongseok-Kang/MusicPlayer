package com.woong.musicplayer.fragment

import android.content.ContentResolver
import android.content.Context
import android.os.Bundle
import android.provider.CalendarContract.Attendees.query
import android.provider.CalendarContract.EventDays.query
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.woong.musicplayer.R
import com.woong.musicplayer.adapter.RecyclerAdapter
import com.woong.musicplayer.data.DataMusic
import com.woong.musicplayer.databinding.FragmentAllListBinding


class AllListFragment : Fragment() {

    // 프래그먼트 뷰바인딩
    private var mbinding:FragmentAllListBinding? = null;
    private val binding get() = mbinding!!


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mbinding = FragmentAllListBinding.inflate(inflater, container, false)

        val list = ArrayList<DataMusic>()
        val storage = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val music_info = arrayOf(
            MediaStore.Audio.Media.ALBUM,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST
        )

        val cursor = activity?.contentResolver?.query(storage, music_info, null, null, null)


        //음악 목록 추가
        //ex) list.add(DataMusic(null, null, null))

        if (cursor != null) {
            while (cursor.moveToNext()) {

                val album = cursor.getString(cursor.getColumnIndex(music_info[0]))
                val title = cursor.getString(cursor.getColumnIndex(music_info[1]))
                val artist = cursor.getString(cursor.getColumnIndex(music_info[2]))

                val music = DataMusic(album, title, artist)
                list.add(music)

            }
        }

        val adapter = RecyclerAdapter(list)
        binding.listAllMusic.layoutManager = LinearLayoutManager(requireContext())
        binding.listAllMusic.adapter = adapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mbinding = null
    }
}
