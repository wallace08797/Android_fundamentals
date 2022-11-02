package com.fenil.android_fundamentals

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

class receiver2 :BroadcastReceiver(){

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onReceive(context: Context, p1: Intent?) {
        val service=createnotification(context)
        service.shownotification(--counter.value)

        if(counter.value<0){
            counter.value=0
          service.shownotification(counter.value)
        }


    }
}