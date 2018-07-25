package com.administrator.firebase

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        goBack()
        saveAction()

    }
    fun goBack(){

        back.setOnClickListener {
            finish()
        }

    }
    fun saveAction(){
        save.setOnClickListener {
            var data = Data()

            var  firebase = FirebaseDatabase.getInstance().reference
            var  key = firebase.push().key.toString()


            data.apply {
                id = key
                title = etitle.text.toString()
                message = ems.text.toString()
            }
            firebase.child("Data").child(key).setValue(data).addOnSuccessListener {
                finish()
            }
                    .addOnFailureListener{
                        Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show()
                    }
        }
        }

    }


