package com.example.megha.a2_mt18100_musicplayerapp;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.Toast;

public class My_Service extends Service {

    Button start, stop;
    private MediaPlayer player;

    @Nullable
    @Override

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();

        String data=intent.getStringExtra("song_key");
        AudioManager am=(AudioManager)this.getSystemService(getApplicationContext().AUDIO_SERVICE);
        if(am.isMusicActive())
        {
         player.pause();
        }

        player = MediaPlayer.create(getApplicationContext(),getResources().getIdentifier(data,"raw",getPackageName()));
        player.setLooping(true);
        player.start();
        return START_STICKY;

    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        player.stop();
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();

    }
}
