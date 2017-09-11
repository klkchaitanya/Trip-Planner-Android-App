package com.appdroid.com.tripplanner;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link Register#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Register extends Fragment {
    public static android.support.v4.app.Fragment newInstance(Context context) {
        Register fr = new Register();
        return fr;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_register, null);
        final EditText etName=(EditText)root.findViewById(R.id.etName);
        final EditText etUsername=(EditText)root.findViewById(R.id.etUsername);
        final EditText etPassword=(EditText)root.findViewById(R.id.etPassword);
        final EditText etConfirmPswd=(EditText)root.findViewById(R.id.etConfirmPswd);
        final EditText etEmail=(EditText)root.findViewById(R.id.etEmail);
        Button btnClearAll=(Button)root.findViewById(R.id.btnEditProfile);
        Button btnRegister=(Button)root.findViewById(R.id.btnRegister);

        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");etUsername.setText("");etPassword.setText("");
                etConfirmPswd.setText("");etEmail.setText("");
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(getActivity(),"Connect to server and insert data into database",Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}
