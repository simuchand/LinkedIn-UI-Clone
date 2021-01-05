package com.simuchand.linkedinclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.simuchand.linkedinclone.adapter.PostAdapter
import com.simuchand.linkedinclone.adapter.StoryAdapter
import com.simuchand.linkedinclone.data.Datasource
import com.simuchand.linkedinclone.data.StoryData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postDataset = Datasource().loadPosts()
        val postRecyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        postRecyclerView.adapter = PostAdapter(this, postDataset)
        postRecyclerView.setHasFixedSize(true)

        val storyDataset = StoryData().loadStory()
        val storyRecyclerView = findViewById<RecyclerView>(R.id.stories_container)
        storyRecyclerView.adapter = StoryAdapter(this, storyDataset)
        storyRecyclerView.setHasFixedSize(true)
    }
}