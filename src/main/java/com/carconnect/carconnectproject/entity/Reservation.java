package com.carconnect.carconnectproject.entity;

public class Reservation {
    private int customerId;
    private int vehicleId;
    private String startDate;
    private String endDate;
    private double totalCost;  // New field
    private String status;     // New field

    // Default constructor
    public Reservation() {}

    // Constructor to initialize all fields
    public Reservation(int customerId, int vehicleId, String startDate, String endDate, double totalCost, String status) {
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.status = status;
    }

    // Getter and Setter methods for all fields
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "customerId=" + customerId +
                ", vehicleId=" + vehicleId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", totalCost=" + totalCost +
                ", status='" + status + '\'' +
                '}';
    }
}
