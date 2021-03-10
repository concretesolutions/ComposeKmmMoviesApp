package br.com.concrete.composekmmmoviesapp.network

import br.com.concrete.composekmmmoviesapp.data.Response
import io.ktor.client.*
import io.ktor.client.request.*

suspend inline fun <reified T> call(url:String) : Response<T> {
    return try {
        val response: T = HttpClient().get(urlString = url)
        Response.Success(response)
    } catch(ex: Exception) {
        Response.Error(ex)
    }
}
