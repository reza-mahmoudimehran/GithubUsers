package ir.reza_mahmoudi.githubusers.feature_user_details.util.test_data

import ir.reza_mahmoudi.githubusers.feature_user_details.domain.model.UserDetails

const val USER_DETAILS_USER_NAME = "Reza"

val USER_DETAILS_FAKE_DATA = UserDetails(
    login = "Reza1",
    id = 1,
    avatarUrl = "example.com/Reza1",
    name = "Reza",
    company = "google",
    bio = "Hey I'm Reza",
    following = 1000,
    followers = 2000
)