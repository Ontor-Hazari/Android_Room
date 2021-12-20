package com.example.androidroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText first_name,name2,serial_no;
    Button button,button2;
    TextView showData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        first_name  = findViewById(R.id.first_name);
        name2 = findViewById(R.id.name2);
        serial_no = findViewById(R.id.serial_no);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        showData = findViewById(R.id.showData);


        button.setOnClickListener(this);
        button2.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

       if(v.getId()==R.id.button)
       {
           AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"room_db").allowMainThreadQueries().build();

           UserDao userDao = db.userDao();
           Boolean check = userDao.is_exist(Integer.parseInt(serial_no.getText().toString()));

           if(check==false)
           {
               userDao.insertrecord(new User(Integer.parseInt(serial_no.getText().toString()),first_name.getText().toString(),name2.getText().toString()));
               first_name.setText("");
               name2.setText("");
               //  serial_no.setText("");
               Toast.makeText(MainActivity.this,"sucsess",Toast.LENGTH_SHORT).show();
           }
           else
           {
               first_name.setText("");
               name2.setText("");
               serial_no.setText("");
               Toast.makeText(MainActivity.this,"faiulre",Toast.LENGTH_SHORT).show();
           }

       }
       else if(v.getId()==R.id.button2)
       {
           Intent intent = new Intent(MainActivity.this,fatchdata.class);

           startActivity(intent);
       }

    }

}