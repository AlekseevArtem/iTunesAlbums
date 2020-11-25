package ru.temichalekseev.itunesalbums.di

import dagger.Component
import ru.temichalekseev.itunesalbums.ui.main.MainActivity
import ru.temichalekseev.itunesalbums.ui.main.MainFragment
import javax.inject.Singleton

/**
 * Created on 25.11.2020.
 * @author Artem Alexeev
 * @version 1.0.0
 * @since 1.0.0
 * AppComponent. Intermediary between @Inject and Modules
 */
@Singleton
@Component(modules = [AppModule::class, StoreModule::class, RemoteModule::class])
interface AppComponent {
    fun inject(mainFragment: MainFragment)
}