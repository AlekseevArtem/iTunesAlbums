package ru.temichalekseev.itunesalbums.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.temichalekseev.itunesalbums.data.model.response.ResponseAlbums
import ru.temichalekseev.itunesalbums.data.model.response.ResponseTracks

/**
 * Created on 25.11.2020.
 * @author Artem Alekseev (mailto:tema9991@mail.ru)
 * @version 1.0
 * @since 1.0
 * Interface for Retrofit for gets responses from ITunes API
 */
interface ITunesApi {
    @GET("search")
    suspend fun getAlbums(
        @Query("term") term: String,
        @Query("media") media : String = "music",
        @Query("entity") entity: String = "album"
    ): ResponseAlbums

    @GET("lookup")
    suspend fun getTracks(
        @Query("id") id: Int,
        @Query("entity") entity: String = "song"
    ): ResponseTracks
}

//interface ApiService {
//    //    https://itunes.apple.com/search?term=martin&media=music&entity=musicArtist
//    @GET("search")
//    fun getArtists(
//        @Query(QUERY_PARAM_TERM) term: String,
//        @Query(QUERY_PARAM_MEDIA) attribute: String = MUSIC,
//        @Query(QUERY_PARAM_ENTITY) entity: String = MUSIC_ARTIST
//    ): Single<SearchResponse>
//
//    //    https://itunes.apple.com/lookup?id=217142&entity=album
//    @GET("lookup")
//    fun getAlbums(
//        @Query(QUERY_PARAM_ID) id: Int,
//        @Query(QUERY_PARAM_ENTITY) entity: String = ALBUM
//    ): Single<AlbumsResponse>
//
//    //    https://itunes.apple.com/lookup?id=296008647&entity=song
//    @GET("lookup")
//    fun getTracks(
//        @Query(QUERY_PARAM_ID) id: Int,
//        @Query(QUERY_PARAM_ENTITY) entity: String = SONG
//    ): Single<TracksResponse>
//
//    companion object {
//        private const val QUERY_PARAM_TERM = "term"
//        private const val QUERY_PARAM_MEDIA = "media"
//        private const val QUERY_PARAM_ENTITY = "entity"
//        private const val QUERY_PARAM_ID = "id"
//
//        private const val MUSIC = "music"
//        private const val MUSIC_ARTIST = "musicArtist"
//        private const val ALBUM = "album"
//        private const val SONG = "song"
//    }
//}