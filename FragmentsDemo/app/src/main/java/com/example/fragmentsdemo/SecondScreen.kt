package com.example.fragmentsdemo

import android.content.Intent
import android.content.Intent.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_second_screen.*


/**
 * A simple [Fragment] subclass.
 * Use the [SecondScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondScreen : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_screen, container, false)
    }

    override fun onStart() {
        super.onStart()
        DescriptionText.setText(arguments?.getString("Desc"))
        var roptio= RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)

        Glide.with(this)
            .applyDefaultRequestOptions(roptio)
            .load(arguments?.getString("image"))
            .into(CompleteImage)
    }


}
