package com.maruf.firebaseauth.model.userInfo

import java.io.Serializable

data class UserInfo(
    val displayName: String,
    val email: String,
    val photoUrl: String
):Serializable