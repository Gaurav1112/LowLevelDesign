package com.gaurav1112.DesignPattern.VendingMachine;

import java.util.List;

public interface State {
    public void clickOnInsertCoinButton(VendingMachine mac) throws Exception;
    public void clickOnStartProductSelectionButton(VendingMachine mac) throws Exception;
    public void insertCoin(VendingMachine mac, Coin coin) throws Exception;
    public void chooseProduct(VendingMachine mac, int codeNumber) throws Exception;
    public void getChange(int returnChangeMoney) throws Exception;
    public Item dispenseProduct(VendingMachine mac, int codeNumber) throws Exception;
    public List<Coin> fullRefund(VendingMachine mac) throws Exception;
    public void updateInventory(VendingMachine mac, Item item, int codeNumber) throws Exception;

}
