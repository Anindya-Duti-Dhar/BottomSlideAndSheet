package com.sample.anindya.bottomsheetdesign;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mancj.slideup.SlideUp;


public class PhotoUploadFragment extends Fragment {

    //Defining Variables
    Handler handler;
    FloatingActionButton fab;

    public static PhotoUploadFragment newInstance() {
        PhotoUploadFragment fragment = new PhotoUploadFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }


    public PhotoUploadFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.photo_upload, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //view initialize and functionality declare

        // initialize handler to hide and show fab button
        handler = new Handler();

        // fab button initialize
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.hide();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something after 200ms
                        fab.show();
                        //fab.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_action_clear));
                    }
                }, 200);
            }
        });

    }
}
