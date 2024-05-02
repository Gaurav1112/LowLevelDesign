package com.gaurav1112.DesignPattern.ObserverPattern.AmazonNotifyMe.Observerable;

import com.gaurav1112.DesignPattern.ObserverPattern.AmazonNotifyMe.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservable implements StockObservable{

    List<NotificationAlertObserver> objList = new ArrayList<>();
    int stockCount = 0;


    @Override
    public void add(NotificationAlertObserver obj) {
        objList.add(obj);
    }

    @Override
    public void remove(NotificationAlertObserver obj) {
        objList.remove(obj);
    }

    @Override
    public void notifySubscriber() {
        for(NotificationAlertObserver obs : objList){
            obs.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if (stockCount == 0)
            notifySubscriber();
        stockCount += newStockAdded;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
