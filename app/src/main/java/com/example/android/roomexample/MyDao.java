package com.example.android.roomexample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    void addUser(User user);

    @Query("select * from users")
    List<User> getAllUsers();

    @Delete
    void deleteUser(User user);

    @Update
    void updateUser(User user);
}
