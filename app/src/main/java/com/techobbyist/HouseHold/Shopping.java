package com.techobbyist.HouseHold;

/**
 * Created by {OovuU} on 2017-12-03.
 */

public class Shopping {
    private String item;
    private int quantity;


    public Shopping(String item){
        this.item=item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
