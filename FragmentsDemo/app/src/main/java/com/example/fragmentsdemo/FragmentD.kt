package com.example.fragmentsdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_second_screen.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val url = "param1"
//private const val txt = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentD.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentD : Fragment() {
    private var Url: String? = null
    private var desc: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            Url = it.getString(ImgURl)
            desc = it.getString(DescData)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_screen, container, false)
    }

    companion object {
        private var ImgURl="imgurl"
        private var DescData="Data"

        fun newInstance(URL: String, DESC: String) =
            FragmentD().apply {
                arguments = Bundle().apply {
                    putString(ImgURl, URL)
                    putString(DescData, DESC)
                }
            }
    }

    override fun onStart() {
        super.onStart()
        DescriptionText.setText(desc)
        Glide.with(this)
            .applyDefaultRequestOptions(
                RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground))
            .load(Url)
            .into(CompleteImage)
    }
}
