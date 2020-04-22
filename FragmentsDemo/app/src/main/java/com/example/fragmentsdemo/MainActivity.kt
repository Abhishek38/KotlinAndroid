package com.example.fragmentsdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentsdemo.Models.DataModels
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),clickListner{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()

    }
    fun initRecyclerView(){
        recycler_view.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            val spacing=itemDecorator(10)
            addItemDecoration(spacing)
            adapter=ListAdapter(DataSource.createDataSet(),this@MainActivity)



        }

    }
    fun initFragment(){
        var transaction = supportFragmentManager.beginTransaction()
        val fragment =SecondScreen()
        transaction.replace(R.id.container_,fragment)
        transaction.commit()
    }

    override fun Onclick(data: DataModels, i: Int) {
//        var intent=Intent(this,SecondScreen::class.java)
//        intent.putExtra("image",items.mF_Image)
//        intent.putExtra("Desc",items.mDesc)
//        startActivity(intent)
        val bundle = Bundle()
        bundle.putString("image",data.mF_Image )
        bundle.putString("Desc",data.mDesc)
// set Fragmentclass Arguments
// set Fragmentclass Arguments
        val fragobj = SecondScreen()
        fragobj.setArguments(bundle)

        initFragment()

    }
    fun sendData(){

    }
}
