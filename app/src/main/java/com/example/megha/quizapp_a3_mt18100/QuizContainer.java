package com.example.megha.quizapp_a3_mt18100;

import android.provider.BaseColumns;

public final class QuizContainer {


    public static class QuesTable implements BaseColumns
    {
        public static final String TABLE_NAME="quiz_app_questions";
        public static final String COL_QUES="question";
        public static final String COL_ANS="answer";

    }
}
