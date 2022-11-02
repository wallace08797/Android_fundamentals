package com.fenil.android_fundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get
import androidx.core.view.size

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner:Spinner
        spinner=findViewById(R.id.spinner)
        val arr= arrayOf("Upwork","Fiver","people per hour","freelancer")
        val adapter:Adapter=ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arr)
        val intent: Intent =Intent(this,Notification::class.java)
        spinner.adapter= adapter as SpinnerAdapter?
        spinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{

            override fun onItemSelected(adapterview: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

               if(adapterview!=null){

                  if(p2!=0){
                  startActivity(intent)
                  }
               }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }



    }
}