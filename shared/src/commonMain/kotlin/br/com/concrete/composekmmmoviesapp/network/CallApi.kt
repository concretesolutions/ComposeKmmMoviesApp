package br.com.concrete.composekmmmoviesapp.network

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.di.di
import io.ktor.client.*
import io.ktor.client.request.*
import org.kodein.di.instance

suspend inline fun <reified T> call(url:String) : Response<T> {
    val httpClient: HttpClient by di.instance()
    return try {
        val response: T = httpClient.get(urlString = url)
        Response.Success(response)
    } catch(ex: Exception) {
        Response.Error(ex)
    }
}
