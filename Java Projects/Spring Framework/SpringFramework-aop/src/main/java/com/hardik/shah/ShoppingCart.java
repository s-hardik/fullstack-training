package com.hardik.shah;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public  void checkOut(String status){
        System.out.println("Checkout Method for printing class is called.");
    }
    public int quantity(){
        return 2;
    }
}
