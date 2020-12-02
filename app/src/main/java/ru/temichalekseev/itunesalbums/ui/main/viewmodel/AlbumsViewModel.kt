package ru.temichalekseev.itunesalbums.ui.main.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.*
import ru.temichalekseev.itunesalbums.data.model.Album
import ru.temichalekseev.itunesalbums.data.repository.AlbumsRepository
import ru.temichalekseev.itunesalbums.utils.retrocoroutines.Resource

/**
 * Created on 26.11.2020.
 * @author Artem Alexeev
 * @version 1.0
 * @since 1.0
 * LiveData for Albums
 */
class AlbumsViewModel(private val albumsRepository: AlbumsRepository) : ViewModel() {
    private val _search: MutableLiveData<String> = MutableLiveData()
    private var waitAndSearch: CompletableJob? = null

    /**
     * Get album list from API using coroutine. Triggers each times when _search changed.
     * Called from View
     * @return LiveData with Resource. View needs Resource for know the current state.
     */
    fun getAlbums(): LiveData<Resource<List<Album>>> =
        Transformations.switchMap(_search) { search ->
            liveData {
                emit(Resource.loading(data = null))
                try {
                    emit(Resource.success(data = albumsRepository.getAlbums(search)))
                } catch (exception: Exception) {
                    emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
                }
            }
        }

    /**
     * Called from View
     * @param search - the key with which we get the search results
     */
    fun setSearch(search: String) {
        if(_search.value != search) {
            if (search.isEmpty()) {
                _search.value = search
            } else {
                waitAndThenSet(search)
            }
        }
    }

    /**
     * Called from View
     * @return current search value
     */
    fun getSearch() = _search.value

    private fun waitAndThenSet (search: String) {
        waitAndSearch?.cancel()
        waitAndSearch = Job()
        waitAndSearch?.let { job ->
            CoroutineScope(this.viewModelScope.coroutineContext + job).launch {
                delay(300)
                _search.value = search
            }
        }
    }
}