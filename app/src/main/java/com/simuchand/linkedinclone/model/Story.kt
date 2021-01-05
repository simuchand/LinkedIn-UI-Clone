package com.simuchand.linkedinclone.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Story(
    val viewType: Int,
    val storyProfileName: String,
    @DrawableRes val storyProfileImg: Int,
)
