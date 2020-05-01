package com.example.fragmentrevision

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.frag_layout.*

class frag : Fragment() {
    val link="https://static2.srcdn.com/wordpress/wp-content/uploads/2016/12/Vegeta-dies.jpg?q=50&fit=crop&w=737&h=368"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_layout,container,false)
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this.context,"This is Fragment1 running",Toast.LENGTH_SHORT)
        fragText.setOnClickListener {
            var man=fragmentManager?.beginTransaction()
            man?.addToBackStack(null)
            val fag2=frag2()
            man?.replace(R.id.parentpapa,fag2)
            if (man != null) {
                man.commit()
                bindData(fag2)
            }

        }
    }
    fun bindData(Fag:Fragment){
      var  bundel=Bundle()
        bundel.putString("data",link)
        bundel.putString("data2","THis is text")
        Fag.setArguments(bundel)
    }
}