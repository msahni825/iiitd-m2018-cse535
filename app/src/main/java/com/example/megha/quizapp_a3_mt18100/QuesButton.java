package com.example.megha.quizapp_a3_mt18100;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;


public class QuesButton extends Fragment implements View.OnClickListener{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    Button save_ans;
    ContentValues values=new ContentValues();
    DatabaseHelper db;
    SQLiteDatabase sqliteDatabase;
    View myView;
    Boolean answered;
    RadioGroup rbGroup;
    RadioButton rb_true,rb_false,rbSelected;
    int answer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       myView = inflater.inflate(R.layout.fragment_ques_button, container, false);
       Button save_ans=(Button)myView.findViewById(R.id.save_ans);
       rbGroup=(RadioGroup)myView.findViewById(R.id.radio);
       rb_true=(RadioButton)myView.findViewById(R.id.radio_true);
       rb_false=(RadioButton)myView.findViewById(R.id.radio_false);
       rb_false.setText("FALSE");
       rb_true.setText("TRUE");
       save_ans.setOnClickListener(this);
        return myView;
    }

//    public void uploadAnswer()
//    {
//        answered=true;
//        rbSelected=myView.findViewById(rbGroup.getCheckedRadioButtonId());
//        answer=rbGroup.indexOfChild(rbSelected)+1;
//        //
//    }

    @Override
    public void onClick(View v) {
        db=new DatabaseHelper(getContext());
        sqliteDatabase=db.getReadableDatabase();
        Toast.makeText(this.getContext(),"DATA ADDED SUCCESSFULLY",Toast.LENGTH_SHORT).show();

    if(rb_true.isChecked())
    {
        values.put(QuizContainer.QuesTable.COL_ANS,true);
        long newRowId=sqliteDatabase.update(QuizContainer.QuesTable.TABLE_NAME,values,"_id = ?",new String[]{QuizContainer.QuesTable._ID});
    }

    if( rb_false.isChecked())
    {
        values.put(QuizContainer.QuesTable.COL_ANS,false);
        long newRowId=sqliteDatabase.update(QuizContainer.QuesTable.TABLE_NAME,values,"_id = ?",new String[]{QuizContainer.QuesTable._ID});
    }

 }

//    @Override
//    public void onClick(View v)
//    {
//        int position=MyListAdapter.p1.getPos();
//        position=position+1;
//
//        Cursor c= sqliteDatabase.rawQuery("SELECT * FROM "+ QuizContainer.QuesTable.TABLE_NAME + " where _id = " +position,null);
//        c.moveToFirst();
//
//        values.put("ANS_KEY",c.getString(c.getColumnIndex("COL_QUES")));
//
//        //CSV CODE
//
//    }
}
