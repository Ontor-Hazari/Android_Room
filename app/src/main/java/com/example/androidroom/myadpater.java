package com.example.androidroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

public class myadpater extends RecyclerView.Adapter<myadpater.viewHolder> {

    List<User> user;

    public myadpater(List<User> user) {
        this.user = user;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycelerdatalay,parent,false);
        return  new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {


        holder.t1.setText(String.valueOf(user.get(position).getUid()));
        holder.t2.setText(user.get(position).getFirstName());
        holder.t3.setText(user.get(position).getLastName());
        holder.deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppDatabase db = Room.databaseBuilder(holder.t1.getContext(),AppDatabase.class,"room_db").allowMainThreadQueries().build();

                UserDao userDao = db.userDao();

                userDao.deleteById(user.get(position).uid);

                user.remove(position);

                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        TextView t1,t2,t3;
        ImageView deletebutton;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            t1 = (TextView) itemView.findViewById(R.id.recid);
            t2 = (TextView) itemView.findViewById(R.id.recfirstname);
            t3 = (TextView) itemView.findViewById(R.id.reclastname);
            deletebutton = (ImageView) itemView.findViewById(R.id.deletebutton);

        }
    }
}
