package ru.temichalekseev.itunesalbums.ui.main.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.*
import ru.temichalekseev.itunesalbums.App
import ru.temichalekseev.itunesalbums.R
import ru.temichalekseev.itunesalbums.data.api.ITunesAPIHelper
import ru.temichalekseev.itunesalbums.data.model.Album
import ru.temichalekseev.itunesalbums.databinding.AlbumsFragmentBinding
import ru.temichalekseev.itunesalbums.ui.base.ViewModelFactory
import ru.temichalekseev.itunesalbums.ui.main.adapter.AlbumsAdapter
import ru.temichalekseev.itunesalbums.ui.main.viewmodel.AlbumsViewModel
import ru.temichalekseev.itunesalbums.utils.retrocoroutines.Status.*
import javax.inject.Inject


/**
 * Created on 25.11.2020.
 * @author Artem Alexeev
 * @version 1.0
 * @since 1.0
 * Fragment //////////////
 * Ruled by /////////////
 */
class AlbumsFragment : Fragment(R.layout.albums_fragment), AlbumsAdapter.RecyclerViewClickListener {
    private lateinit var binding: AlbumsFragmentBinding
    private lateinit var viewModel: AlbumsViewModel
    @Inject
    lateinit var apiHelper: ITunesAPIHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AlbumsFragmentBinding.bind(view)
        setHasOptionsMenu(true)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        App.remote?.injectTo(this)
        setupViewModel()
        setupUI()
        setupObservers()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_single, menu)
        val search = menu.findItem(R.id.action_search).actionView as SearchView
        customizeSearchView(search)
    }

    private fun customizeSearchView(search: SearchView): Unit = search.run {
        queryHint = "Ищем в айтюнс..."
        setQuery(viewModel.getSearch(), false)
        setIconifiedByDefault(false)
        maxWidth = 5000
        isSaveEnabled = true
        setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String) = false
            override fun onQueryTextChange(change: String): Boolean {
                viewModel.setSearch(change)
                return true
            }
        })
    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(apiHelper)
        ).get(AlbumsViewModel::class.java)
    }

    private fun setupUI() {
        binding.albumsRv.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = AlbumsAdapter(arrayListOf(), this@AlbumsFragment)
        }
    }

    private fun setupObservers() {
        viewModel.getAlbums().observe(requireActivity(), {
            it?.let { resource ->
                when (resource.status) {
                    SUCCESS -> {
                        resource.data?.let { albums -> retrieveList(albums) }
                    }
                    ERROR -> {
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    LOADING -> {
                    }
                }
            }
        })
    }

    private fun retrieveList(albums: List<Album>) {
        (binding.albumsRv.adapter as AlbumsAdapter).apply {
            addAlbums(albums)
            notifyDataSetChanged()
        }
    }

    override fun onItemClicked(view: View, album: Album) {
        val toTracksFragment = AlbumsFragmentDirections.actionAlbumsFragmentToTracksFragment(album)
        val extras = FragmentNavigatorExtras(view to album.collectionId.toString())
        navigate(toTracksFragment, extras)
    }

    private fun navigate(destination: NavDirections, extraInfo: FragmentNavigator.Extras) =
        with(findNavController()) {
            currentDestination?.getAction(destination.actionId)
                ?.let { navigate(destination, extraInfo) }
        }
}