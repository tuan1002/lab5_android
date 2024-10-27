package com.example.lab3_12_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Danh sách các URL hình ảnh
        val imageUrls = listOf(
            "https://cdn.britannica.com/70/234870-050-D4D024BB/Orange-colored-cat-yawns-displaying-teeth.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Cat_sitting_on_a_staircase.jpg/800px-Cat_sitting_on_a_staircase.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Cat_in_a_box.jpg/800px-Cat_in_a_box.jpg"
        )


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Cài đặt adapter cho RecyclerView
        imageAdapter = ImageAdapter(imageUrls)
        recyclerView.adapter = imageAdapter
    }
}
