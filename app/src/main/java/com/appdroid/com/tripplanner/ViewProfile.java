package com.appdroid.com.tripplanner;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link android.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ViewProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewProfile extends android.support.v4.app.Fragment {
    public static android.support.v4.app.Fragment newInstance(Context context) {
        ViewProfile fr = new ViewProfile();
        return fr;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_view_profile, null);
       /* final EditText etUsername=(EditText)root.findViewById(R.id.etUsername);
        final EditText etPassword=(EditText)root.findViewById(R.id.etPassword);
        Button btnLogin=(Button)root.findViewById(R.id.btnLogin);
        Button btnSearch=(Button)root.findViewById(R.id.btnSearch);
        TextView tvRegister=(TextView)root.findViewById(R.id.tvRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Toast.makeText(getActivity(), "Success2", Toast.LENGTH_SHORT).show();

                if(etUsername.getText().toString().equals(etPassword.getText().toString()))
                    Toast.makeText(getActivity(),"Success",Toast.LENGTH_SHORT).show();
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, android.support.v4.app.Fragment.instantiate(getActivity(), "com.appdroid.com.tripplanner.SearchResults"))
                        .commit();
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               *//* FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container,Fragment.instantiate(getActivity(),"com.appdroid.com.tripplanner.DetailedResult"))
                        .commit();*//*
                Intent in=new Intent(getActivity(),PlaceDetails.class);
                startActivity(in);
            }
        });*/

        return root;
    }
}
