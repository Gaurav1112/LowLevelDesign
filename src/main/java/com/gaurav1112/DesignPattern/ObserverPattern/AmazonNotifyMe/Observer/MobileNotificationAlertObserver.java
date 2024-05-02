package com.gaurav1112.DesignPattern.ObserverPattern.AmazonNotifyMe.Observer;

import com.gaurav1112.DesignPattern.ObserverPattern.AmazonNotifyMe.Observerable.StockObservable;

public class MobileNotificationAlertObserver implements NotificationAlertObserver{

    StockObservable obj;

    String phoneModel;
    public MobileNotificationAlertObserver(StockObservable obj, String phoneModel){
        this.obj = obj;
        this.phoneModel = phoneModel;
    }
    @Override
    public void update() {
       // obj.setStockCount(obj.getStockCount()-1);
        System.out.println("Mobile Alert sent to: " + phoneModel);
    }
}
