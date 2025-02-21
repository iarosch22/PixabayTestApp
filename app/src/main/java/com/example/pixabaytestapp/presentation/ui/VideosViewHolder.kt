package com.example.pixabaytestapp.presentation.ui

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.pixabaytestapp.R
import com.example.pixabaytestapp.domain.models.VideoEntity
import java.text.SimpleDateFormat
import java.util.Locale

class VideosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val ivPreview: ImageView = itemView.findViewById(R.id.ivPreview)
    private val tvTags: TextView = itemView.findViewById(R.id.tvTags)
    private val tvTypeOfVideo: TextView = itemView.findViewById(R.id.tvTypeOfVideo)
    private val tvDuration: TextView = itemView.findViewById(R.id.tvDuration)

    fun bind(item: VideoEntity) {
        tvDuration.text = SimpleDateFormat("mm:ss", Locale.getDefault()).format(item.duration * 1000)
        tvTags.text = item.tags
        tvTypeOfVideo.text = item.type
        loadTrackArtwork(item.thumbnail)
    }

    private fun loadTrackArtwork(thumbnailUrl: String) {
        val cornersValueDp = 2F
        val cornersValuePx = dpToPx(cornersValueDp, itemView.context)

        Glide.with(itemView)
            .load(thumbnailUrl)
            .centerCrop()
            .transform(RoundedCorners(cornersValuePx))
            .placeholder(R.drawable.ic_placeholder)
            .into(ivPreview)
    }

    private fun dpToPx(dp: Float, context: Context): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            context.resources.displayMetrics).toInt()
    }

}