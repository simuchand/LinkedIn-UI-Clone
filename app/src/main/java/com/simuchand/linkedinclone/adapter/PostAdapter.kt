package com.simuchand.linkedinclone.adapter

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.simuchand.linkedinclone.R
import com.simuchand.linkedinclone.model.Post
import kotlin.math.log

class PostAdapter(
    private val context: Context,
    private val dataset: List<Post>,
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_TEXT = 1
        const val VIEW_TYPE_IMAGE = 2
        const val VIEW_TYPE_VIDEO = 3
    }

    private inner class TextViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val profileNameTV: TextView = itemView.findViewById(R.id.text_view_profile_name)
        val profileDescTV: TextView = itemView.findViewById(R.id.text_view_profile_dec)
        val postTimestampTV: TextView = itemView.findViewById(R.id.text_view_post_timestamp)
        val profileImgTV: ImageView = itemView.findViewById(R.id.text_view_profile_img)
        val postContentTV: TextView = itemView.findViewById(R.id.text_view_post)
        val socialCountTV: TextView = itemView.findViewById(R.id.text_view_social_count)
        val commentCountTV: TextView = itemView.findViewById(R.id.text_view_comment_count)
        val likeContainer: LinearLayout = itemView.findViewById(R.id.like_container)
        val likeImg: ImageView = itemView.findViewById(R.id.post_like)

        fun bind(position: Int) {
            val place = dataset[position]
            var liked = 0
            profileNameTV.text = context.resources.getString(place.profileNameResourceId)
            profileDescTV.text = context.resources.getString(place.profileDescResourceId)
            postTimestampTV.text = context.resources.getString(place.postTimestampResourceId)
            profileImgTV.setImageResource(place.profileImgResourceID)
            postContentTV.text = context.resources.getString(place.postContentResourceId)
            socialCountTV.text = context.resources.getString(place.socialCountResourceId)
            commentCountTV.text = context.resources.getString(place.commentCountResourceId)

            likeContainer.setOnClickListener{
                if (liked == 1) {
                    likeImg.setImageResource(R.drawable.ic_outline_like)
                    liked = 0
                } else if (liked == 0) {
                    likeImg.setImageResource(R.drawable.ic_round_like)
                    liked = 1
                }
            }
        }
    }

    private inner class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val profileNameTV: TextView = itemView.findViewById(R.id.text_view_profile_name)
        val profileDescTV: TextView = itemView.findViewById(R.id.text_view_profile_dec)
        val postTimestampTV: TextView = itemView.findViewById(R.id.text_view_post_timestamp)
        val profileImgTV: ImageView = itemView.findViewById(R.id.text_view_profile_img)
        val postContentTV: TextView = itemView.findViewById(R.id.text_view_post)
        val socialCountTV: TextView = itemView.findViewById(R.id.text_view_social_count)
        val commentCountTV: TextView = itemView.findViewById(R.id.text_view_comment_count)
        val postImage: ImageView = itemView.findViewById(R.id.image_view_post_image)
        val likeContainer: LinearLayout = itemView.findViewById(R.id.like_container)
        val likeImg: ImageView = itemView.findViewById(R.id.post_like)

        fun bind(position: Int) {
            val place = dataset[position]
            var liked = 0
            profileNameTV.text = context.resources.getString(place.profileNameResourceId)
            profileDescTV.text = context.resources.getString(place.profileDescResourceId)
            postTimestampTV.text = context.resources.getString(place.postTimestampResourceId)
            profileImgTV.setImageResource(place.profileImgResourceID)
            postContentTV.text = context.resources.getString(place.postContentResourceId)
            socialCountTV.text = context.resources.getString(place.socialCountResourceId)
            commentCountTV.text = context.resources.getString(place.commentCountResourceId)
            val imageId = place.postImageResourceId.toInt()
            postImage.setImageResource(imageId)

            likeContainer.setOnClickListener{
                if (liked == 1) {
                    likeImg.setImageResource(R.drawable.ic_outline_like)
                    liked = 0
                } else if (liked == 0) {
                    likeImg.setImageResource(R.drawable.ic_round_like)
                    liked = 1
                }
            }
        }
    }

    private inner class VideoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val profileNameTV: TextView = itemView.findViewById(R.id.text_view_profile_name)
        val profileDescTV: TextView = itemView.findViewById(R.id.text_view_profile_dec)
        val postTimestampTV: TextView = itemView.findViewById(R.id.text_view_post_timestamp)
        val profileImgTV: ImageView = itemView.findViewById(R.id.text_view_profile_img)
        val postContentTV: TextView = itemView.findViewById(R.id.text_view_post)
        val socialCountTV: TextView = itemView.findViewById(R.id.text_view_social_count)
        val commentCountTV: TextView = itemView.findViewById(R.id.text_view_comment_count)
        val postVideo: VideoView = itemView.findViewById(R.id.video_view_post_image)
        val likeContainer: LinearLayout = itemView.findViewById(R.id.like_container)
        val likeImg: ImageView = itemView.findViewById(R.id.post_like)

        fun bind(position: Int) {
            val place = dataset[position]
            var liked = 0
            profileNameTV.text = context.resources.getString(place.profileNameResourceId)
            profileDescTV.text = context.resources.getString(place.profileDescResourceId)
            postTimestampTV.text = context.resources.getString(place.postTimestampResourceId)
            profileImgTV.setImageResource(place.profileImgResourceID)
            postContentTV.text = context.resources.getString(place.postContentResourceId)
            socialCountTV.text = context.resources.getString(place.socialCountResourceId)
            commentCountTV.text = context.resources.getString(place.commentCountResourceId)
            val videoId = place.postVideoResourceId.toInt()
            val videoPath: String = "android.resource://" + context.packageName + "/" + videoId
            val uri: Uri = Uri.parse(videoPath)
            postVideo.setVideoURI(uri)

            val mediaController = MediaController(context)
            postVideo.setMediaController(mediaController)
            postVideo.setZOrderOnTop(true)
            mediaController.setAnchorView(postVideo)
            postVideo.start()

            likeContainer.setOnClickListener{
                if (liked == 1) {
                    likeImg.setImageResource(R.drawable.ic_outline_like)
                    liked = 0
                } else if (liked == 0) {
                    likeImg.setImageResource(R.drawable.ic_round_like)
                    liked = 1
                }
            }

        }
    }

    /*val likeContainer: LinearLayout = findViewById(R.id.like_container)
    var liked = false
    likeContainer.setOnClickListener {
        val likeImg: ImageView = findViewById(R.id.post_like)
        liked = if (liked) {
            likeImg.setImageResource(R.drawable.ic_round_like)
            true
        } else {
            likeImg.setImageResource(R.drawable.ic_outline_like)
            false
        }
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_TEXT) {
            return TextViewHolder(
                LayoutInflater.from(context).inflate(R.layout.text_item_style, parent, false)
            )
        } else if (viewType == VIEW_TYPE_IMAGE) {
            return ImageViewHolder(
                LayoutInflater.from(context).inflate(R.layout.image_item_style, parent, false)
            )
        }
        return VideoViewHolder(
            LayoutInflater.from(context).inflate(R.layout.video_item_style, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(dataset[position].viewType) {
            VIEW_TYPE_TEXT -> (holder as TextViewHolder).bind(position)
            VIEW_TYPE_IMAGE -> (holder as ImageViewHolder).bind(position)
            VIEW_TYPE_VIDEO -> (holder as VideoViewHolder).bind(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return dataset[position].viewType
    }

    override fun getItemCount() = dataset.size
}