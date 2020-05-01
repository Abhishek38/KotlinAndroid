package com.example.fragmentsdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentsdemo.Models.DataModels
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity(),clickListner{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MyApp","Main Activity loaded")
        initRecyclerView()



    }

    fun initFragment(){
        var transaction = supportFragmentManager.beginTransaction()
        val fragment =FragmentD()
        transaction.replace(R.id.container_,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun initRecyclerView(){
        recycler_view.apply {
            layoutManager= LinearLayoutManager(context)
            val spacing=itemDecorator(10)
            addItemDecoration(spacing)
            adapter=ListAdapter(DataSource.createDataSet(),this@MainActivity)



        }

    }

    override fun Onclick(items: DataModels, i: Int) {
//        val bundle = Bundle()
//        Log.d("MyApp","OnClick on FirstFragment Working")
//        bundle.putString("image",items.mF_Image.get(i).toString() )
//        bundle.putString("Desc",items.mDesc.get(i).toString())
//        val fragobj = FragmentD()
//        fragobj.setArguments(bundle)
        FragmentD.newInstance(items.mF_Image,items.mDesc)
        initFragment()
    }


}
