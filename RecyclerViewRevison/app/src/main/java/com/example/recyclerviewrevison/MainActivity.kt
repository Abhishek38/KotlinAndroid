package com.example.recyclerviewrevison

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewrevison.Model.DataModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), onItemClick {
    private lateinit var Ladapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            val spacing = Decorator(10)
            addItemDecoration(spacing)
            var data = DataSource.createDataSet()
            Ladapter = ListAdapter(data, this@MainActivity)
            adapter = Ladapter


        }

    }


    override fun onclick(data: DataModel, I: Int) {
      var intent=Intent(this,SecondActivity::class.java)
        intent.putExtra("image",data.FImage)
        intent.putExtra("Desc",data.Desc)
        startActivity(intent)


    }
}
