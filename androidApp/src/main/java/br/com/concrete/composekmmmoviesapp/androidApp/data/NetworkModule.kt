package br.com.concrete.composekmmmoviesapp.androidApp.data

import android.content.Context
import br.com.concrete.composekmmmoviesapp.androidApp.R
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

private const val CACHE_SIZE = (15 * 1024 * 1024).toLong()

val networkModule = module {
    single {
        Cache(File(get<Context>().cacheDir, "http-cache"), CACHE_SIZE)
    }

    single {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .cache(get())

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        okHttpClientBuilder.build()
    }

    single<ApiService> {
        val baseUrl = get<Context>().getString(R.string.movies_db_base_url)
        Retrofit.Builder().baseUrl(baseUrl)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ApiService::class.java)
    }

}