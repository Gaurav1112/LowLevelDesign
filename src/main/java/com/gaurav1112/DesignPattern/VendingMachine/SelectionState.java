package com.gaurav1112.DesignPattern.VendingMachine;

import java.util.List;

public class SelectionState implements State{

    public SelectionState(){
        System.out.println("Currently in the Selection State");
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine mac) throws Exception {
        throw new Exception("cannot insert coin in the Selection State");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine mac) throws Exception {
        throw new Exception("Cannot select on Choose Product button in the Selection State");
    }

    @Override
    public void insertCoin(VendingMachine mac, Coin coin) throws Exception {
        throw new Exception("Cannot insert coin in the Selection State");
    }

    @Override
    public void chooseProduct(VendingMachine mac, int codeNumber) throws Exception {

        Item item = mac.getInventory().getItem(codeNumber);
        int paidByUser = 0;
        for (Coin coin: mac.getCoinList()){
            paidByUser = paidByUser + coin.value;
        }
        if(paidByUser < item.getPrice()) {
            System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + paidByUser);
            fullRefund(mac);
            throw new Exception("insufficient amount");
        }
        else if(paidByUser >= item.getPrice()) {

            if (paidByUser > item.getPrice()) {
                getChange(paidByUser - item.getPrice());
            }
            mac.setVendingMachineState(new DispenseProduct(mac, codeNumber));
        }
    }

    @Override
    public void getChange(int returnChangeMoney) throws Exception {

    }

    @Override
    public Item dispenseProduct(VendingMachine mac, int codeNumber) throws Exception {
        return null;
    }

    @Override
    public List<Coin> fullRefund(VendingMachine mac) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        mac.setVendingMachineState(new IdleState(mac));
        return mac.getCoinList();

    }

    @Override
    public void updateInventory(VendingMachine mac, Item item, int codeNumber) throws Exception {

    }
}
