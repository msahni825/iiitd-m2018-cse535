package com.example.megha.sensordataapp_a4_mt18100;

import android.content.Intent;
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

public class ProximityActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager;
    Sensor proximity;
    TextView x3Value, y3Value, z3Value;
    Button savedata,checkdist;
    static int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        x3Value = findViewById(R.id.x3value);
        y3Value = findViewById(R.id.y3value);
        z3Value = findViewById(R.id.z3value);
        savedata=findViewById(R.id.button9);
        checkdist=findViewById(R.id.button10);

        Log.d("TAG", "Intializing Sensor Services");
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db=new DatabaseHelper(getApplicationContext());
                Calendar c= Calendar.getInstance();
                SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss:aa");
                String datetime= dateFormat.format(c.getTime());
                db.updatecolPro(i++, x3Value.getText().toString(), y3Value.getText().toString(),z3Value.getText().toString(),datetime );
                Toast.makeText(getApplicationContext(),"ADDED SUCCESSFUL ",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onSensorChanged(final SensorEvent event) {
        Sensor sensor=event.sensor;
        if (sensor.getType() == Sensor.TYPE_PROXIMITY)
        {
            //Log.d("TAG", "onSensorChanged: x: " + event.values[0] + "y:" + event.values[1] + "z:" + event.values[2]);
            x3Value.setText("x value: " + event.values[0]);
            y3Value.setText("y value: " + event.values[1]);
            z3Value.setText("z value: " + event.values[2]);

       }
        checkdist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(event.values[0]==0)
                {
                    Toast.makeText(getApplicationContext(),"Phone is NEAR to users face",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),NearDetectionActivity.class);
                    startActivity(i);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Phone is FAR from users face",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public  void onResume()
    {

        super.onResume();
        sensorManager.registerListener(this,proximity,SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onPause() {


        super.onPause();
        sensorManager.unregisterListener(this);

    }

}
