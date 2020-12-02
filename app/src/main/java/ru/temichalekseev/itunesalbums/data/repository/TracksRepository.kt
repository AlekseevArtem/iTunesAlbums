package ru.temichalekseev.itunesalbums.data.repository

import ru.temichalekseev.itunesalbums.data.api.ITunesAPIHelper
import ru.temichalekseev.itunesalbums.data.model.Track

/**
 * Created on 28.11.2020.
 * @author Artem Alekseev (mailto:tema9991@mail.ru)
 * @version 1.0
 * @since 1.0
 * Repository for TracksFragment
 */
class TracksRepository(private val apiHelper: ITunesAPIHelper) {
    suspend fun getTracks(id: Int): List<Track> = apiHelper.getTracks(id)
}