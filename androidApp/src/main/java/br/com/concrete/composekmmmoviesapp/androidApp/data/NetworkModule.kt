package br.com.concrete.composekmmmoviesapp.androidApp.data

import android.content.Context
import br.com.concrete.composekmmmoviesapp.androidApp.BuildConfig
import br.com.concrete.composekmmmoviesapp.androidApp.R
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

val networkModule = module {
    single {
        Cache(File(get<Context>().cacheDir, "http-cache"), 15 * 1024 * 1024)
    }

    single(named("injectApiKey")) {
        Interceptor { chain ->
            val request = chain.request()
            val newUrl = request.url.newBuilder()
                .addQueryParameter("api_key", BuildConfig.MoviesDbApiKey)
                .build()
            val newRequest = request.newBuilder()
                .url(newUrl)
                .build()

            chain.proceed(newRequest)
        }
    }

    single(named("loggingInterceptor")) {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>(named("injectApiKey")))
            .cache(get())

        if (BuildConfig.DEBUG) {
            okHttpClientBuilder.addInterceptor(get<HttpLoggingInterceptor>(named("loggingInterceptor")))
        }
        okHttpClientBuilder.build()
    }

    single<MoviesDbApi> {
        val baseUrl = get<Context>().getString(R.string.movies_db_base_url)
        Retrofit.Builder().baseUrl(baseUrl)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(MoviesDbApi::class.java)
    }
}