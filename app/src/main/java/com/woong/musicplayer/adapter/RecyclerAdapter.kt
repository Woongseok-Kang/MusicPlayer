package com.woong.musicplayer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.woong.musicplayer.R
import com.woong.musicplayer.data.DataMusic

class RecyclerAdapter(private val items:ArrayList<DataMusic>) :
        RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
        override fun getItemCount(): Int = items.size

        override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
                val item = items[position]
                val listener = View.OnClickListener{
                        it->
                        Toast.makeText(it.context, "Clicked:" + item.title, Toast.LENGTH_SHORT).show()

                }
                holder.apply{
                        bind(listener, item)
                        itemView.tag = item
                }
        }

        override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
        ): RecyclerAdapter.ViewHolder {
                val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
                return RecyclerAdapter.ViewHolder(inflatedView)
        }
        class ViewHolder(v:View) : RecyclerView.ViewHolder(v){
                private var view : View = v
                fun bind(listener:View.OnClickListener, item:DataMusic){
                        view.findViewById<ImageView>(R.id.album).setImageResource(R.drawable.ic_launcher_background)//이거 바꾸기
                        view.findViewById<TextView>(R.id.tv_title).text = item.title
                        view.findViewById<TextView>(R.id.tv_artist).text = item.artist
                        view.setOnClickListener(listener)
                }
        }
        }


























