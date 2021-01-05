package com.simuchand.linkedinclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.simuchand.linkedinclone.R
import com.simuchand.linkedinclone.model.Story


class StoryAdapter(
    private val context: Context,
    private val dataset: List<Story>,
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_PERSONAL = 1
        const val VIEW_TYPE_OTHER = 2
    }

    private inner class PersonalViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val storyProfileName: TextView = itemView.findViewById(R.id.story_profile_name)
        val storyProfileImg: ImageView = itemView.findViewById(R.id.story_profile_img)

        fun bind(position: Int) {
            val place = dataset[position]
            storyProfileName.text = place.storyProfileName
            storyProfileImg.setImageResource(place.storyProfileImg)
        }
    }

    private inner class OtherViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val storyProfileName: TextView = itemView.findViewById(R.id.story_profile_name)
        val storyProfileImg: ImageView = itemView.findViewById(R.id.story_profile_img)

        fun bind(position: Int) {
            val place = dataset[position]
            storyProfileName.text = place.storyProfileName
            storyProfileImg.setImageResource(place.storyProfileImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_PERSONAL)
            return PersonalViewHolder(
                LayoutInflater.from(context).inflate(R.layout.personal_story_holder, parent, false)
            )
        return OtherViewHolder(
            LayoutInflater.from(context).inflate(R.layout.other_stroy_holder, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(dataset[position].viewType) {
            VIEW_TYPE_PERSONAL -> (holder as PersonalViewHolder).bind(position)
            VIEW_TYPE_OTHER -> (holder as OtherViewHolder).bind(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return dataset[position].viewType
    }

    override fun getItemCount() = dataset.size

}