package com.yeran.demo.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by yeran on 2016/7/9.
 */
public class TaxiTest {
    private Taxi taxi;

    @Before
    public void init(){
        taxi=new Taxi();
    }


    @Test
    public void test_normal_price() {
        long price = taxi.normalPrice(1);
        assertTrue(price==600);
    }



//    public long getPrice(int km){
//        long price=0;
//        if(km>8){
//            long normalPrice=normalPrice(8);
//            int addKm = km-8;
//            long addPrice = addPrice(addKm);
//            price=normalPrice+addPrice;
//        }else {
//            price+=normalPrice(km);
//        }
//        return price;
//    }

    @Test
    public void test_getPrice(){
    //   long price = getPrice(1);
        assertEquals(taxi.getPrice(9,0),12);
    }
}
