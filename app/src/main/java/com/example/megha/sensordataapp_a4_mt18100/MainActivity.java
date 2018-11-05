package com.example.megha.sensordataapp_a4_mt18100;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button accelerometer,gyroscope,proximity,orientation,gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accelerometer=findViewById(R.id.button6);
        gyroscope=findViewById(R.id.button2);
        proximity=findViewById(R.id.button4);
        orientation=findViewById(R.id.button3);
        gps=findViewById(R.id.button5);

        accelerometer.setOnClickListener(this);
        gyroscope.setOnClickListener(this);
        orientation.setOnClickListener(this);
        proximity.setOnClickListener(this);
        gps.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

            case R.id.button6:
                Intent i=new Intent(MainActivity.this,MySensorService.class);
                startService(i);
                break;

            case R.id.button2:
                Intent i2=new Intent(MainActivity.this,GyroscopeActivity.class);
                startActivity(i2);
                break;

            case R.id.button4:
                //Toast.makeText(this,"PROXIMITY",Toast.LENGTH_SHORT).show();
                Intent i3=new Intent(MainActivity.this,ProximityActivity.class);
                startActivity(i3);
                break;
            case R.id.button3:
                Intent i4=new Intent(MainActivity.this,OrientationActivity.class);
                startActivity(i4);
                break;
            case R.id.button5:
                Intent i5=new Intent(MainActivity.this,GPSSensor.class);
                startActivity(i5);
                break;

        }

    }
}
