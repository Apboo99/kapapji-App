package com.example.kababjipalace.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kababjipalace.Domain.CategoryDomain;
import com.example.kababjipalace.R;

import java.util.ArrayList;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<CategoryDomain>categoryDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
    holder.category_name.setText(categoryDomains.get(position).getTitle());
    String pic = "";
    switch (position){
        case 0:
        case 5: {
            pic="cat_1";
            break;
        }

        case 1:
        case 6:
        {
            pic="cat_2";
            break;
        }
        case 2:
        case 7:
        {
            pic="cat_3";
            break;
        }
        case 3:
        case 8:
        {
            pic="cat_4";
            break;
        }
        case 4:
        case 9:
        {
            pic="cat_5";
            break;
        }
    }

        int drId=holder.itemView.getContext().getResources()
                .getIdentifier(pic,"drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).
                load(drId).
                into(holder.category_pic);
    }


    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView category_pic;
        TextView category_name;
        ConstraintLayout main_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category_name=itemView.findViewById(R.id.cat_name);
            category_pic=itemView.findViewById(R.id.cat_pic);
            main_layout=itemView.findViewById(R.id.main_layout);

        }
    }
}
