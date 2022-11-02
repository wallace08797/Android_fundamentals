package com.fenil.android_fundamentals

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class receiver3:BroadcastReceiver() {


    override fun onReceive(context: Context, p1: Intent?) {

        val notification=NotificationCompat.Builder(context,"newchannel")
            .setContentTitle("Hello sir there is a reminder for you")
            .setContentText(text.value)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()
        val manager=NotificationManagerCompat.from(context)
        manager.notify(4,notification)



    }


}