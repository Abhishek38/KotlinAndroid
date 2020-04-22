package com.example.fragmentsdemo

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView

class itemDecorator(val padding:Int):RecyclerView.ItemDecoration(){
    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        super.getItemOffsets(outRect, itemPosition, parent)
        outRect.top=padding
    }
}