package com.example.megha.sensordataapp_a4_mt18100;

import android.content.res.Configuration;
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

public class OrientationActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    Sensor orientation;
    TextView x2Value,y2Value,z2Value;
    Button savedata, checkort;
    static int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);
        //orientation
        x2Value = findViewById(R.id.x2value);
        y2Value = findViewById(R.id.y2value);
        z2Value = findViewById(R.id.z2value);
        savedata=findViewById(R.id.button9);
        checkort=findViewById(R.id.button10);

        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        orientation = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

        checkort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                {

                    Toast.makeText(getApplicationContext(),"Orientation is LANDSCAPE !",Toast.LENGTH_LONG).show();
                }
                else
                {

                    Toast.makeText(getApplicationContext(),"Orientation is POTRAIT !",Toast.LENGTH_LONG).show();

                }
            }
        });
        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db=new DatabaseHelper(getApplicationContext());
                Calendar c= Calendar.getInstance();
                SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss:aa");
                String datetime= dateFormat.format(c.getTime());
                db.updatecolOri(i++, x2Value.getText().toString(), y2Value.getText().toString(),z2Value.getText().toString(),datetime );
                Toast.makeText(getApplicationContext(),"ADDED SUCCESSFUL ",Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor=event.sensor;

        if(sensor.getType() == Sensor.TYPE_ORIENTATION)
        {

            x2Value.setText("x value: " + event.values[0]);
            y2Value.setText("y value: " + event.values[1]);
            z2Value.setText("z value: " + event.values[2]);


        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public  void onResume()
    {

        super.onResume();
        sensorManager.registerListener(this,orientation,SensorManager.SENSOR_DELAY_FASTEST);
    }

    public void onPause() {


        super.onPause();
        sensorManager.unregisterListener(this);

    }

}
