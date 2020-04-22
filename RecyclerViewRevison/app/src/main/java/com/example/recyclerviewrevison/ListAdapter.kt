package com.example.recyclerviewrevison

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.recyclerviewrevison.Model.DataModel
import kotlinx.android.synthetic.main.layout_model.view.*

class ListAdapter(var items:ArrayList<DataModel>, var dataClick: onItemClick):RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var front=itemView.foreground_
        var back=itemView.background_
        var sign=itemView.signature


        fun bind(model:DataModel,clickData:onItemClick){
            var requestoptions=RequestOptions()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestoptions)
                .load(model.FImage)
                .into(front)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestoptions)
                .asDrawable()
                .load(model.BImage)
                .into(back)


            sign.setText(model.Sign)
            itemView.setOnClickListener {
                clickData.onclick(model,absoluteAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.layout_model,parent,false))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position),dataClick)

    }
}

interface onItemClick{
    fun onclick(data:DataModel,I: Int)
}