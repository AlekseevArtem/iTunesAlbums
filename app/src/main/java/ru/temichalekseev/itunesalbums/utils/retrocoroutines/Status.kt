package ru.temichalekseev.itunesalbums.utils.retrocoroutines

/**
 * Created on 26.11.2020.
 * @author Artem Alexeev
 * @version 1.0
 * @since 1.0
 * Class with states. Realization pattern State for answer from API.
 */
enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}