package com.debin.retrofitmvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.debin.retrofitmvp.R;
import com.debin.retrofitmvp.model.Cake;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.MyViewHolder> {

    private ArrayList<Cake> cakeArrayList;

    public CakeAdapter(ArrayList<Cake> cakeArrayList) {
        this.cakeArrayList = cakeArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(cakeArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return cakeArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvTitle;
        TextView tvDes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_album);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDes = itemView.findViewById(R.id.tv_albumId);

        }

        public void bind(Cake cake){

            Picasso.get().load(cake.getImage()).into(imageView);
            tvTitle.setText(cake.getTitle());
            tvDes.setText(cake.getDesc());


        }
    }
}
