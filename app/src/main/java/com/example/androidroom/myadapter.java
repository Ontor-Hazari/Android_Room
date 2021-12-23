package com.example.androidroom;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.ViewHolder> {

    List<Product> products;
    TextView rateview;

    public myadapter(List<Product> products, TextView rateview) {
        this.products = products;
        this.rateview = rateview;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vh = LayoutInflater.from(parent.getContext()).inflate(R.layout.productlist,parent,false);
        return new ViewHolder(vh);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.recid.setText(String.valueOf(products.get(position).getPid()));
        holder.recpname.setText(products.get(position).getPname());
        holder.recpprice.setText(String.valueOf(products.get(position).getPrice()));
        holder.recqnt.setText(String.valueOf(products.get(position).getQnt()));

        holder.delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppDatabase db = Room.databaseBuilder(holder.recid.getContext(),
                        AppDatabase.class, "cart_db").allowMainThreadQueries().build();
                ProductDao productDao = db.ProductDao();

                productDao.deleteById(products.get(position).getPid());

                products.remove(position);

                notifyDataSetChanged();

                updateprice();
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
               TextView recid,recpname,recqnt, recpprice;
              ImageButton delbtn;
                public ViewHolder(@NonNull View itemView) {
                    super(itemView);

                    recid=itemView.findViewById(R.id.recid);
                    recpname=itemView.findViewById(R.id.recpname);
                    recpprice=itemView.findViewById(R.id.recpprice);
                    recqnt=itemView.findViewById(R.id.recqnt);
                    delbtn=itemView.findViewById(R.id.delbtn);
                }
            }

    public void updateprice()
    {
      /*   int sum = 0,i ;

        for(i=0;i<=products.size();i++)
        {
            sum += products.get(i).getPrice()*products.get(i).getQnt();
            rateview.setText("Total Amount : INR "+sum);
        }*/

    }
}
