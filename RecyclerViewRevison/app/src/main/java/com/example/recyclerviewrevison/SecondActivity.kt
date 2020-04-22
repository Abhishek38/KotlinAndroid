package com.example.recyclerviewrevison

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        DescriptionText.setText(intent.getStringExtra("Desc"))
        var roptio=RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)

        Glide.with(this)
            .applyDefaultRequestOptions(roptio)
            .load(intent.getStringExtra("image"))
            .into(CompleteImage)

    }
}
