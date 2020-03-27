package com.example.android.roomexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button addUserButton;
    private Button viewUserButton;
    private Button deleteUserButton;
    private Button updateUserButton;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        addUserButton = rootView.findViewById(R.id.addUser);
        viewUserButton = rootView.findViewById(R.id.viewUser);
        deleteUserButton = rootView.findViewById(R.id.deleteUser);
        updateUserButton = rootView.findViewById(R.id.updateUser);

        addUserButton.setOnClickListener(this);
        viewUserButton.setOnClickListener(this);
        deleteUserButton.setOnClickListener(this);
        updateUserButton.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        int selection = v.getId();

        switch (selection){
            case R.id.addUser:
                assert getFragmentManager() != null;
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new AddUserFragment()).addToBackStack(null).commit();
                break;

            case R.id.viewUser:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new AllUsersFragment()).addToBackStack(null).commit();
                break;

            case R.id.deleteUser:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new DeleteUserFragment()).addToBackStack(null).commit();
                break;

            case R.id.updateUser:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new UpdateUserFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
