package com.gaurav1112.DesignPattern.ObserverPattern.AmazonNotifyMe;

import com.gaurav1112.DesignPattern.ObserverPattern.AmazonNotifyMe.Observer.EmailNotificationAlertObserver;
import com.gaurav1112.DesignPattern.ObserverPattern.AmazonNotifyMe.Observer.MobileNotificationAlertObserver;
import com.gaurav1112.DesignPattern.ObserverPattern.AmazonNotifyMe.Observer.NotificationAlertObserver;
import com.gaurav1112.DesignPattern.ObserverPattern.AmazonNotifyMe.Observerable.IphoneStockObservable;
import com.gaurav1112.DesignPattern.ObserverPattern.AmazonNotifyMe.Observerable.StockObservable;

public class ObserverNotifyMeMain {

        public static void main(String[] args){
            StockObservable iphoneStockObservable = new IphoneStockObservable();

            NotificationAlertObserver observer1 = new EmailNotificationAlertObserver(iphoneStockObservable, "abc@gmail.com");
            NotificationAlertObserver observer2 = new MobileNotificationAlertObserver(iphoneStockObservable, "Nokia 7613");

            iphoneStockObservable.add(observer1);
            iphoneStockObservable.add(observer2);

            iphoneStockObservable.setStockCount(2);
        }
}
