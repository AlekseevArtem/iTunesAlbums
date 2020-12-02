package ru.temichalekseev.itunesalbums.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import ru.temichalekseev.itunesalbums.R
import ru.temichalekseev.itunesalbums.data.model.Album
import ru.temichalekseev.itunesalbums.databinding.ItemAlbumBinding


class AlbumsAdapter(
    private val albums: ArrayList<Album>,
    private val callback: RecyclerViewClickListener
) :
    RecyclerView.Adapter<AlbumsAdapter.DataViewHolder>() {

    interface RecyclerViewClickListener {
        fun onItemClicked(view: View, album: Album)
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemAlbumBinding by lazy {
            ItemAlbumBinding.bind(itemView)
        }

        fun bind(album: Album) {
            binding.apply {
                albumArtist.text = album.artistName
                albumName.text = album.collectionName
                albumArtwork.load(album.artworkUrl100) {
                    crossfade(enable = true)
                    crossfade(300)
                    diskCachePolicy(CachePolicy.DISABLED)
                }
                ViewCompat.setTransitionName(albumArtwork, album.collectionId.toString())
                itemContainer.setOnClickListener { callback.onItemClicked(albumArtwork, album) }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)
        )

    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(albums[position])

    fun addAlbums(users: List<Album>) {
        albums.apply {
            clear()
            addAll(users)
        }
    }
}