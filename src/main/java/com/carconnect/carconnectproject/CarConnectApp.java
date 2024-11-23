package com.carconnect.carconnectproject;

public class CarConnectApp {

   
    public int calculateSpeed(int distance, int time) {
        if (time == 0) {
            throw new IllegalArgumentException("Time cannot be zero");
        }
        return distance / time;
    }

  
    public double calculateBalance(double initialBalance, double deduction) {
        return initialBalance - deduction;
    }
}
