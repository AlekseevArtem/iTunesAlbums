package ru.temichalekseev.itunesalbums.di

import dagger.Component
import ru.temichalekseev.itunesalbums.ui.main.view.AlbumsFragment
import ru.temichalekseev.itunesalbums.ui.main.view.SingleActivity
import ru.temichalekseev.itunesalbums.ui.main.view.TracksFragment
import javax.inject.Singleton

/**
 * Created on 25.11.2020.
 * @author Artem Alexeev
 * @version 1.0
 * @since 1.0
 * AppComponent. Intermediary between @Inject and Modules
 */
@Singleton
@Component(modules = [RemoteModule::class])
interface RemoteComponent {
    fun injectTo(fragment: AlbumsFragment)
    fun injectTo(fragment: TracksFragment)
}