package com.gaurav1112.DesignPattern.VendingMachine;

public class Item {

    ItemType itemType;
    int price;



    public Item() {

    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
