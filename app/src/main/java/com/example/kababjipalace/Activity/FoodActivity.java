package com.example.kababjipalace.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kababjipalace.Adapter.CategoryAdapter;
import com.example.kababjipalace.Adapter.RecommendedAdapter;
import com.example.kababjipalace.Domain.CategoryDomain;
import com.example.kababjipalace.Domain.RecommendedDomain;
import com.example.kababjipalace.R;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter1,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewRecomendedList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        recyclerViewCategoryList();
        recyclerViewRecomendedList();
        bottonNavigation();
    }
    private void bottonNavigation() {
        LinearLayout home=findViewById(R.id.homeBtn);
        LinearLayout profile=findViewById(R.id.profile);
        LinearLayout cart=findViewById(R.id.cart);
        LinearLayout support=findViewById(R.id.support);
        LinearLayout setting=findViewById(R.id.setting_icon);


        cart.setOnClickListener(v -> {
            Intent intent1=new Intent(FoodActivity.this,CartActivity.class);
            startActivity(intent1);
        });
        setting.setOnClickListener(v -> {
            Intent intent2=new Intent(FoodActivity.this,SettingsActivity.class);
            startActivity(intent2);
        });
        profile.setOnClickListener(v -> {
            Intent intent3=new Intent(FoodActivity.this,ProfileActivity.class);
            startActivity(intent3);
        });
//        support.setOnClickListener(v ->{
//            Intent intent4=new Intent(FoodActivity.this,SupportActivity.class);
//            startActivity(intent4);
//        });

    }

    public void recyclerViewCategoryList(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList= findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);
        ArrayList<CategoryDomain> categoryDomains=new ArrayList<>();
        categoryDomains.add(new CategoryDomain("Pizza",""));
        categoryDomains.add(new CategoryDomain("Burger",""));
        categoryDomains.add(new CategoryDomain("Hotdog",""));
        categoryDomains.add(new CategoryDomain("Drink",""));
        categoryDomains.add(new CategoryDomain("Donut",""));
        categoryDomains.add(new CategoryDomain("Pizza",""));
        categoryDomains.add(new CategoryDomain("Burger",""));
        categoryDomains.add(new CategoryDomain("Hotdog",""));
        categoryDomains.add(new CategoryDomain("Drink",""));
        categoryDomains.add(new CategoryDomain("Donut",""));

        adapter1=new CategoryAdapter(categoryDomains);
        recyclerViewCategoryList.setAdapter(adapter1);
    }
    public void recyclerViewRecomendedList(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewRecomendedList= findViewById(R.id.view2);
        recyclerViewRecomendedList.setLayoutManager(linearLayoutManager);
        ArrayList<RecommendedDomain> recommendedDomains=new ArrayList<>();
        recommendedDomains.add(new RecommendedDomain("Pizza","pizza1","slices pepperoni",60.5,4,7,900));
        recommendedDomains.add(new RecommendedDomain("Burger","pizza3","slices",40.5,5,12,9800));
        recommendedDomains.add(new RecommendedDomain("Hotdog","cat_3"," pepperoni",50.9,2,2,90));
        recommendedDomains.add(new RecommendedDomain("Checken","pizza1","cheecken with potatoes",128.1,4,10,1900));
        recommendedDomains.add(new RecommendedDomain("Meet","pizza3","meet with rice",200.15,3,6,100));
        recommendedDomains.add(new RecommendedDomain("Pizza","pizza1","slices pepperoni",60.5,4,7,900));
        recommendedDomains.add(new RecommendedDomain("Burger","pizza3","slices",40.5,5,12,9800));
        recommendedDomains.add(new RecommendedDomain("Hotdog","cat_3"," pepperoni",30.9,2,2,90));
        recommendedDomains.add(new RecommendedDomain("Checken","pizza1","cheecken with potatoes",128.1,4,10,1900));
        recommendedDomains.add(new RecommendedDomain("Meet","pizza3","meet with rice",200.15,3,6,100));

        adapter2=new RecommendedAdapter(recommendedDomains);
        recyclerViewRecomendedList.setAdapter(adapter2);

    }



}

