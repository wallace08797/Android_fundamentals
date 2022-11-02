package com.fenil.android_fundamentals

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.hardware.lights.Light
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class Notification : AppCompatActivity() {
    val channel_name="fenil"
    val channel_id="channel_id"
    val notification_id=0


    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        val start:Button=findViewById(R.id.button)
        val newnotification:Button=findViewById(R.id.button2)
        createnotificationchannel()
        val taskstack=TaskStackBuilder.create(this)

        val parentintent=Intent(this,MainActivity::class.java)
        taskstack.addNextIntent(parentintent)

        val notifyintent= Intent(this,Notification::class.java)
        taskstack.addNextIntent(notifyintent)

     val penintent:PendingIntent
     penintent=taskstack.getPendingIntent(0,PendingIntent.FLAG_MUTABLE)


        val notification=NotificationCompat.Builder(this,channel_id)
        .setContentTitle("Welcome")
        .setContentText("hello welcome to instagram")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(penintent)
        .build()

        val notificationmanager=NotificationManagerCompat.from(this)



      start.setOnClickListener{
          notificationmanager.notify(notification_id,notification)

      }


   newnotification.setOnClickListener{
       val intent=Intent(this,custom_notification::class.java)
       startActivity(intent)
   }




    }


    fun createnotificationchannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val channel=NotificationChannel(channel_id,channel_name,NotificationManager.IMPORTANCE_HIGH).apply {

                lightColor=Color.GREEN
                enableLights(true)
            }

            val manager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }




}