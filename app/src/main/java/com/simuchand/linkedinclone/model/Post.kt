package com.simuchand.linkedinclone.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Post(
    val viewType: Int,
    @StringRes val profileNameResourceId: Int,
    @StringRes val profileDescResourceId: Int,
    @StringRes val postTimestampResourceId: Int,
    @DrawableRes val profileImgResourceID: Int,
    @StringRes val postContentResourceId: Int,
    @StringRes val socialCountResourceId: Int,
    @StringRes val commentCountResourceId: Int,
    val postImageResourceId: String,
    val postVideoResourceId: String,
)
