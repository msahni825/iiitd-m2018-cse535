package com.example.megha.a1_mt18100;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class UserInfoActivity_A1_MT18100 extends AppCompatActivity{

    TextView show_text,show_text1,show_text2,show_text3,show_text4,show_text5,show_text6;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_a1_mt18100);

        Intent intent=getIntent();

        show_text = (TextView)findViewById(R.id.text);
        show_text.setText("Name is: "+intent.getStringExtra("Name"));
        show_text1 = (TextView)findViewById(R.id.text1);
        show_text1.setText("Roll No is: "+intent.getStringExtra("Rollno"));
        show_text2= (TextView)findViewById(R.id.text2);
        show_text2.setText("Branch is: "+intent.getStringExtra("Branch"));
        show_text3 = (TextView)findViewById(R.id.text3);
        show_text3.setText("Course1 is: "+intent.getStringExtra("Course1"));
        show_text4= (TextView)findViewById(R.id.text4);
        show_text4.setText("Course2 is: "+intent.getStringExtra("Course2"));
        show_text5= (TextView)findViewById(R.id.text5);
        show_text5.setText("Course3 is: "+intent.getStringExtra("Course3"));
        show_text6 = (TextView)findViewById(R.id.text6);
        show_text6.setText("Course4 is: "+intent.getStringExtra("Course4"));
    }


}
