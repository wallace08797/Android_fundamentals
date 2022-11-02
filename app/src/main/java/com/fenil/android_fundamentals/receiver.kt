package com.fenil.android_fundamentals

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

class receiver : BroadcastReceiver() {

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onReceive(p0: Context, p1: Intent?) {

        val service=createnotification(p0)
        service.shownotification(++counter.value)
    }
}