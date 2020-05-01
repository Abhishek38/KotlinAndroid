package com.example.fragmentrevision

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.frag_2.*

class frag2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater?.inflate(R.layout.frag_2,container,false)
    }

    override fun onStart() {
        super.onStart()
        frag2_Text.setText(arguments?.getString("data2"))
        loadData()
        Toast.makeText(this.context,"This is Fragment2 running", Toast.LENGTH_SHORT)
    }
    fun loadData(){
        Glide.with(this)
            .applyDefaultRequestOptions(RequestOptions()
                .error(R.drawable.ic_launcher_foreground))
            .load(arguments?.getString("data"))
            .into(imageView)

    }

}