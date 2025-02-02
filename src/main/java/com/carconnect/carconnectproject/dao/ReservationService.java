package com.carconnect.carconnectproject.dao;

import com.carconnect.carconnectproject.entity.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {

    private List<Reservation> reservationList = new ArrayList<>();

    // Method to create a reservation
    public void createReservation(Reservation reservation) {
        reservationList.add(reservation);
    }

    // Method to update a reservation by ID
    public void updateReservation(int reservationId, Reservation updatedReservation) {
        for (int i = 0; i < reservationList.size(); i++) {
            Reservation reservation = reservationList.get(i);
            if (reservation.getCustomerId() == reservationId) {
                reservation.setCustomerId(updatedReservation.getCustomerId());
                reservation.setVehicleId(updatedReservation.getVehicleId());
                reservation.setStartDate(updatedReservation.getStartDate());
                reservation.setEndDate(updatedReservation.getEndDate());
                System.out.println("Reservation updated successfully.");
                return;
            }
        }
        System.out.println("Reservation with ID " + reservationId + " not found.");
    }

    // Method to cancel a reservation
    public void cancelReservation(int reservationId) {
        reservationList.removeIf(reservation -> reservation.getCustomerId() == reservationId);
        System.out.println("Reservation cancelled successfully.");
    }

    // Method to get reservations by customer ID
    public List<Reservation> getReservationsByCustomerId(int customerId) {
        List<Reservation> customerReservations = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            if (reservation.getCustomerId() == customerId) {
                customerReservations.add(reservation);
            }
        }
        return customerReservations;
    }
}
