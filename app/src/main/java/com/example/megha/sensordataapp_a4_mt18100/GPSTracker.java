package com.example.megha.sensordataapp_a4_mt18100;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import java.security.acl.LastOwnerException;

public class GPSTracker implements LocationListener
{
    Context c;
    public  GPSTracker(Context context)

    {
     c = context;
     //Toast.makeText(c, "")
}

public Location getLocation()
{

    if(ContextCompat.checkSelfPermission(c, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
    {

        Toast.makeText(c,"Persmission not Granted",Toast.LENGTH_SHORT).show();
    }

    LocationManager lm=(LocationManager) c.getSystemService(c.LOCATION_SERVICE);
    boolean isGPSEnabled=lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
    if(isGPSEnabled) {
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 10, this);
        Location loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        return loc;
    }
    else
    {

        Toast.makeText(c,"Please enable GPS",Toast.LENGTH_SHORT).show();
    }
    return null;
 }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
