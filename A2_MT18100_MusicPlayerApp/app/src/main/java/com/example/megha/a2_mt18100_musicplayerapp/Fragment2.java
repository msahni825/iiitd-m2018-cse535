package com.example.megha.a2_mt18100_musicplayerapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;


public class Fragment2 extends Fragment  {

    ImageButton stop;
    ImageButton download;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        stop = (ImageButton) view.findViewById(R.id.buttonStop);
        download = (ImageButton) view.findViewById(R.id.buttonDownload);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == stop)
                    getActivity().stopService(new Intent(getActivity(), My_Service.class));

            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==download)
                    getActivity().startService(new Intent(getActivity(),Internet_Service.class));
            }
        });

        return view;
    }

}
