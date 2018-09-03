package com.example.megha.a2_mt18100_musicplayerapp;

import android.app.DownloadManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class Internet_Service extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
       throw new UnsupportedOperationException("not implemented");
    }

    public boolean isNetworkConnected() {

        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {

            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null) {

                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {

                    Toast.makeText(this, "You are connected to internet", Toast.LENGTH_SHORT).show();
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (isNetworkConnected()==true)
        {
            Toast.makeText(this, "You are connected to internet", Toast.LENGTH_SHORT).show();
            DownloadManager downloadManager = (DownloadManager) getSystemService(this.DOWNLOAD_SERVICE);
            Uri u = Uri.parse("http://faculty.iiitd.ac.in/~mukulika/s1.mp3");
            Toast.makeText(this, "Connected to the web server", Toast.LENGTH_SHORT).show();
            DownloadManager.Request request = new DownloadManager.Request(u);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            Long reference = downloadManager.enqueue(request);

        } else
            Toast.makeText(this, "NOT connected to internet", Toast.LENGTH_SHORT).show();

        return START_STICKY;

    }
}