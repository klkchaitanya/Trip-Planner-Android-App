package com.appdroid.com.tripplanner;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {
    public static android.support.v4.app.Fragment newInstance(Context context) {
        Home fr = new Home();
        return fr;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_home, null);
        final EditText etUsername=(EditText)root.findViewById(R.id.etUsername);
        final EditText etPassword=(EditText)root.findViewById(R.id.etPassword);
        final Button btnLogin=(Button)root.findViewById(R.id.btnLogin);
        final EditText etSearch = (EditText)root.findViewById(R.id.etSearch);
        final TextView tvWelcome = (TextView)root.findViewById(R.id.tvWelcome);
        final TextView tvUser = (TextView)root.findViewById(R.id.tvUser);

        Button btnSearch=(Button)root.findViewById(R.id.btnSearch);
        final TextView tvRegister=(TextView)root.findViewById(R.id.tvRegister);
        tvWelcome.setVisibility(View.INVISIBLE);
        tvUser.setVisibility(View.INVISIBLE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                //Toast.makeText(getActivity(),"Success2",Toast.LENGTH_SHORT).show();

                //Retrieve and check whether valid user or not
                if(etUsername.getText().toString().equals(etPassword.getText().toString())) {

                    etUsername.setVisibility(View.INVISIBLE);
                    etPassword.setVisibility(View.INVISIBLE);
                    btnLogin.setVisibility(View.INVISIBLE);
                    tvRegister.setVisibility(View.INVISIBLE);
                    displayUser(tvWelcome,tvUser,"UserDB");
                    Toast.makeText(getActivity(), "Logged in Successfully", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(getActivity(), "Invalid Details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, Fragment.instantiate(getActivity(), "com.appdroid.com.tripplanner.SearchResults"))
                        .commit();*/


                Geocoder coder = new Geocoder(getActivity());
                List<Address> address;

                try {
                    address = coder.getFromLocationName(etSearch.getText().toString(), 5);
                    if (address == null) {
                        Toast.makeText(getActivity(), "NULL", Toast.LENGTH_SHORT).show();
                    }
                    Address location = address.get(0);
                    String lat = String.valueOf(location.getLatitude());
                    String lon = String.valueOf(location.getLongitude());
                    Toast.makeText(getActivity(),lat+" "+lon,Toast.LENGTH_SHORT).show();


                    Intent in=new Intent(getActivity(),MapsActivity.class);
                    in.putExtra("Latitude",lat);
                    in.putExtra("Longitude",lon);
                    startActivity(in);


                }
                catch (Exception e)
                {
                    Toast.makeText(getActivity(),e.toString(),Toast.LENGTH_SHORT).show();
                }

            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, Fragment.instantiate(getActivity(), "com.appdroid.com.tripplanner.Register"))
                        .commit();

            }
        });

        return root;
    }

    public void displayUser(TextView v1,TextView v2, String s)
    {
        v1.setVisibility(View.VISIBLE);
        v1.setText("Welcome");

        v2.setVisibility(View.VISIBLE);
        v2.setText(s);

    }
}
