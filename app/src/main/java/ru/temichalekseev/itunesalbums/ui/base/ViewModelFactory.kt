package ru.temichalekseev.itunesalbums.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.temichalekseev.itunesalbums.data.api.ITunesAPIHelper
import ru.temichalekseev.itunesalbums.data.repository.AlbumsRepository
import ru.temichalekseev.itunesalbums.data.repository.TracksRepository
import ru.temichalekseev.itunesalbums.ui.main.viewmodel.AlbumsViewModel
import ru.temichalekseev.itunesalbums.ui.main.viewmodel.TracksViewModel

class ViewModelFactory constructor(private val apiHelper: ITunesAPIHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlbumsViewModel::class.java)) {
            return AlbumsViewModel(AlbumsRepository(apiHelper)) as T
        } else if (modelClass.isAssignableFrom(TracksViewModel::class.java)) {
            return TracksViewModel(TracksRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}