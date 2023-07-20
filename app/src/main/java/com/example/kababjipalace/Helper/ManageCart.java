package com.example.kababjipalace.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.kababjipalace.Domain.RecommendedDomain;
import com.example.kababjipalace.Interface.ChangeNumberItem;

import java.util.ArrayList;

public class ManageCart {
    private Context context;
    private TinyDB tinyDB;

    public ManageCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
    public void insertfood(RecommendedDomain item){
        ArrayList<RecommendedDomain> listfood=getListCart();
        boolean exist=false;
        int x=0;
        for(int i=0;i < listfood.size();i++){
            if(listfood.get(i).getTitle().equals(item.getTitle())){
                exist=true;
                x=i;
                break;
            }
        }
        if(exist){
            listfood.get(x).setNumInCart(item.getNumInCart());
        }
        else{
            listfood.add(item);
        }
        tinyDB.putListObject("Cardlist",listfood);
        Toast.makeText(context, "Added Succesfully to your cart ", Toast.LENGTH_SHORT).show();

    }

    public ArrayList<RecommendedDomain> getListCart() {
        return tinyDB.getListObject("cardlist");
    }
public void plusNmuber(ArrayList<RecommendedDomain>listfood, int pos, ChangeNumberItem changeNumberItem){
        if(listfood.get(pos).getNumInCart()==1){
            listfood.remove(pos);
        }
        else {
            listfood.get(pos).setNumInCart(listfood.get(pos).getNumInCart()+1);
        }
        tinyDB.putObject("cardlist",listfood);
        changeNumberItem.changed();
}
    public void minusNmuber(ArrayList<RecommendedDomain>listfood, int pos, ChangeNumberItem changeNumberItem){
            listfood.get(pos).setNumInCart(listfood.get(pos).getNumInCart()-1);
            tinyDB.putObject("cardlist",listfood);
            changeNumberItem.changed();
    }
    public double getTotalFee(){
        ArrayList<RecommendedDomain> listfood=getListCart();
        double fee=0;
        for(int i=0;i<listfood.size();i++){
            fee=fee+(listfood.get(i).getFee()*listfood.get(i).getNumInCart());
        }
        return fee;
    }

}
