package com.example.android.roomexample;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private EditText userIdET,userNameET,userEmailET;
    private Button saveUserButton;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_user, container, false);

        userIdET = rootView.findViewById(R.id.userIdET);
        userNameET = rootView.findViewById(R.id.userNameET);
        userEmailET = rootView.findViewById(R.id.userEmailET);
        saveUserButton = rootView.findViewById(R.id.saveButton);


        saveUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                user.setId(Integer.parseInt(userIdET.getText().toString()));
                user.setName(userNameET.getText().toString());
                user.setEmail(userEmailET.getText().toString());

                MainActivity.database.myDao().addUser(user);
                Toast.makeText(getContext(), "User saved", Toast.LENGTH_SHORT).show();
                clearAllFields();
            }
        });

        return rootView;
    }

    private void clearAllFields(){
        userIdET.setText("");
        userNameET.setText("");
        userEmailET.setText("");
    }
}
