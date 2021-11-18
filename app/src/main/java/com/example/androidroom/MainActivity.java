package com.example.androidroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText first_name,name2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        first_name  = findViewById(R.id.first_name);
        name2 = findViewById(R.id.name2);
        button = findViewById(R.id.button);


        button.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        new bgThred().start();
        Toast.makeText(MainActivity.this,"Insert Succsessfully",Toast.LENGTH_SHORT).show();

    }

    class  bgThred extends  Thread{
          public void  run()
          {
              super.run();

              AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                      AppDatabase.class, "room_db").build();

              UserDao userDao = db.userDao();

              userDao.insertrecord(new User(1,first_name.getText().toString(),name2.getText().toString()));






          }
    }
}