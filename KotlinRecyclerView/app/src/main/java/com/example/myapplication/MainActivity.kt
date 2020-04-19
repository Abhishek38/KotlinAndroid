package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var dataAdapter:ListRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycelerView.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            val spacing=itemDecorator(30)
            addItemDecoration(spacing)
            dataAdapter=ListRecyclerAdapter()
            adapter=dataAdapter
            addData()

        }
    }
    fun addData(){
        val datd=DataSource.createDataSet()
        dataAdapter.submitList(datd)
    }
}
