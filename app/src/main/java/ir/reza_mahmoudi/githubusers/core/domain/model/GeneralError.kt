package ir.reza_mahmoudi.githubusers.core.domain.model

import com.google.gson.annotations.SerializedName

data class GeneralError(
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("errors")
    val errors: List<Error>? = null
)

data class Error(
    @SerializedName("resource")
    val resource: String? = null,
    @SerializedName("field")
    val field: String? = null,
    @SerializedName("code")
    val code: String? = null
)