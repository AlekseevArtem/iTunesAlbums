package ru.temichalekseev.itunesalbums.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import coil.load
import com.google.android.material.transition.MaterialContainerTransform
import ru.temichalekseev.itunesalbums.App
import ru.temichalekseev.itunesalbums.R
import ru.temichalekseev.itunesalbums.data.api.ITunesAPIHelper
import ru.temichalekseev.itunesalbums.data.model.Album
import ru.temichalekseev.itunesalbums.data.model.Track
import ru.temichalekseev.itunesalbums.databinding.TracksFragmentBinding
import ru.temichalekseev.itunesalbums.ui.base.ViewModelFactory
import ru.temichalekseev.itunesalbums.ui.main.adapter.TracksAdapter
import ru.temichalekseev.itunesalbums.ui.main.viewmodel.TracksViewModel
import ru.temichalekseev.itunesalbums.utils.retrocoroutines.Status
import javax.inject.Inject

/**
 * Created on 28.11.2020.
 * @author Artem Alexeev
 * @version 1.0
 * @since 1.0
 * Fragment //////////////
 * Ruled by /////////////
 */
class TracksFragment : Fragment(R.layout.tracks_fragment) {
    private lateinit var binding: TracksFragmentBinding
    private lateinit var viewModel: TracksViewModel
    @Inject lateinit var apiHelper: ITunesAPIHelper
    private val album: Album by lazy { args.album }
    private val args: TracksFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = 300L
            isElevationShadowEnabled = true
//            setAllContainerColors(R.color.white)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = TracksFragmentBinding.bind(view)
        binding.albumArtwork.load(album.artworkUrl100)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            binding.albumDetails.transitionName = album.collectionId.toString()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        App.remote?.injectTo(this)
        setupViewModel()
        setupUI()
        setupObservers()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(apiHelper)
        ).get(TracksViewModel::class.java)
    }

    private fun setupUI() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(
                DividerItemDecoration(
                    binding.recyclerView.context,
                    (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
                )
            )
            adapter = TracksAdapter(arrayListOf())
        }
    }

    private fun setupObservers() {
        viewModel.getTracks(album.collectionId).observe(requireActivity(), {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { tracks -> retrieveList(tracks) }
                    }
                    Status.ERROR -> {
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
    }

    private fun retrieveList(tracks: List<Track>) {
        (binding.recyclerView.adapter as TracksAdapter).apply {
            addAlbums(tracks)
            notifyDataSetChanged()
        }
    }
}