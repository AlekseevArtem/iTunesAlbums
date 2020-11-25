package ru.temichalekseev.itunesalbums.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.temichalekseev.itunesalbums.entities.Album

interface ITunesJsonHolderApi {
    @GET("search")
    suspend fun getAlbums(
        @Query("term") term: String,
        @Query("media") media : String = MEDIA,
        @Query("entity") entity: String = ENTITY
    ): Call<List<Album>>

    suspend fun getAlbum(
//        @Query("term") term: String,
//        @Query("media") media : String,
//        @Query("entity") entity: String
    ): Call<Album>

    companion object{
        private const val ENTITY = "album"
        private const val MEDIA = "music"
    }
}