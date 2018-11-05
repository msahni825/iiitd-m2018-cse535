package com.example.megha.sensordataapp_a4_mt18100;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GyroscopeActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    Sensor gyroscope;
    TextView x1Value, y1Value, z1Value;
    Button saveButton,viewButton;
    static int i=0;
    //Sensor sensorclass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        //gyroscope
        x1Value = findViewById(R.id.xvalue);
        y1Value = findViewById(R.id.yvalue);
        z1Value = findViewById(R.id.zvalue);
        saveButton=findViewById(R.id.button9);
        viewButton=findViewById(R.id.button10);

        Log.d("TAG", "Intializing Sensor Services");
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (gyroscope != null) {
            sensorManager.registerListener((SensorEventListener) GyroscopeActivity.this, gyroscope, SensorManager.SENSOR_DELAY_FASTEST);
            Log.d("TAG", "onCreate registered gyroscope sensor");
        } else {
            x1Value.setText("Sensor not supported");
        }
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
                Calendar c= Calendar.getInstance();
                SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss:aa");
                String datetime= dateFormat.format(c.getTime());
                databaseHelper.updatecolGyr(i++, x1Value.getText().toString(), y1Value.getText().toString(),z1Value.getText().toString(),datetime );
                Toast.makeText(getApplicationContext(),"ADDED SUCCESSFUL ",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor=event.sensor;
        if (sensor.getType() == Sensor.TYPE_GYROSCOPE)
        {
            Log.d("TAG", "onSensorChanged: x: " + event.values[0] + "y:" + event.values[1] + "z:" + event.values[2]);
            x1Value.setText("x value: " + event.values[0]);
            y1Value.setText("y value: " + event.values[1]);
            z1Value.setText("z value: " + event.values[2]);

        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}

