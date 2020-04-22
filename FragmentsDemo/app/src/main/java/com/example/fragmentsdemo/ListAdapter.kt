package com.example.fragmentsdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.fragmentsdemo.Models.DataModels
import kotlinx.android.synthetic.main.layout_model.view.*

class ListAdapter(var items: ArrayList<DataModels>, var clk: clickListner) :
    RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fImage = view.foreground_
        val bImage = view.background_
        val sign = view.signature

        fun bind(models: DataModels, lstner: clickListner) {
            var rqptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(rqptions)
                .load(models.mF_Image)
                .into(fImage)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(rqptions)
                .load(models.mB_Image)
                .into(bImage)
            bImage.setLayerType(View.LAYER_TYPE_HARDWARE, null)
            bImage.imageAlpha.rangeTo(5)
            sign.setText(models.mSign)

            itemView.setOnClickListener {
                lstner.Onclick(models, absoluteAdapterPosition)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_model, parent, false)
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position), clk)
    }
}

interface clickListner {
    fun Onclick(items: DataModels, i: Int)
}