package com.example.mvvmapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapplication.data.Blog
import com.example.mvvmapplication.data.BlogRecyclerView
import com.example.mvvmapplication.databinding.ActivityMainBinding
import java.util.EnumSet.of

class MainActivity : AppCompatActivity() {

    private var viewManager = LinearLayoutManager(this)
    private lateinit var viewModel: MainViewModel
    private lateinit var mainRecycler: RecyclerView

    private lateinit var but: Button

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainRecycler = binding.recycler

        val application = requireNotNull(this).application
        val factory = MainActivityViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        binding.button.setOnClickListener {
            addData()
        }
        initializeAdapter()
    }

    private fun initializeAdapter() {
        mainRecycler.layoutManager = viewManager
        observeData()
    }

    private fun observeData() {
        viewModel.lst.observe(this, Observer {
            mainRecycler.adapter = BlogRecyclerView(viewModel, it , this)
        })
    }

    private fun addData() {
       val title = binding.titletext.text.toString()
        if (title.isNullOrBlank()){
            Toast.makeText(this, "Enter Data", Toast.LENGTH_LONG).show()
        } else
            var blog = Blog(title)

        viewModel.add(blog)
        binding.titletext.text.clear()
        mainRecycler.adapter?.notifyDataSetChanged()
    }
}