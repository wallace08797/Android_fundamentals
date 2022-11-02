package com.fenil.android_fundamentals

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class createnotification(private val context: Context) {
    var id="channel_id"

    @RequiresApi(Build.VERSION_CODES.S)
    fun shownotification(counter:Int){

        val penintent:PendingIntent=PendingIntent.getBroadcast(context,1, Intent(context,receiver::class.java),PendingIntent.FLAG_MUTABLE)
        val penintent2:PendingIntent=PendingIntent.getBroadcast(context,2,
            Intent(context,receiver2::class.java),PendingIntent.FLAG_MUTABLE
        )
        var notification=NotificationCompat.Builder(context,id)
            .setContentTitle("welcome")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentText("hello the value of the counter is $counter")
            .addAction(
                R.drawable.ic_launcher_foreground,"Increment",penintent
            )
            .addAction(
                R.drawable.ic_launcher_foreground,"decrement",penintent2
            )
            .build()

        val manager=NotificationManagerCompat.from(context)
        manager.notify(1,notification)
    }

}


