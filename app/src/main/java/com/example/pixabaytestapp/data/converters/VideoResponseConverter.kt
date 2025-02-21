package com.example.pixabaytestapp.data.converters

import com.example.pixabaytestapp.data.dto.Large
import com.example.pixabaytestapp.data.dto.Medium
import com.example.pixabaytestapp.data.dto.PixabayResponse
import com.example.pixabaytestapp.data.dto.Small
import com.example.pixabaytestapp.data.dto.Tiny
import com.example.pixabaytestapp.domain.models.VideoEntity
import com.example.pixabaytestapp.domain.models.VideoFormat

class VideoResponseConverter {

    fun convert(response: PixabayResponse): List<VideoEntity> {
        return with(response) {
            hits.map {
                VideoEntity(
                    duration = it.duration,
                    id = it.id,
                    thumbnail = it.videos.tiny.thumbnail,
                    large = videoLargeConverter(it.videos.large),
                    medium = videoMediumConverter(it.videos.medium),
                    small = videoSmallConverter(it.videos.small),
                    tiny = videoTinyConverter(it.videos.tiny)
                )
            }
        }
    }

//    private fun <T> videoConverter(video: T): VideoFormat {
//        return with(video) {
//            VideoFormat(
//                height = TODO(),
//                thumbnail = TODO(),
//                url = TODO(),
//                width = TODO()
//            )
//        }
//    }

    private fun videoLargeConverter(large: Large): VideoFormat {
        return with(large) {
            VideoFormat(
                height = height,
                thumbnail = thumbnail,
                url = url,
                width = width
            )
        }
    }

    private fun videoMediumConverter(medium: Medium): VideoFormat {
        return with(medium) {
            VideoFormat(
                height = height,
                thumbnail = thumbnail,
                url = url,
                width = width
            )
        }
    }

    private fun videoSmallConverter(small: Small): VideoFormat {
        return with(small) {
            VideoFormat(
                height = height,
                thumbnail = thumbnail,
                url = url,
                width = width
            )
        }
    }

    private fun videoTinyConverter(tiny: Tiny): VideoFormat {
        return with(tiny) {
            VideoFormat(
                height = height,
                thumbnail = thumbnail,
                url = url,
                width = width
            )
        }
    }

}