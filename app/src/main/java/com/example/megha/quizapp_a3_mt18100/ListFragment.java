    package com.example.megha.quizapp_a3_mt18100;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.megha.quizapp_a3_mt18100.R;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListFragment extends Fragment {


    public List<Questions> questionsList;
    RecyclerView recyclerView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView=view.findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        String[] ques={"Question No 1","Question No 2","Question No 3",
                "Question No 4","Question No 5","Question No 6","Question No 7",
                "Question No 8","Question No 9","Question No 10","Question No 11",
                "Question No 12","Question No 13","Question No 14",
                "Question No 15","Question No 16","Question No 17","Question No 18",
                "Question No 19","Question No 20","Question No 21","Question No 22",
                "Question No 23","Question No 24","Question No 25","Question No 26",
                "Question No 27","Question No 28","Question No 29","Question No 30"};
        DatabaseHelper db = new DatabaseHelper(this.getContext());
        MyListAdapter la=new MyListAdapter(ques,this.getContext());
        recyclerView.setAdapter(la);
        questionsList= db.getAllQuestions();
        //Collections.shuffle(questionsList);
        return view;


    }
}
