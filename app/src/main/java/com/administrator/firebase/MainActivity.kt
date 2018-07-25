package com.administrator.firebase

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    var data = ArrayList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    goToAdd()
startRecycleView()
        loadData()

    }
    fun loadData(){
        val firebase = FirebaseDatabase.getInstance().reference
        firebase.child("Data").addValueEventListener(object  : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(this@MainActivity,"Cancel",Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(p0: DataSnapshot) {
                p0.let {
                    data.clear()
                    it.children.forEach{

                        val  shot = it.getValue(Data::class.java)!!
                        data.add(shot)
                    }
                    recycleview.adapter.notifyDataSetChanged()

                }

            }

        })



    }
    fun startRecycleView(){
        var layoutManager = LinearLayoutManager(this)
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true

        recycleview.layoutManager = layoutManager
        recycleview.adapter = Adapter(data)
    }

    fun goToAdd(){
        var intent = Intent(this,AddActivity::class.java)
        addFab.setOnClickListener {
            startActivity(intent)
        }}
    }




