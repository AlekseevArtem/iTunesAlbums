package ru.temichalekseev.itunesalbums.data.model

import java.util.*

/**
 * Created on 28.11.2020.
 * @author Artem Alekseev (mailto:tema9991@mail.ru)
 * @version 1.0
 * @since 1.0
 * Entity for track
 */
class Track(
    var trackId: Int,
    var trackName: String? = null,

    var wrapperType: String? = null,
    var kind: String? = null,
    var artistId: Int? = null,
    var collectionId: Int,
    var artistName: String? = null,
    var collectionName: String? = null,
    var collectionCensoredName: String? = null,
    var trackCensoredName: String? = null,
    var artistViewUrl: String? = null,
    var collectionViewUrl: String? = null,
    var trackViewUrl: String? = null,
    var previewUrl: String? = null,
    var artworkUrl30: String? = null,
    var artworkUrl60: String? = null,
    var artworkUrl100: String? = null,
    var collectionPrice: Double? = null,
    var trackPrice: Double? = null,
    var releaseDate: Date? = null,
    var collectionExplicitness: String? = null,
    var trackExplicitness: String? = null,
    var discCount: Int? = null,
    var discNumber: Int? = null,
    var trackCount: Int? = null,
    var trackNumber: Int? = null,
    var trackTimeMillis: Int? = null,
    var country: String? = null,
    var currency: String? = null,
    var primaryGenreName: String? = null,
    var isStreamable: Boolean? = null,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Track
        if (trackId != other.trackId) return false
        return true
    }

    override fun hashCode(): Int = trackId.hashCode()
    override fun toString() = trackName ?: "null"
}

