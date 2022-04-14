package com.example.searchphotos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.searchphotos.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_full_image.view.*
import java.lang.Exception

class FullImageFragment : Fragment() {

    private lateinit var root: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_full_image, container, false)

        val image = arguments?.getString("image")
        Picasso.get().load(image).into(root.fullImage, object : Callback{
            override fun onSuccess() {
                root.progress_bar.visibility = View.GONE
            }

            override fun onError(e: Exception?) {
            }

        })
        return root
    }
}