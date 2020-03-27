package com.example.android.roomexample;

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
public class DeleteUserFragment extends Fragment {

    private EditText deleteUserIdET;
    private Button deleteUserButton;

    public DeleteUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_delete_user, container, false);

        deleteUserIdET = rootView.findViewById(R.id.userIdDeleteET);
        deleteUserButton = rootView.findViewById(R.id.deleteUserWithId);

        deleteUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(deleteUserIdET.getText().toString());
                User userToDelete = new User();
                userToDelete.setId(id);

                MainActivity.database.myDao().deleteUser(userToDelete);
                Toast.makeText(getContext(), "User deleted", Toast.LENGTH_SHORT).show();
                deleteUserIdET.setText("");
            }
        });

        return rootView;
    }
}
