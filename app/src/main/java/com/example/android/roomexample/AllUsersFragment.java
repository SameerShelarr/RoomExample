package com.example.android.roomexample;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllUsersFragment extends Fragment {

    private TextView allUserTV;

    public AllUsersFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_all_users, container, false);

        allUserTV = rootView.findViewById(R.id.userListTV);
        List<User> userList = MainActivity.database.myDao().getAllUsers();

        String info = "";

        for (User user : userList){
            String id = String.valueOf(user.getId());
            String name = user.getName();
            String email = user.getEmail();

            info = info + "ID: " + id + "\n" + "Name: " + name + "\n" + "Email: " + email + "\n\n";
        }

        allUserTV.setText(info);

        return rootView;
    }
}
