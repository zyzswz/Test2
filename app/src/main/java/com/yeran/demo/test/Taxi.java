package com.yeran.demo.test;

/**
 * Created by yeran on 2016/7/9.
 * <p/>
 * 注意所有计数单位为分，最后统一转为元
 */
public class Taxi {

    /**
     * 起步价6元
     */
    public static long firstPrice = 600;

    /**
     * 每公里0.8元
     */
    public static long priceOnKm = 80;


    public static long firstPrice() {
        return firstPrice;
    }

    public long normalPrice(int km){
        long price=0;
        if(km>2) {
            price  = 80*(km-2)+600;
        }else if(km>0)
            price=600;
        return price;
    }

    /**
     * 超过8公理意外的价格
     * */
    public static long addPrice(int km) {
        if (km>0) {
            double addPrice = priceOnKm * 1.5;
            return (long)addPrice*km;
        }
        else
        return 0;
    }

    public long timePrice(int mins){
        if(mins>0){
            return 25*mins;
        }else return 0;
    }


    public long getPrice(int km,int mins){
        long price=0;
        if(km>8){
            long normalPrice=normalPrice(8);
            int addKm = km-8;
            long addPrice = addPrice(addKm);
            price=normalPrice+addPrice;
        }else {
            price+=normalPrice(km);
        }
        price+=timePrice(mins);
        return price;
    }

}
