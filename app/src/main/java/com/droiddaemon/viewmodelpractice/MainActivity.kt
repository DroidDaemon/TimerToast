package com.droiddaemon.viewmodelpractice

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    val Tag = MainActivity::class.java.simpleName
    var  toastMessage : String  = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.generate_btn)
        val textView = findViewById<TextView>(R.id.textView)
        val toast_btn = findViewById<Button>(R.id.toast_btn)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        //handles the orientation change
        val number = viewModel.randomNumber
        textView.text = "Generated Number : $number"

        button.setOnClickListener(View.OnClickListener {

            viewModel.stopToasts()
        })

        toast_btn.setOnClickListener(View.OnClickListener {
            viewModel.generateToast()
            viewModel.toastMessage.observe(this, Observer {
                Toast.makeText(this,it,Toast.LENGTH_LONG).show()
                textView.text = it
            })


        })
    }




    override fun onDestroy() {
        super.onDestroy()

        Log.e(Tag , "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(Tag , "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(Tag , "onResume")
    }


    override fun onStart() {
        super.onStart()
        Log.e(Tag , "onStart")
    }


}