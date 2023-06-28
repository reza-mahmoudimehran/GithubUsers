package ir.reza_mahmoudi.githubusers.core.domain.model

import com.google.gson.annotations.SerializedName

data class GeneralError(
    @SerializedName("Response")
    val response: Boolean,
    @SerializedName("Error")
    val error: String?
)
