package com.gaurav1112.DesignPattern.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State{

    public IdleState(){
        System.out.println("Currently Vending Machine is in idle State");
    }
    public IdleState(VendingMachine mac){
        System.out.println("Currently Vending Machine is in idle State");
        mac.setCoinList(new ArrayList<>());
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine mac) throws Exception {
        mac.setVendingMachineState(new HasMoney());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine mac) throws Exception {
        throw new Exception("First insert the coin");
    }

    @Override
    public void insertCoin(VendingMachine mac, Coin coin) throws Exception {
        throw new Exception("Invalid state to insert Coin");
    }

    @Override
    public void chooseProduct(VendingMachine mac, int codeNumber) throws Exception {
        throw new Exception("Invalid state to Select product");
    }

    @Override
    public void getChange(int returnChangeMoney) throws Exception {
        throw new Exception("Invalid state to return change");
    }

    @Override
    public Item dispenseProduct(VendingMachine mac, int codeNumber) throws Exception {
        throw new Exception("Invalid state to dispense product");
    }

    @Override
    public List<Coin> fullRefund(VendingMachine mac) throws Exception {
        throw new Exception("Cant Refund in this state");
    }

    @Override
    public void updateInventory(VendingMachine mac, Item item, int codeNumber) throws Exception {
        throw new Exception("Cannot update Inventory in this state");
    }
}
