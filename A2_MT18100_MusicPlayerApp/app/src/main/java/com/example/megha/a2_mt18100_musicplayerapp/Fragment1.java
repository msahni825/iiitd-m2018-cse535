package com.example.megha.a2_mt18100_musicplayerapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;


public class Fragment1 extends Fragment {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private Button start, stop;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment1, container, false);
        final Field fields[]=R.raw.class.getDeclaredFields();
        ListView listitems=(ListView) view.findViewById(R.id.list_v);
        ArrayList<String> musiclist=new ArrayList<String>();

        for(int i=0; i<fields.length;i++)
        {
            Field f=fields[i];
            String s=f.getName();
            musiclist.add(s);
        }

        ArrayAdapter<String> itemsAdapter=new
                ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,musiclist);
        listitems.setAdapter(itemsAdapter);


        listitems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value=(String)parent.getItemAtPosition(position);

                Intent intent=new Intent(getActivity(),My_Service.class);
                Bundle bundle=new Bundle();
                bundle.putString("song_key",value);
                intent.putExtras(bundle);
                getActivity().startService(intent);

                //Toast.makeText(this,fields[position],Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


}
