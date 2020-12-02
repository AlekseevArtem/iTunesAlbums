package ru.temichalekseev.itunesalbums

import android.app.Application
import ru.temichalekseev.itunesalbums.di.DaggerRemoteComponent
import ru.temichalekseev.itunesalbums.di.RemoteComponent

/**
 * Created on 25.11.2020.
 * @author Artem Alexeev
 * @version 1.0
 * @since 1.0
 * Application for this app. Used for a Dagger.
 */
class App: Application() {
    companion object {
        var remote: RemoteComponent? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        remote = DaggerRemoteComponent.create()
    }
}