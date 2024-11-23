package com.carconnect.carconnectproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

   
    @Test
    void testCalculateSpeed_ValidInput() {
      
        CarConnectApp app = new CarConnectApp();
        
      
        int speed = app.calculateSpeed(100, 2);
        
      
        assertEquals(50, speed, "Speed calculation failed for valid inputs");
    }

    @Test
    void testCalculateSpeed_DivisionByZero() {
       
        CarConnectApp app = new CarConnectApp();
        
       
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.calculateSpeed(100, 0);
        });
        
      
        assertEquals("Time cannot be zero", exception.getMessage());
    }

    @Test
    void testCalculateBalance_ValidInput() {
      
        CarConnectApp app = new CarConnectApp();
      
        double balance = app.calculateBalance(1000, 200);
        
        assertEquals(800, balance, "Balance calculation failed for valid inputs");
    }

   
    @Test
    void testCalculateBalance_NegativeBalance() {
       
        CarConnectApp app = new CarConnectApp();
        
       
        double balance = app.calculateBalance(1000, 1500);
        
        assertEquals(-500, balance, "Balance calculation failed for negative balance");
    }

    @Test
    void testCalculateBalance_ZeroBalance() {
       
        CarConnectApp app = new CarConnectApp();
        
        
        double balance = app.calculateBalance(1000, 1000);
        
        
        assertEquals(0, balance, "Balance calculation failed for zero balance");
    }
}
