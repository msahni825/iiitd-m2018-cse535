package com.example.megha.quizapp_a3_mt18100;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.megha.quizapp_a3_mt18100.DetailsActivity;
import com.example.megha.quizapp_a3_mt18100.Find_Position;
import com.example.megha.quizapp_a3_mt18100.R;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ListViewHolder> implements View.OnClickListener
{

    String[] label;
    public static int pos;
    public static Find_Position p1;
    Context context;
    int j;


    public MyListAdapter(String[] label, Context context)
    {
        this.label=label;
        this.context=context;
    }

    @Override
    public void onClick(View v) {

    }


    public class ListViewHolder extends RecyclerView.ViewHolder
    {
        TextView ques;

        public ListViewHolder(View itemView)
        {
            super(itemView);
            ques=(TextView)itemView.findViewById(R.id.itemText1);

        }
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_list,null);
        return new ListViewHolder(view);

    }

    public void onBindViewHolder(ListViewHolder viewHolder, int i)
    {

        final String q1=label[i];
        viewHolder.ques.setText(q1);
        viewHolder.ques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //j=viewHolder.ques.getAdapterPosition();
                //pos=p1.getPos();
                Intent intent=new Intent(context,DetailsActivity.class);
                context.startActivity(intent);

//                p1=new Find_Position();
//                p1.setPos(MyListAdapter.p1.getPos(i));


            }
        });


    }


    @Override
    public int getItemCount() {
        return label.length;
    }


//    public int getAdapterPosition() {
//        return adapterPosition;
//    }

//    @Override
//    public void onClick(View v) {
//
//        pos=p1.getAdapterPosition();
//
//    }


}
