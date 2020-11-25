package ru.temichalekseev.itunesalbums

import android.app.Application
import ru.temichalekseev.itunesalbums.di.AppComponent
import ru.temichalekseev.itunesalbums.di.AppModule
/**
 * Created on 25.11.2020.
 * @author Artem Alexeev
 * @version 1.0.0
 * @since 1.0.0
 * Application for this app. Used for a Dagger.
 */
class App: Application() {
    companion object {
        var dagger: AppComponent? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
//        dagger = DaggerAppComponent.builder().appModule(AppModule(app = this@App)).build()
    }
}