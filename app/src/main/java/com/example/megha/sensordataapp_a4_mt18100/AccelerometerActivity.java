package com.example.megha.sensordataapp_a4_mt18100;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.media.audiofx.AudioEffect.ERROR;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {

    DatabaseHelper db;
    static int i=0;
    Long t;
    //Location location=
    private SensorManager sensorManager;
    Sensor accelerometer;
    TextView xValue, yValue, zValue;
    Button savedata,viewdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        //accelerometer
        xValue = (TextView) findViewById(R.id.xvalue);
        yValue = (TextView) findViewById(R.id.yvalue);
        zValue = (TextView) findViewById(R.id.zvalue);
        savedata=(Button) findViewById(R.id.button9);
        viewdata=(Button) findViewById(R.id.button10);


        Log.d("TAG", "Intializing Sensor Services");
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer != null) {
            sensorManager.registerListener((SensorEventListener) AccelerometerActivity.this, accelerometer, SensorManager.SENSOR_DELAY_FASTEST);
            Log.d("TAG", "onCreate registered accelerometer sensor");
        } else {
            xValue.setText("Sensor not supported");
        }
        //int i;
        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                DatabaseHelper db=new DatabaseHelper(getApplicationContext());
                Calendar c= Calendar.getInstance();
                SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss:aa");
                //t = location.getTime();
                db.updatecolAcc(xValue.getText().toString(),yValue.getText().toString(),zValue.getText().toString());
                Toast.makeText(getApplicationContext(),"ADDED SUCCESSFUL ",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor=event.sensor;
        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            Log.d("TAG", "onSensorChanged: x: " + event.values[0] + "y:" + event.values[1] + "z:" + event.values[2]);
            xValue.setText("x value: " + event.values[0]);
            yValue.setText("y value: " + event.values[1]);
            zValue.setText("z value: " + event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override
    public void onPause() {

        super.onPause();
        sensorManager.unregisterListener(this);
    }

}
