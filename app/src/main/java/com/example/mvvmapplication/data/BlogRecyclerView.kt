package com.example.mvvmapplication.data

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapplication.MainViewModel
import com.example.mvvmapplication.databinding.ActivityMainBinding

class BlogRecyclerView(val viewModel : MainViewModel, val arrayList: ArrayList<Blog>, val context: Context): RecyclerView.Adapter<BlogRecyclerView.BlogViewHlder>() {
    inner class BlogViewHlder (private val binding: View): RecyclerView.ViewHolder(binding) {
        fun bind(blog: Blog){
            val title = binding

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHlder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BlogViewHlder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = arrayList.size
}