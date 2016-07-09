package com.yeran.demo.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by yeran on 2016/7/9.
 */
public class TaxiTest {
    private Taxi taxi;
    private int a=0;

    @Before
    public void init(){
        taxi=new Taxi();
        a=1;
    }


    @Test
    public void test_normal_price() {
        long price = taxi.normalPrice(1);
        assertTrue(price==600);
        a++;
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
    public void test_price_by_km_when_less_2() {
         assertEquals(taxi.getKmPrice(1),600);
    }

    @Test
    public void test_price_by_km_when_less_8() {
        assertEquals(taxi.getKmPrice(6),920);
    }

    @Test
    public void test_price_by_km_when_more_8() {
        assertEquals(taxi.getKmPrice(9),1200);
    }

    @Test
    public void test_price_by_time() {
        assertEquals(taxi.timePrice(20),500);
    }

    @Test
    public void test_price_by_time_0() {
        assertEquals(taxi.timePrice(0),0);
    }

    @Test
    public void test_price_format(){
        assertEquals(taxi.priceFormat_yuan(1200),12);
    }



    @Test
    public void test_getPrice(){
        assertEquals(taxi.getPrice(9,0),12);
   //     System.out.print(a+"");
    }

    @Test
    public void test_mock_price_add(){
        Taxi taxi1 = mock(Taxi.class);
        long pri = taxi1.getKmPrice(10);
        given(taxi1.getKmPrice(anyInt())).willReturn(1200L);
        when(taxi1.timePrice(anyInt())).thenReturn(250L);
        long kmPrice = taxi1.getKmPrice(9);
        long timePrice = taxi1.timePrice(10);
        long price = taxi.priceMockTest(kmPrice,timePrice);
        assertEquals(price,1450);
    }
}
