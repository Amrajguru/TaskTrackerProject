package com.example.tasktrackerproject

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var itemset : MutableList<Item> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var inputbutton = findViewById<Button>(R.id.inputbutton)
        var Titlename = findViewById<EditText>(R.id.TitleInput)
        var Costvalue = findViewById<EditText>(R.id.CostInput)
        var Urltag = findViewById<EditText>(R.id.UrlInput)

        Titlename.setOnClickListener(){
            Titlename.isFocusableInTouchMode=true
            Titlename.isFocusable=false
        }

        Costvalue.setOnClickListener(){
            Titlename.isFocusableInTouchMode=true
            Titlename.isFocusable=false
        }

        Urltag.setOnClickListener(){
            Titlename.isFocusableInTouchMode=true
            Titlename.isFocusable=false
        }

        inputbutton.setOnClickListener {
            val fullitemadd =
                Item(Titlename.text.toString(), Costvalue.text.toString(), Urltag.text.toString())
            itemset.add(fullitemadd)
            // Lookup the RecyclerView in activity layout
            val itemsRv = findViewById<RecyclerView>(R.id.itemsRv)

            // Create adapter passing in the list of emails
            val adapter = ItemAdapter(itemset)
            // Attach the adapter to the RecyclerView to populate items
            itemsRv.adapter = adapter
            // Set layout manager to position the items
            itemsRv.layoutManager = LinearLayoutManager(this)
        }
    }
}