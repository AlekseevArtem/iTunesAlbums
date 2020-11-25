package ru.temichalekseev.itunesalbums.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.temichalekseev.itunesalbums.App
import ru.temichalekseev.itunesalbums.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}