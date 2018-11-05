package com.example.megha.quizapp_a3_mt18100;

public class Questions
{

    private String ques;
    private String ans;

    public Questions()
    {}

    public Questions(String ques,String ans) {
        this.ques = ques;
        this.ans=ans;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    }
