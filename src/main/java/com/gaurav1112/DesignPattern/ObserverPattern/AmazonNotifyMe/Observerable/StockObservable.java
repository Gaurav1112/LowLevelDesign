package com.gaurav1112.DesignPattern.ObserverPattern.AmazonNotifyMe.Observerable;

import com.gaurav1112.DesignPattern.ObserverPattern.AmazonNotifyMe.Observer.NotificationAlertObserver;

import java.util.List;

public interface StockObservable {

    public void add(NotificationAlertObserver obj);
    public void remove(NotificationAlertObserver obj);
    public void notifySubscriber();

    public void setStockCount(int newStockAdded);

    public int getStockCount();

    }
