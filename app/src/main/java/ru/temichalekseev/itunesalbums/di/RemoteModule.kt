package ru.temichalekseev.itunesalbums.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.temichalekseev.itunesalbums.data.api.ITunesAPIHelper
import ru.temichalekseev.itunesalbums.data.api.ITunesApi
import javax.inject.Singleton

/**
 * Created on 25.11.2020.
 * @author Artem Alexeev
 * @version 1.0
 * @since 1.0
 * RemoteModule for network.
 */
@Module
class RemoteModule {
    @Singleton @Provides fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton @Provides fun providesJsonHolder(retrofit: Retrofit): ITunesApi =
        retrofit.create(ITunesApi::class.java)

    private companion object {
        const val BASE_URL = "https://itunes.apple.com/"
    }
}