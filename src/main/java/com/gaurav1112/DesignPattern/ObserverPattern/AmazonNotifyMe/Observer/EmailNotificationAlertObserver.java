package com.gaurav1112.DesignPattern.ObserverPattern.AmazonNotifyMe.Observer;

import com.gaurav1112.DesignPattern.ObserverPattern.AmazonNotifyMe.Observerable.StockObservable;

public class EmailNotificationAlertObserver implements NotificationAlertObserver{

    StockObservable stockObservable;
    String emailId;

    public EmailNotificationAlertObserver(StockObservable stockObservable, String emailId){
        this.stockObservable = stockObservable;
        this.emailId = emailId;
    }
    @Override
    public void update() {
       // stockObservable.setStockCount(stockObservable.getStockCount()-1);
        System.out.println("Email Sent to: "+ emailId);
    }
}
