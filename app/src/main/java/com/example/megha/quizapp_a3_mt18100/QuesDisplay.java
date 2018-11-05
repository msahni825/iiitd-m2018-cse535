package com.example.megha.quizapp_a3_mt18100;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class QuesDisplay extends Fragment {

    MyListAdapter myListAdapter;
    Find_Position find_position;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    TextView ques_text1,ques_text2;
    int position =0;
    //CharSequence ques_text;
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View myView = inflater.inflate(R.layout.fragment_ques_display, container, false);
        ques_text1 =(TextView)myView.findViewById(R.id.ques_txt);
        //ques_text1.setText("Magnetic Tape used random access method");
        ques_text1.setText("GNU / Linux is a open source operating system");
        DatabaseHelper db=new DatabaseHelper(getContext());
        SQLiteDatabase sqliteDatabase=db.getReadableDatabase();

        Log.d("HI","qwerty");
//         position= MyListAdapter.pos+1;
//         find_position.setPos(position);
//         position=find_position.getPos();

        Cursor c= sqliteDatabase.rawQuery("SELECT * FROM "+ QuizContainer.QuesTable.TABLE_NAME + " where _id = " +position,null);
        if(c.getCount()>0)
        {
            c.moveToFirst();
            ques_text1.setText(c.getString(c.getColumnIndex(QuizContainer.QuesTable.COL_QUES)));

        }
         return myView;
    }
}
