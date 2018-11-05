package com.example.megha.sensordataapp_a4_mt18100;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MySensorService extends Service implements SensorEventListener {


    float xAcc,yAcc,zAcc;
    float xPrevAcc,yPrevAcc,zPrevAcc;
    boolean shakeInitiated=false;
    boolean firstUpdate=true;
    float shakeThreshold=12.5f;

    Sensor accelerometer;
    SensorManager sm;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate()
    {

        super.onCreate();
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(accelerometer!=null)
        {
            sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        }
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        updateAccParameters(event.values[0],event.values[1],event.values[2]);
        if((!shakeInitiated) && isAccelerationChanged())
        {
            shakeInitiated=true;
        }

        else if((shakeInitiated) && isAccelerationChanged())
        {

            //Toast.makeText(this,"SHAKE DETECTED",Toast.LENGTH_SHORT).show();
            executeShakeAction();
        }
        else if((shakeInitiated) && !isAccelerationChanged())
        {
            shakeInitiated=false;

        }
    }

    private void executeShakeAction()
    {

        Toast.makeText(this,"SHAKE DETECTED",Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,AccelerometerActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
    

    private void updateAccParameters(float xNewAcc,float yNewAcc,float zNewAcc)
    {
        if(firstUpdate)
        {
            xPrevAcc=xNewAcc;
            yPrevAcc=yNewAcc;
            zPrevAcc=zNewAcc;
            firstUpdate=false;
        }
        else
        {
            xPrevAcc=xAcc;
            yPrevAcc=yAcc;
            zPrevAcc=zAcc;

        }

        xAcc=xNewAcc;
        yAcc=yNewAcc;
        zAcc=zNewAcc;


    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private boolean isAccelerationChanged() {
        float deltax=Math.abs(xPrevAcc-xAcc);
        float deltay=Math.abs(yPrevAcc-yAcc);
        float deltaz=Math.abs(zPrevAcc-zAcc);

        return (deltax>shakeThreshold && deltay>shakeThreshold)
                ||(deltax>shakeThreshold && deltaz>shakeThreshold)||(deltaz>shakeThreshold && deltay>shakeThreshold);
    }
}
