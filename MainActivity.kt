package com.example.recyclerview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private lateinit var editTextItem: EditText
    private lateinit var btnTambah: Button
    private val itemList = mutableListOf("Item 1", "Item 2", "Item 3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        editTextItem = findViewById(R.id.editTextItem)
        btnTambah = findViewById(R.id.btnTambah)

        adapter = ItemAdapter(itemList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnTambah.setOnClickListener {
            val newItem = editTextItem.text.toString().trim()
            if (newItem.isNotEmpty()) {
                adapter.addItem(newItem)
                editTextItem.text.clear()  // Kosongkan input setelah menambah item
            }
        }
    }
}
