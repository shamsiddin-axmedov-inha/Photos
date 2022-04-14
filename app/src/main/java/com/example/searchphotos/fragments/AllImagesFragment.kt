package com.example.searchphotos.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.searchphotos.R
import com.example.searchphotos.adapters.ImageTypeAdapter
import com.example.searchphotos.retrofit.RetrofitService
import com.example.unsplashgallery.models.Photos
import com.example.unsplashgallery.models.Result
import com.example.unsplashgallery.retrofit.Common
import kotlinx.android.synthetic.main.fragment_all_images.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [AllImagesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AllImagesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    lateinit var root: View
    lateinit var imageTypeAdapter: ImageTypeAdapter
    lateinit var retrofitService: RetrofitService
    private val clientId = "prMrqL_0Ba9E53tjEgfYOxSSWlS9AZasI-n7W0iY46o"
    val imageList = arrayListOf<Result>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_all_images, container, false)

        imageTypeAdapter = ImageTypeAdapter(imageList)
        retrofitService = Common.retrofitService
        root.rv.adapter = imageTypeAdapter

        param1?.let { getImages(it) }
        return root
    }

    private fun getImages(str: String) {
        retrofitService.getImageResponse(str, clientId, 20)
            .enqueue(object : Callback<Photos> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
                    if (response.isSuccessful) {
                        response.body()?.let { imageList.addAll(it.results) }
                        imageTypeAdapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<Photos>, t: Throwable) {
                }

            })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AllImagesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            AllImagesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}