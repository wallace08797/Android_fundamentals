package com.fenil.android_fundamentals

import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat
import java.util.Calendar

class custom_notification : AppCompatActivity(), DatePickerDialog.OnDateSetListener {


     val channel_name="custom_notification"
    val channel_id="channel_id"
     lateinit var not:android.app.Notification
   lateinit   var resintent:PendingIntent

     @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_notification)

        val show:Button=findViewById(R.id.button3)
         val datebutton:Button=findViewById(R.id.button4)
         val next:Button=findViewById(R.id.button5)
         next.setOnClickListener{
             val intent:Intent=Intent(this,time_notification::class.java)
             startActivity(intent)
         }

         datebutton.setOnClickListener {

             val calender=Calendar.getInstance()
             var year=calender.get(Calendar.YEAR)
             var month=calender.get(Calendar.MONTH)
             var day=calender.get(Calendar.DAY_OF_MONTH)
             val datepicker = DatePickerDialog(this,this,year,month,day)
             datepicker.setCancelable(false)
             datepicker.show()

         }





         createchannel()


        val notificationmanager=NotificationManagerCompat.from(this)

         val service=createnotification(this)
         show.setOnClickListener{
             service.shownotification(counter.value)
         }



    }




    fun createchannel(){

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            val channel=NotificationChannel(channel_name,channel_id,NotificationManager.IMPORTANCE_DEFAULT)
            val manager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {

        Toast.makeText(this,"$p1-${p2+1}-$p3",Toast.LENGTH_LONG).show()

        val calender:Calendar=Calendar.getInstance()
        val hour=calender.get(Calendar.HOUR_OF_DAY)
        val minute=calender.get(Calendar.MINUTE)


        val timepicker:TimePickerDialog
        timepicker= TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
         Toast.makeText(this,"$i:$i2",Toast.LENGTH_LONG).show()
        },hour,minute,false)
        timepicker.setCancelable(false)
        timepicker.show()



    }



}


