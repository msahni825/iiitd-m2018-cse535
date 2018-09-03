package com.example.megha.a2_mt18100_musicplayerapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
        {
            Toast.makeText(context,"BOOT COMPLETED",Toast.LENGTH_SHORT).show();
        }
        if(intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED"))
        {
            Toast.makeText(context,"ACTION POWER CONNECTED",Toast.LENGTH_SHORT).show();

        }
        if(intent.getAction().equals("android.intent.action.AIRPLANE_MODE")) {

            Toast.makeText(context, "AIRPLANE MODE ON", Toast.LENGTH_SHORT).show();
        }

    }
}
