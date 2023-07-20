package com.example.kababjipalace.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kababjipalace.Domain.RecommendedDomain;
import com.example.kababjipalace.Helper.ManageCart;
import com.example.kababjipalace.Interface.ChangeNumberItem;
import com.example.kababjipalace.R;

import java.util.ArrayList;


public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    private ManageCart manageCart;
    ChangeNumberItem changeNumberItem;
    ArrayList<RecommendedDomain>listFoodSelected;

    public CartListAdapter(ArrayList<RecommendedDomain> listFoodSelected, Context context,ChangeNumberItem changeNumberItem) {
        this.listFoodSelected = listFoodSelected;
        manageCart=new ManageCart(context);
        this.changeNumberItem=changeNumberItem;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholdercart,parent,false);
        return new ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull CartListAdapter.ViewHolder holder, int position) {
    holder.category_name.setText(listFoodSelected.get(position).getTitle());
    holder.fee.setText("pounds"+(listFoodSelected.get(position).getFee()));
    holder.total.setText("pounds"+Math.round(listFoodSelected.get(position).getNumInCart()+listFoodSelected.get(position).getFee()));
    holder.num.setText(String.valueOf(listFoodSelected.get(position).getNumInCart()));

        int drId=holder.itemView.getContext().getResources()
                .getIdentifier(listFoodSelected.get(position).getPic(),"drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drId).into(holder.category_pic);

        holder.plus.setOnClickListener(v -> manageCart.plusNmuber(listFoodSelected, position, () -> {
            notifyDataSetChanged();
            changeNumberItem.changed();
        }));
        holder.minus.setOnClickListener(v -> {
            manageCart.minusNmuber(listFoodSelected,position, () -> {
                notifyDataSetChanged();
                changeNumberItem.changed();
            });
        });
    }


    @Override
    public int getItemCount() {
        return listFoodSelected.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView category_pic,plus,minus;
        TextView category_name,fee;
        TextView total,num;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category_name=itemView.findViewById(R.id.txt1);
            category_pic=itemView.findViewById(R.id.img1);
            plus=itemView.findViewById(R.id.plus);
            fee=itemView.findViewById(R.id.cost);
            total=itemView.findViewById(R.id.totalTxt);
            plus=itemView.findViewById(R.id.pluss);
            minus=itemView.findViewById(R.id.minuss);
            num=itemView.findViewById(R.id.counternumber);


        }
    }
}
