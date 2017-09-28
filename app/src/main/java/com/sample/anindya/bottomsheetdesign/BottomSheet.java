package com.sample.anindya.bottomsheetdesign;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class BottomSheet extends Fragment {

    //Defining Variables
    Handler handler;
    FloatingActionButton fab;
    boolean isSlideOpen = false;
    // BottomSheetBehavior variable
    RelativeLayout mBottomSheet;
    BottomSheetBehavior bottomSheetBehavior;

    String TAG = getClass().getName();


    public static BottomSheet newInstance() {
        BottomSheet fragment = new BottomSheet();
        fragment.setRetainInstance(true);
        return fragment;
    }


    public BottomSheet() {
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
        return inflater.inflate(R.layout.bottom_sheet_parent, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //view initialize and functionality declare


        mBottomSheet = (RelativeLayout)view.findViewById(R.id.bottomSheetLayout);
        bottomSheetBehavior = BottomSheetBehavior.from(view.findViewById(R.id.bottomSheetLayout));

        initSheet();

        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        // initialize handler to hide and show fab button
        handler = new Handler();

        // fab button initialize
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSlideOpen){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }
            }
        });

    }

    private void initSheet() {
        // Capturing the callbacks for bottom sheet
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {

                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    Log.d(TAG, "collapse me");
                    isSlideOpen = true;
                    fab.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_action_clear));
                } else {
                    Log.d(TAG, "expand me");
                }

                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }

                // Check Logs to see how bottom sheets behaves
                switch (newState) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        Log.d(TAG, "STATE_COLLAPSED");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        Log.d(TAG, "STATE_DRAGGING");
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        Log.d(TAG, "STATE_EXPANDED");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.d(TAG, "STATE_HIDDEN");
                        isSlideOpen = false;
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                        fab.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_action_add));
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        Log.d(TAG, "STATE_SETTLING");
                        break;
                }
            }


            @Override
            public void onSlide(View bottomSheet, float slideOffset) {

            }
        });

    }

}
