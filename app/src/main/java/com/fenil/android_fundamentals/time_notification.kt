package com.fenil.android_fundamentals

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService
import java.sql.Time
import java.util.Calendar


class time_notification : AppCompatActivity() {
    val channel_name="timenotification"
   lateinit var  calendar:Calendar
    @SuppressLint("InlinedApi")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_notification)
        val choose:Button=findViewById(R.id.button6)
        val send:Button=findViewById(R.id.button7)
        calendar=Calendar.getInstance()
        val data:EditText=findViewById(R.id.et1)
        val requestcode:EditText=findViewById(R.id.et2)
        createnotificationchannel()
      val alaram:AlarmManager
      alaram=getSystemService(Context.ALARM_SERVICE) as AlarmManager
        var hour1:Int=0
        var minute1:Int=0
        var value:Int=0
        choose.setOnClickListener{


            val hour=Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
            val minute=Calendar.getInstance().get(Calendar.MINUTE)
            val timpicker:TimePickerDialog
            val sys=System.currentTimeMillis()
            timpicker= TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                hour1=i
                minute1=i2
                calendar.timeInMillis=sys
                calendar.set(Calendar.HOUR_OF_DAY, hour1)
                calendar.set(Calendar.MINUTE,minute1)
                calendar.set(Calendar.SECOND,0)
                Toast.makeText(this,"$hour1:$minute1",Toast.LENGTH_LONG).show()
                text.value=data.text.toString()
                val data:String=requestcode.text.toString()
                value=Integer.parseInt(data)
                Toast.makeText(this,"$value",Toast.LENGTH_LONG).show()

            },hour,minute,false)
            timpicker.setCancelable(false)
            timpicker.show()
        }





        send.setOnClickListener{
            Toast.makeText(this,"request code for this notification is $value",Toast.LENGTH_LONG).show()
            alaram.setExact(AlarmManager.RTC_WAKEUP,calendar.timeInMillis,PendingIntent.getBroadcast(this,value,Intent(this,receiver3::class.java),PendingIntent.FLAG_MUTABLE))
            Toast.makeText(this,"reminder set",Toast.LENGTH_LONG).show()
        }








    }



    fun createnotificationchannel(){

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel=NotificationChannel("newchannel",channel_name,NotificationManager.IMPORTANCE_HIGH)
            val manager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

    }
}