package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.Model.DataModel
import kotlinx.android.synthetic.main.list_format.view.*

class ListRecyclerAdapter: RecyclerView.Adapter<ListRecyclerAdapter.ViewHolder>() {
    var items=ArrayList<DataModel>()


    class ViewHolder constructor(itemView: View):RecyclerView.ViewHolder(itemView){
        val foreImage=itemView.profilePic
        val backImage=itemView.background_Image
        val text=itemView.description
        fun bind(model:DataModel){
            var requestOptions=RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(model.mFImage)
                .into(foreImage)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(model.mBImage)
                .into(backImage)
            text.setText(model.mDesc)

        }
    }
    fun submitList(blogList: ArrayList<DataModel>){
        items = blogList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_format,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder){
            is ViewHolder->{
                holder.bind(items.get(position))

            }
        }
    }
}