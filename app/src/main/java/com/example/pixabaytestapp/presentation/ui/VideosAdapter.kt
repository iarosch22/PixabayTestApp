package com.example.pixabaytestapp.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pixabaytestapp.R
import com.example.pixabaytestapp.domain.models.VideoEntity
import com.example.pixabaytestapp.presentation.OnVideoClickListener

class VideosAdapter(private val listener: OnVideoClickListener): RecyclerView.Adapter<VideosViewHolder>() {

    var videos = mutableListOf<VideoEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return VideosViewHolder(view)
    }

    override fun getItemCount(): Int = videos.size

    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        holder.bind(videos[position])

        holder.itemView.setOnClickListener { listener.onVideoClick(videos[position]) }
    }

}