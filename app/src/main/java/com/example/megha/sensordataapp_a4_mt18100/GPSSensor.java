package com.example.megha.sensordataapp_a4_mt18100;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GPSSensor extends AppCompatActivity {

    private Button buttonlocation;
    //private TextView textView,textView1;
//    private LocationManager locationManager;
//    private LocationListener locationListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpssensor);

        buttonlocation =findViewById(R.id.buttonloc);
//        textView=findViewById(R.id.textView);
//        textView1=findViewById(R.id.textView2);
       ActivityCompat.requestPermissions(GPSSensor.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);
        buttonlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                GPSTracker g=new GPSTracker(getApplicationContext());
                Location location=g.getLocation();
                if(location!=null)
                {
                    double latitude=location.getLatitude();
                    double longitude=location.getLongitude();
//                    textView.setText((int)location.getLatitude());
//                    textView1.setText((int)location.getLongitude());
                   Toast.makeText(getApplicationContext(),"Latitude:"+latitude+"\n Longitude: "+longitude,Toast.LENGTH_SHORT).show();


                }


            }
        });

    }
}

