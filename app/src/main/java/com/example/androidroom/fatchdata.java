package com.example.androidroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import java.util.List;

public class fatchdata extends AppCompatActivity {

    RecyclerView recycelerview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatchdata);

        recycelerview = findViewById(R.id.recycelerview);
        recycelerview.setLayoutManager(new LinearLayoutManager(this));

        getdata();


    }

    private void getdata() {












    }
}