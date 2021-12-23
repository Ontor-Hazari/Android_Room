package com.example.androidroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class cartdata extends AppCompatActivity {


    RecyclerView recview;
    TextView rateview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartdata);

        setContentView(R.layout.activity_cartdata);
        getSupportActionBar().hide();

        recview = (RecyclerView) findViewById(R.id.recview);
        rateview = (TextView) findViewById(R.id.rateview);

        getroomData();

    }

    private void getroomData() {

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"cart_db").allowMainThreadQueries().build();

        ProductDao productDao = db.ProductDao();

        List<Product> products = productDao.getallproduct();

        recview.setLayoutManager(new LinearLayoutManager(this));

        myadapter adapter = new myadapter(products,rateview);

        recview.setAdapter(adapter);

        int sum=0,i;
        for(i=0;i< products.size();i++)
            sum=sum+(products.get(i).getPrice()*products.get(i).getQnt());

        rateview.setText("Total Amount : INR "+sum);

    }
}