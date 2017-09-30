package com.sample.anindya.bottomsheetdesign;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Permission extends Fragment {

    //Defining Variables
    FloatingActionButton fab;
    Handler handler;

    public static Permission newInstance() {
        Permission fragment = new Permission();
        fragment.setRetainInstance(true);
        return fragment;
    }


    public Permission() {
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
        return inflater.inflate(R.layout.permission, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //view initialize and functionality declare

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something
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
