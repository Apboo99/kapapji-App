package com.example.kababjipalace.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kababjipalace.Activity.ShowDetailsActivity;
import com.example.kababjipalace.Domain.RecommendedDomain;
import com.example.kababjipalace.R;

import java.util.ArrayList;


public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {
    ArrayList<RecommendedDomain>RecommendedDomains;

    public RecommendedAdapter(ArrayList<RecommendedDomain> RecommendedDomains) {
        this.RecommendedDomains = RecommendedDomains;
    }

    //represent an item.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_recommended,parent,false);
        return new ViewHolder(inflate);

    }

    //display the data at the specified position. This method should update the contents of the RecyclerView
    @Override
    public void onBindViewHolder(@NonNull RecommendedAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
    holder.category_name.setText(RecommendedDomains.get(position).getTitle());
    holder.cost.setText(String.valueOf(RecommendedDomains.get(position).getFee()));


        int drId=holder.itemView.getContext().getResources()
                .getIdentifier(RecommendedDomains.get(position).getPic(),"drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).
                load(drId)
                .into(holder.category_pic);

        holder.plus.setOnClickListener(v -> {
            Intent intent=new Intent(holder.itemView.getContext(), ShowDetailsActivity.class);
            intent.putExtra("object",RecommendedDomains.get(position));
            holder.itemView.getContext().startActivity(intent);
        });

    }


    @Override
    public int getItemCount() {
        return RecommendedDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView category_pic,plus;
        TextView category_name,cost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category_name=itemView.findViewById(R.id.txt1);
            category_pic=itemView.findViewById(R.id.img1);
            plus=itemView.findViewById(R.id.plus);
            cost=itemView.findViewById(R.id.cost);


        }
    }
}
