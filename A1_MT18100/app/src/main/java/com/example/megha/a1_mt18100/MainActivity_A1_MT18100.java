package com.example.megha.a1_mt18100;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity_A1_MT18100 extends AppCompatActivity {

    Button submit,clear;
    private static final String TAG=MainActivity_A1_MT18100.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final EditText name, rollno, branch, course1, course2, course3, course4;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__a1__mt18100);
        name = (EditText) findViewById(R.id.editText);
        rollno = (EditText) findViewById(R.id.editText2);
        branch = (EditText) findViewById(R.id.editText3);
        course1 = (EditText) findViewById(R.id.editText4);
        course2 = (EditText) findViewById(R.id.editText5);
        course3 = (EditText) findViewById(R.id.editText6);
        course4 = (EditText) findViewById(R.id.editText1);

        //submit button
        submit = (Button) findViewById(R.id.button1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name_val = name.getText().toString();
                String roll_val = rollno.getText().toString();
                String branch_val = branch.getText().toString();
                String course1_val = course1.getText().toString();
                String course2_val = course2.getText().toString();
                String course3_val = course3.getText().toString();
                String course4_val = course4.getText().toString();

                if(name_val.trim().length()==0)

                {
                    name.setError("Name Required");
                }

                if(roll_val.trim().length()==0)

                {
                    rollno.setError("RollNo Required");
                }

                if(branch_val.trim().length()==0)

                {
                    branch.setError("Branch Required");
                }

               if(course1_val.trim().length()==0)

                {
                    course1.setError("Course valueRequired");
                }

               if(course2_val.trim().length()==0)

                {
                    course2.setError("Course valueRequired");
                }

                if(course3_val.trim().length()==0)

                {
                    course3.setError("Course valueRequired");
                }

                if(course4_val.trim().replaceAll(" ","").length()==0)

                {
                    course4.setError("Course valueRequired");
                }

                else {
                    Intent openUserInfoPage = new Intent(MainActivity_A1_MT18100.this, UserInfoActivity_A1_MT18100.class);
                    openUserInfoPage.putExtra("Name", name.getText().toString());
                    openUserInfoPage.putExtra("Rollno", rollno.getText().toString());
                    openUserInfoPage.putExtra("Branch", branch.getText().toString());
                    openUserInfoPage.putExtra("Course1", course1.getText().toString());
                    openUserInfoPage.putExtra("Course2", course2.getText().toString());
                    openUserInfoPage.putExtra("Course3", course3.getText().toString());
                    openUserInfoPage.putExtra("Course4", course4.getText().toString());

                    startActivity(openUserInfoPage);
                }


            }
        });
        //clear button
        clear = (Button) findViewById(R.id.button2);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name, rollno, branch, course1, course2, course3, course4;

                name = (EditText) findViewById(R.id.editText1);
                rollno = (EditText) findViewById(R.id.editText2);
                branch = (EditText) findViewById(R.id.editText3);
                course1 = (EditText) findViewById(R.id.editText4);
                course2 = (EditText) findViewById(R.id.editText5);
                course3 = (EditText) findViewById(R.id.editText6);
                course4 = (EditText) findViewById(R.id.editText);

                name.setText("");
                rollno.setText("");
                branch.setText("");
                course1.setText("");
                course2.setText("");
                course3.setText("");
                course4.setText("");

            }
        });

        Log.i(TAG, "Inside onCreate Method");
        Toast.makeText(getApplicationContext(),"FirstActivity Created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {

        super.onStart();
        Log.i(TAG, "FirstActivity: Created to Started");
        Toast.makeText(getApplicationContext(),"FirstActivity: Created to Started",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {

        super.onResume();
        Log.i(TAG, "FirstActivity:Started to Resumed");
        Toast.makeText(getApplicationContext(), "FirstActivity:Started to Resumed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.i(TAG, "FirstActivity:Resumed to Paused");
        Toast.makeText(getApplicationContext(),"FirstActivity:Resumed to Paused",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRestart() {
        super.onRestart();

        Log.i(TAG, "FirstActivity:Stopped to Restarted");
        Toast.makeText(getApplicationContext(),"FirstActivity:Stopped to Restarted",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onStop() {
        super.onStop();

        Log.i(TAG, "FirstActivity:Paused to Stopped");
        Toast.makeText(getApplicationContext(),"FirstActivity:Paused to Stopped",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroy() {

        super.onDestroy();
        Log.i(TAG, "FirstActivity:Stopped to Destroyed");
        Toast.makeText(getApplicationContext(), "FirstActivity:Stopped to Destroyed", Toast.LENGTH_SHORT).show();


    }


}
