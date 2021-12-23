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


    EditText pid,pname,pprice,pqtn;
    Button button,button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pid = (EditText) findViewById(R.id.pid);
        pname = (EditText) findViewById(R.id.pname);
        pprice = (EditText) findViewById(R.id.pprice);
        pqtn = (EditText) findViewById(R.id.pqtn);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);



        button.setOnClickListener(this);
        button2.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

       if(v.getId()==R.id.button)
       {


              String name;
              int id,price,qtn;
              id = Integer.parseInt(pid.getText().toString());
              name = pname.getText().toString();
              price =Integer.parseInt(pprice.getText().toString());
              qtn = Integer.parseInt(pqtn.getText().toString());

              AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"cart_db").allowMainThreadQueries().build();

              ProductDao productDao = db.ProductDao();

              Boolean check = productDao.is_exist(id);

              if(check == false)
              {
                  productDao.insertrecord(new Product(id,name,price,qtn));

                  pid.setText("");
                  pname.setText("");
                  pprice.setText("");
                  pqtn.setText("");

                  Toast.makeText(MainActivity.this,"sucsessfully",Toast.LENGTH_LONG).show();
              }
              else
              {

                  pid.setText("");
                  pname.setText("");
                  pprice.setText("");
                  pqtn.setText("");

                  Toast.makeText(MainActivity.this,"product all ready in cart",Toast.LENGTH_LONG).show();
              }



       }
       else if(v.getId()==R.id.button2)
       {
           Intent intent = new Intent(MainActivity.this,cartdata.class);

           startActivity(intent);
       }

    }

}