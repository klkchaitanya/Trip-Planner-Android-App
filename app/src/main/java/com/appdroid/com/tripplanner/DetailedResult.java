package com.appdroid.com.tripplanner;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DetailedResult extends Fragment {
    public static android.support.v4.app.Fragment newInstance(Context context) {
        DetailedResult fr = new DetailedResult();
        return fr;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_detailed_result, null);


        return root;
    }

}
