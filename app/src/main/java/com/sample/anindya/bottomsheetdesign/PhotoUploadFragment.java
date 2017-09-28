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
    private SlideUp slideUp;
    private View slideView;
    boolean isSlideOpen = false;
    int count = 0;

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

        // initialize slider
        slideView = view.findViewById(R.id.slideView);
        slideUp = new SlideUp(slideView);
        slideUp.hideImmediately();

        // initialize handler to hide and show fab button
        handler = new Handler();

        // fab button initialize
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSlideOpen){
                    slideUp.animateIn();
                }
                else {
                    slideUp.animateOut();
                }
            }
        });

        slideUp.setSlideListener(new SlideUp.SlideListener() {
            @Override
            public void onSlideDown(float v) {
                Log.d("v_xmpp: ", String.valueOf(v));
            }

            @Override
            public void onVisibilityChanged(int i) {
                Log.d("nn_xmpp: ", String.valueOf(i));
                if (i == View.GONE) {
                    if(isSlideOpen){
                        count = 0;
                        isSlideOpen = false;
                        fab.hide();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //Do something after 200ms
                                fab.show();
                                fab.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_action_add));
                            }
                        }, 100);
                    }
                }
                if (i == View.VISIBLE) {
                    count++;
                    if(count==1) {
                        isSlideOpen = true;
                        fab.hide();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //Do something after 200ms
                                fab.show();
                                fab.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_action_clear));
                            }
                        }, 200);
                    }
                }

            }
        });

    }
}
