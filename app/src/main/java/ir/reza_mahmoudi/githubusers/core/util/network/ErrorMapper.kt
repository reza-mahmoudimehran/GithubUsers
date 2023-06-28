package ir.reza_mahmoudi.githubusers.core.util.network

import com.google.gson.Gson
import ir.reza_mahmoudi.githubusers.core.domain.model.GeneralError


val gsonObject = Gson()

fun String?.wrapToGeneralError(): ApiResult<Nothing> = try {
    val errorResponse = this?.let {
        gsonObject.fromJson(this, GeneralError::class.java)
    }
    if (errorResponse == null) {
        ApiResult.Error(Exception("Unknown Network Error"))
    } else {
        ApiResult.ServerError(errorResponse)
    }
} catch (e: Exception) {
    ApiResult.Error(e)
}