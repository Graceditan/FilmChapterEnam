package binar.and.lima.filmchapterenam.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.and.lima.filmchapterenam.R
import binar.and.lima.filmchapterenam.model.GetAllFilmResponseItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_film.view.*

class AdapterFilm (private var datafilm : List<GetAllFilmResponseItem>): RecyclerView.Adapter<AdapterFilm.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewitem = LayoutInflater.from(parent.context).inflate(
            R.layout
                .item_film, parent, false
        )
        return ViewHolder(viewitem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_judulfilm.text = datafilm[position].title
        holder.itemView.tv_tanggalfilm.text = datafilm[position].createdAt
        holder.itemView.tv_penulisfilm.text = datafilm[position].director

        //Glide.with(holder.itemView.context).load(datafilm[position]).into(holder.itemView.imagefilm)

        Glide.with(holder.itemView.context).load(datafilm!![position].image).into(holder.itemView.imagefilm)

    }

    override fun getItemCount(): Int {
        return datafilm.size


    }
}