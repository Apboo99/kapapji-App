package com.example.kababjipalace.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kababjipalace.Adapter.CartListAdapter;
import com.example.kababjipalace.Helper.ManageCart;
import com.example.kababjipalace.Interface.ChangeNumberItem;
import com.example.kababjipalace.R;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private ManageCart manageCart;
    private TextView totalFeeTxt,deliveryTxt,totalTxt,emptyTxt,taxTxt;
    private double tax;
//    LinearLayout profile1=findViewById(R.id.profile);
    private ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        manageCart=new ManageCart(this);

                initView();
                calculateCard();
                initList();
                bottonNavigation();
    }
    private void bottonNavigation() {
        LinearLayout home=findViewById(R.id.homeBtn);
        LinearLayout cart1=findViewById(R.id.cart);
        LinearLayout support=findViewById(R.id.support);
        LinearLayout setting=findViewById(R.id.setting_icon);

        home.setOnClickListener(v -> {
            startActivity(new Intent(this,FoodActivity.class));
        });

        setting.setOnClickListener(v -> {
            startActivity(new Intent(this,SettingsActivity.class));
        });


    }

    private void initList() {
        LinearLayoutManager linearLayoutManager=
                new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter= new CartListAdapter(manageCart.getListCart(), this, new ChangeNumberItem() {
            @Override
            public void changed() {
                calculateCard();
            }
        });
        recyclerView.setAdapter(adapter);
        if(!manageCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
//        else if(manageCart.getListCart().isEmpty())
//        {
//            scrollView.setVisibility(View.GONE);
//            emptyTxt.setVisibility(View.VISIBLE);
//
//        }
    }

    private void calculateCard() {
        double percentTax=0.05;
        double delivery=45;
        tax=Math.round(manageCart.getTotalFee()*percentTax*100.0)/100.0;
        double total=Math.round(manageCart.getTotalFee()+tax+delivery)*100.0/100.0;
        double itemTotal=Math.round(manageCart.getTotalFee()*100.0)/100.0;
        totalFeeTxt.setText("pounds"+itemTotal);
        taxTxt.setText("pounds"+tax);
        deliveryTxt.setText("pounds"+delivery);
        totalTxt.setText("pounds"+total);



    }

    private void initView() {
        totalFeeTxt=findViewById(R.id.totalFeeTxt);
        deliveryTxt=findViewById(R.id.deliveryTxt);
        totalTxt=findViewById(R.id.totalTxt);
        taxTxt=findViewById(R.id.taxTxt);
        recyclerView=findViewById(R.id.view);
        scrollView=findViewById(R.id.scroll);
        emptyTxt=findViewById(R.id.emptyTxt);




    }
}