package com.example.androidroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;



@Dao public interface UserDao {

        @Insert
        void insertrecord(User... users);

        @Query("SELECT EXISTS(SELECT * FROM User WHERE uid = :UserId)")
        Boolean is_exist(int UserId);

        @Query("SELECT * FROM User")
    List<User> getAlluser();


        @Query("DELETE FROM User WHERE uid = :id")
            void deleteById(int id);

      


    }

