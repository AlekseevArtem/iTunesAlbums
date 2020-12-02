package ru.temichalekseev.itunesalbums.data.repository

import ru.temichalekseev.itunesalbums.data.api.ITunesAPIHelper
import ru.temichalekseev.itunesalbums.data.model.Album

/**
 * Created on 28.11.2020.
 * @author Artem Alekseev (mailto:tema9991@mail.ru)
 * @version 1.0
 * @since 1.0
 * Repository for AlbumsFragment
 */
class AlbumsRepository(private val apiHelper: ITunesAPIHelper) {
    suspend fun getAlbums(search: String): List<Album> =
        if (search.isEmpty()) {
            mutableListOf()
        } else {
            apiHelper.getAlbums(search).sortedBy { it.collectionName }
        }
}