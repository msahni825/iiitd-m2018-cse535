package com.example.megha.sensordataapp_a4_mt18100;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NearDetectionActivity extends AppCompatActivity {
    Button checkort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_detection);
        checkort=findViewById(R.id.buttonort);

        checkort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                {

                    Toast.makeText(getApplicationContext(),"Orientation is LANDSCAPE !",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Toast.makeText(getApplicationContext(),"Orientation is POTRAIT !",Toast.LENGTH_SHORT).show();

                }

                Toast.makeText(getApplicationContext(),"Orientation is POTRAIT !",Toast.LENGTH_LONG).show();

            }

        });


}
}
