package com.example.mvvmapplication.data

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapplication.MainViewModel
import com.example.mvvmapplication.R
import com.example.mvvmapplication.databinding.ActivityMainBinding
import com.example.mvvmapplication.databinding.ItemBinding

class BlogRecyclerView(val viewModel : MainViewModel, val arrayList: ArrayList<Blog>, val context: Context): RecyclerView.Adapter<BlogRecyclerView.BlogViewHlder>() {

    class BlogViewHlder (private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(blog: Blog){
            binding.title.text = blog.title

            binding.delete.setOnClickListener {
                viewModel.remove(blog)
                notifyItemRemoved(arrayList.indexOf(blog))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHlder {
       var root = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return BlogViewHlder(root)
    }

    override fun onBindViewHolder(holder: BlogViewHlder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int = arrayList.size
}