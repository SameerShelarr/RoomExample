package com.example.android.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    public static FragmentManager fragmentManager;
    public static MyDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        if (findViewById(R.id.fragmentContainer) != null){
            if (savedInstanceState != null){
                return;
            }

            fragmentManager.beginTransaction().add(R.id.fragmentContainer,new HomeFragment()).commit();
        }

        database = Room.databaseBuilder(this,MyDatabase.class,"userdb").allowMainThreadQueries().build();
    }
}
