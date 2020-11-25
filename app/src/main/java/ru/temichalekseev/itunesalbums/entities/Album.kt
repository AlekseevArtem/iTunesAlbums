package ru.temichalekseev.itunesalbums.entities

/**
 * Created on 25.11.2020.
 * @author Artem Alexeev
 * @version 1.0.0
 * @since 1.0.0
 * Entity for album
 */
class Album(
    val wrapperType: String? = null,
    val artistType: String? = null,
    val artistName: String? = null,
    val artistLinkUrl: String? = null,
    val artistId: Int? = null,
    val artistViewUrl: String? = null,
    val collectionType: String? = null,
    val collectionId: Int,
    val collectionName: String? = null,
    val collectionCensoredName: String? = null,
    val collectionViewUrl: String? = null,
    val collectionPrice: Double? = null,
    val collectionExplicitness: String? = null,
    val amgArtistId: Int? = null,
    val primaryGenreName: String? = null,
    val primaryGenreId: Int? = null,
    val artworkUrl60: String? = null,
    val artworkUrl100: String? = null,
    val trackCount: Int? = null,
    val copyright: String? = null,
    val country: String? = null,
    val currency: String? = null,
    val releaseDate: String? = null
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Album
        if (collectionId != other.collectionId) return false
        return true
    }

    override fun hashCode(): Int = collectionId.hashCode()
    override fun toString() = collectionName ?: "null"
}