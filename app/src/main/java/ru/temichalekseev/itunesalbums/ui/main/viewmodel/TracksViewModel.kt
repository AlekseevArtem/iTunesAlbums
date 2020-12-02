package ru.temichalekseev.itunesalbums.ui.main.viewmodel

import androidx.lifecycle.*
import ru.temichalekseev.itunesalbums.data.model.Album
import ru.temichalekseev.itunesalbums.data.model.Track
import ru.temichalekseev.itunesalbums.data.repository.AlbumsRepository
import ru.temichalekseev.itunesalbums.data.repository.TracksRepository
import ru.temichalekseev.itunesalbums.utils.retrocoroutines.Resource

/**
 * Created on 28.11.2020.
 * @author Artem Alexeev
 * @version 1.0
 * @since 1.0
 * LiveData for Tracks
 */
class TracksViewModel(private val repository: TracksRepository) : ViewModel() {

    /**
     * Get track list from API using coroutine.
     * Called from View
     * @return LiveData with Resource. View needs Resource for know the current state.
     */
    fun getTracks(albumID: Int): LiveData<Resource<List<Track>>> =
        liveData {
            emit(Resource.loading(data = null))
            try {
                emit(Resource.success(data = repository.getTracks(albumID)))
            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            }
        }

}