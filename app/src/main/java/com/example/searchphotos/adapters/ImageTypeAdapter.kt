package com.example.searchphotos.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.searchphotos.R
import com.example.unsplashgallery.models.Result
import com.example.unsplashgallery.models.UrlsX
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_item.view.*
import java.lang.Exception

class ImageTypeAdapter(private val imageList: List<Result>): RecyclerView.Adapter<ImageTypeAdapter.Vh>() {

    inner class Vh(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(urls: UrlsX) {
            Picasso.get().load(urls.small).into(itemView.image_view, object : Callback{
                override fun onSuccess() {
                    itemView.image_progress_bar.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                }

            })

            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("image", urls.full)
                itemView.findNavController().navigate(R.id.fullImageFragment, bundle)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(imageList[position].urls)
    }

    override fun getItemCount(): Int = imageList.size
}