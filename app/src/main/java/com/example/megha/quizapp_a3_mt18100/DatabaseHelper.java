package com.example.megha.quizapp_a3_mt18100;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.megha.quizapp_a3_mt18100.QuizContainer.*;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "QuizDatabase.db";
    public static final int DATABASE_VERSION = 2;
    private SQLiteDatabase db;

    public DatabaseHelper(Context context)
    {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUES_TABLE = "CREATE TABLE " +
                QuesTable.TABLE_NAME + " ( " +
                QuesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                QuesTable.COL_QUES + " TEXT, " +
                QuesTable.COL_ANS + " TEXT " + ")";

        this.db.execSQL(SQL_CREATE_QUES_TABLE);
        addQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuesTable.TABLE_NAME);
        onCreate(db);

    }

    public void addQuestionsTable() {

        Questions q1 = new Questions("The Language that the computer can understand is called Machine Language","True");
        addQuestion(q1);
        Questions q2 = new Questions("Magnetic Tape used random access method","False");
        addQuestion(q2);
        Questions q3 = new Questions("Twitter is an online social networking and blogging service","True");
        addQuestion(q3);
        Questions q4 = new Questions("Worms and trojan horses are easily detected and eliminated by antivirus software","True");
        addQuestion(q4);
        Questions q5 = new Questions("Dot-matrix, Deskjet, Inkjet and Laser are all types of Printer","True");
        addQuestion(q5);
        Questions q6 = new Questions("GNU / Linux is a open source operating system","False");
        addQuestion(q6);
        Questions q7 = new Questions("IPv6 Internet Protocol address is represented as eight groups of four Octal digits","True");
        addQuestion(q7);
        Questions q8 = new Questions("The hexadecimal number system contains digits from 1 - 15"," False");
        addQuestion(q8);
        Questions q9 = new Questions("Octal number system contains digits from 0 - 7","True");
        addQuestion(q9);
        Questions q10 = new Questions("MS Word is a hardware","False");
        addQuestion(q10);
        Questions q11 = new Questions("CPU stands for Central Performance Unit","False");
        addQuestion(q11);
        Questions q12 = new Questions("You cannot format text in an e-mail message","True");
        addQuestion(q12);
        Questions q13 = new Questions("You must include a subject in any mail message you compose","False");
        addQuestion(q13);
        Questions q14 = new Questions("If you want to respond to the sender of a message, click the Respond button","True");
        addQuestion(q14);
        Questions q15 = new Questions("When you reply to a message, you need to enter the text in the Subject","True");
        addQuestion(q15);
        Questions q16 = new Questions("You can only print one copy of a selected message","False");
        addQuestion(q16);
        Questions q17 = new Questions("CPU controls only input data of computer","True");
        addQuestion(q17);
        Questions q18 = new Questions("You cannot preview a message before you print it","True");
        addQuestion(q18);
        Questions q19 = new Questions("There is only one way to print a message","False");
        addQuestion(q19);
        Questions q20 = new Questions("When you print a message, it is automatically deleted from your Inbox.","False");
        addQuestion(q20);
        Questions q21 = new Questions("You cannot edit Contact forms.","True");
        addQuestion(q21);
        Questions q22 = new Questions("All attachment are safe","True");
        addQuestion(q22);
        Questions q23 = new Questions("There is only one way to delete a message","True");
        addQuestion(q23);
        Questions q24 = new Questions("In Outlook, you must store all of your messages in the Inbox","");
        addQuestion(q24);
        Questions q25 = new Questions("New folders must all be at the same level","True");
        addQuestion(q25);
        Questions q26 = new Questions("You cannot send a file from a Web-based e-mail account","False");
        addQuestion(q26);
        Questions q27 = new Questions("Your e-mail address must be unique","True");
        addQuestion(q27);
        Questions q28 = new Questions("Web-based e-mail accounts do not required passwords","False");
        addQuestion(q28);
        Questions q29 = new Questions("You can delete e-mails from a Web-based e-mail account","True");
        addQuestion(q29);
        Questions q30 = new Questions("u can store Web-based e-mail messages in online folders","True");
        addQuestion(q30);

    }

    private void addQuestion(Questions questions)
    {

        ContentValues cv = new ContentValues();
        cv.put(QuesTable.COL_QUES, questions.getQues());
        cv.put(QuesTable.COL_ANS,questions.getAns());
        db.insert(QuesTable.TABLE_NAME, null, cv);

    }

    public List<Questions> getAllQuestions()
    {
        List<Questions> questionsList=new ArrayList<>();
        db=getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+QuizContainer.QuesTable.TABLE_NAME,null);

        if(c.moveToFirst())
        {

            do
            {
                Questions questions=new Questions();
                questions.setQues(c.getString(c.getColumnIndex(QuesTable.COL_QUES)));
                questions.setAns(c.getString(c.getColumnIndex(QuesTable.COL_ANS)));
                questionsList.add(questions);

            }while (c.moveToNext());

        }
        c.close();
        return questionsList;

    }

}
