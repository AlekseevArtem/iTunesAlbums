package ru.temichalekseev.itunesalbums.data.model.response

import com.google.gson.annotations.SerializedName
import ru.temichalekseev.itunesalbums.data.model.Album

/**
 * Created on 26.11.2020.
 * @author Artem Alekseev (mailto:tema9991@mail.ru)
 * @version 1.0
 * @since 1.0
 * Entity for response with list of albums from ITunes API
 */
class ResponseAlbums(
    @SerializedName("results")
    val albums: List<Album>
)