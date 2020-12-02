package ru.temichalekseev.itunesalbums.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.temichalekseev.itunesalbums.R
import ru.temichalekseev.itunesalbums.data.model.Track
import ru.temichalekseev.itunesalbums.databinding.ItemAlbumBinding


class TracksAdapter(private val tracks: ArrayList<Track>) :
    RecyclerView.Adapter<TracksAdapter.DataViewHolder>() {

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemAlbumBinding by lazy {
            ItemAlbumBinding.bind(itemView)
        }

        fun bind(track: Track) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)
        )

    override fun getItemCount(): Int = tracks.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(tracks[position])

    fun addAlbums(tracks: List<Track>) {
        this.tracks.apply {
            clear()
            addAll(tracks)
        }
    }
}