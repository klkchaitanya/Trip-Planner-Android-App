package com.appdroid.com.tripplanner;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link History#newInstance} factory method to
 * create an instance of this fragment.
 */
public class History extends Fragment {
    public static android.support.v4.app.Fragment newInstance(Context context) {
        History fr = new History();
        return fr;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_history, null);
        String [] prgmNameList={"History1","History2","History3","History4","History5","History6","History7","History8"};
        ListView lv=(ListView)root.findViewById(R.id.listView_history);
        lv.setAdapter(new CustomAdapterForHistory(this,prgmNameList));
        return root;
    }
}
