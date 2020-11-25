package ru.temichalekseev.itunesalbums.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ru.temichalekseev.itunesalbums.App
import javax.inject.Singleton

/**
 * Created on 25.11.2020.
 * @author Artem Alexeev
 * @version 1.0.0
 * @since 1.0.0
 * AppModule
 */
@Module
class AppModule(private val app: App) {
    @Singleton @Provides fun providesApplication(): Application = app
    @Singleton @Provides fun providesContext(application: Application): Context = application.applicationContext
}