package com.example.kababjipalace.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.kababjipalace.Domain.RecommendedDomain;
import com.example.kababjipalace.Helper.ManageCart;
import com.example.kababjipalace.R;

public class ShowDetailsActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private LinearLayout addToCart;
    private TextView titleTxt,feeTxt,descTxt,numOfTxt,totalPriceTxt,starTxt,caloryTxt,timeTxt;
    private ImageView plusBtn,minusBtn,picFood;
    private RecommendedDomain obj;
    private int numOrder=1;
    private ManageCart manageCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        manageCart=new ManageCart(this);
        initView();
        getbundle();
//        movingFromShowToCart();
    }

    private void getbundle() {
        obj=(RecommendedDomain)getIntent().getSerializableExtra("object");

        int drawable=this.getResources().getIdentifier(obj.getPic(),"drawable",this.getPackageName());
        Glide.with(this).load(drawable).into(picFood);
        titleTxt.setText(obj.getTitle());
        //feeTxt.setText("pound"+obj.getFee());
        descTxt.setText(obj.getDesc());
        numOfTxt.setText(String.valueOf(numOfTxt));
        caloryTxt.setText(obj.getCalories()+"Calories");
        starTxt.setText(obj.getStar()+"");
        timeTxt.setText(obj.getTime()+" minutes");
        totalPriceTxt.setText("pounds"+numOrder*obj.getFee());
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               numOrder=numOrder+1 ;
               numOfTxt.setText(String.valueOf(numOrder));
                totalPriceTxt.setText("pounds"+numOrder*obj.getFee());
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numOrder>1){
                    numOrder=numOrder-1;

                }
                numOfTxt.setText(String.valueOf(numOrder));
                totalPriceTxt.setText("pounds"+numOrder*obj.getFee());

            }
        });
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj.setNumInCart(numOrder);
                manageCart.insertfood(obj);
//                Intent intent = new Intent(ShowDetailsActivity.this,CartActivity.class);
//                startActivity(intent);
            }
        });


    }

    private void initView() {
        addToCartBtn=findViewById(R.id.addToCartBtn);
        titleTxt=findViewById(R.id.titlee);
        //feeTxt=findViewById(R.id.textView);
        descTxt=findViewById(R.id.textView7);
        numOfTxt=findViewById(R.id.numText);
        plusBtn=findViewById(R.id.imageVie);
        minusBtn=findViewById(R.id.imageView6);
        picFood=findViewById(R.id.photo);
        totalPriceTxt=findViewById(R.id.textView9);
        starTxt=findViewById(R.id.textView4);
        caloryTxt=findViewById(R.id.textView6);
        timeTxt=findViewById(R.id.textView5);




    }

//    @SuppressLint("WrongViewCast")
//    private void movingFromShowToCart(){
//        addToCartBtn = findViewById(R.id.addToCartBtn);
//        addToCartBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(ShowDetailsActivity.this,CartActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
}