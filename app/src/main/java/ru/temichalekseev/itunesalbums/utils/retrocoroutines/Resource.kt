package ru.temichalekseev.itunesalbums.utils.retrocoroutines

import ru.temichalekseev.itunesalbums.utils.retrocoroutines.Status.*

/**
 * Created on 26.11.2020.
 * @author Artem Alexeev
 * @version 1.0
 * @since 1.0
 */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): Resource<T> =
            Resource(status = ERROR, data = data, message = message)

        fun <T> loading(data: T?): Resource<T> = Resource(status = LOADING, data = data, message = null)
    }
}