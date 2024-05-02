package com.gaurav1112.DesignPattern.VendingMachine;

import java.util.List;

public class HasMoney implements State{

    public HasMoney(){
        System.out.println("Currently Vending Machine is in HasMoney State");
    }


    @Override
    public void clickOnInsertCoinButton(VendingMachine mac) throws Exception {

    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine mac) throws Exception {
        mac.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine mac, Coin coin) throws Exception {
        System.out.println("Accepted the coin : " + coin.value);
        mac.getCoinList().add(coin);
    }

    @Override
    public void chooseProduct(VendingMachine mac, int codeNumber) throws Exception {
        throw new Exception("Choose Product in the Selection State");
    }

    @Override
    public void getChange(int returnChangeMoney) throws Exception {
        System.out.println("You cannot get change in the HasMoney State");
    }

    @Override
    public Item dispenseProduct(VendingMachine mac, int codeNumber) throws Exception {
        throw new Exception("Product cant be dispatched in the Dispense Product State");
    }

    @Override
    public List<Coin> fullRefund(VendingMachine mac) throws Exception {
        System.out.println("Returned the full amount back in the coin dispense tray");
        mac.setVendingMachineState(new IdleState(mac));
        return mac.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine mac, Item item, int codeNumber) throws Exception {
        throw new Exception ("You cannot update the inventory in the HasMoney State");
    }
}
