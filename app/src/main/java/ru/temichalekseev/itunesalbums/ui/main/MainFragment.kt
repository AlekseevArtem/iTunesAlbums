package ru.temichalekseev.itunesalbums.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.temichalekseev.itunesalbums.App
import ru.temichalekseev.itunesalbums.R
import ru.temichalekseev.itunesalbums.repository.ITunesJsonHolderApi
import javax.inject.Inject

/**
 * Created on 25.11.2020.
 * @author Artem Alexeev
 * @version 1.0.0
 * @since 1.0.0
 * Fragment //////////////
 * Ruled by /////////////
 */
class MainFragment : Fragment() {
    @Inject lateinit var api: ITunesJsonHolderApi

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        App.dagger?.inject(this)

        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}