package ru.temichalekseev.itunesalbums.data.api

import javax.inject.Inject

/**
 * Created on 25.11.2020.
 * @author Artem Alekseev (mailto:tema9991@mail.ru)
 * @version 1.0
 * @since 1.0
 * Interface for Retrofit for gets responses from ITunes API
 */
class ITunesAPIHelper @Inject constructor(val api: ITunesApi) {
    suspend fun getAlbums(search: String) = api.getAlbums(search).albums
    suspend fun getTracks(albumId: Int) = api.getTracks(albumId).tracks
}