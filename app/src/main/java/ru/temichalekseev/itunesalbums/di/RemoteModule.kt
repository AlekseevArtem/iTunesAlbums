package ru.temichalekseev.itunesalbums.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.temichalekseev.itunesalbums.repository.ITunesJsonHolderApi
import javax.inject.Singleton

/**
 * Created on 25.11.2020.
 * @author Artem Alexeev
 * @version 1.0.0
 * @since 1.0.0
 * RemoteModule for network.
 */
@Module
class RemoteModule {
    @Singleton @Provides fun providesRetrofit(): Retrofit =
            Retrofit.Builder()
                    .baseUrl("https://itunes.apple.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

    @Singleton @Provides fun providesJsonHolder(retrofit: Retrofit): ITunesJsonHolderApi =
            retrofit.create(ITunesJsonHolderApi::class.java)
}