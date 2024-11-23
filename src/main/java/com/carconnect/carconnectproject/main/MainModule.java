package com.carconnect.carconnectproject.main;

import com.carconnect.carconnectproject.dao.CustomerService;
import com.carconnect.carconnectproject.dao.VehicleService;
import com.carconnect.carconnectproject.dao.ReservationService;
import com.carconnect.carconnectproject.entity.Customer;
import com.carconnect.carconnectproject.entity.Vehicle;
import com.carconnect.carconnectproject.entity.Reservation;
import com.carconnect.carconnectproject.exception.InvalidInputException;

import java.util.Scanner;

public class MainModule {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\nCarConnect - Main Menu");
                System.out.println("1. Customer Management");
                System.out.println("2. Vehicle Management");
                System.out.println("3. Reservation Management");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        handleCustomerManagement();
                        break;
                    case 2:
                        handleVehicleManagement();
                        break;
                    case 3:
                        handleReservationManagement();
                        break;
                    case 4:
                        System.out.println("Exiting... Thank you for using CarConnect!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    private static void handleCustomerManagement() {
        CustomerService customerService = new CustomerService();

        while (true) {
            try {
                System.out.println("\nCustomer Management Menu:");
                System.out.println("1. Register Customer");
                System.out.println("2. Update Customer");
                System.out.println("3. Delete Customer");
                System.out.println("4. View Customer by ID");
                System.out.println("5. Back to Main Menu");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter customer details (ID FirstName LastName Email Phone Address Username Password):");
                        String[] input = scanner.nextLine().split("\\s+");
                        if (input.length != 8) {
                            System.out.println("Error: Please provide all 8 fields.");
                            continue;
                        }
                        Customer customer = new Customer(
                                Integer.parseInt(input[0]), input[1], input[2], input[3],
                                input[4], input[5], input[6], input[7], null);
                        customerService.registerCustomer(customer);
                        System.out.println("Customer registered successfully.");
                        break;
                    case 2:
                        System.out.print("Enter customer ID to update: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter updated details (FirstName LastName Email Phone Address Username Password):");
                        String[] updateInput = scanner.nextLine().split("\\s+");
                        if (updateInput.length != 7) {
                            System.out.println("Error: Please provide all 7 fields.");
                            continue;
                        }
                        Customer updatedCustomer = new Customer(
                                id, updateInput[0], updateInput[1], updateInput[2],
                                updateInput[3], updateInput[4], updateInput[5], updateInput[6], null);
                        customerService.updateCustomer(updatedCustomer);
                        System.out.println("Customer updated successfully.");
                        break;
                    case 3:
                        System.out.print("Enter customer ID to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        customerService.deleteCustomer(deleteId);
                        System.out.println("Customer deleted successfully.");
                        break;
                    case 4:
                        System.out.print("Enter customer ID to view: ");
                        int viewId = Integer.parseInt(scanner.nextLine());
                        Customer viewCustomer = customerService.getCustomerById(viewId);
                        System.out.println("Customer Details: " + viewCustomer);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter valid numbers.");
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void handleVehicleManagement() {
        VehicleService vehicleService = new VehicleService();

        while (true) {
            try {
                System.out.println("\nVehicle Management Menu:");
                System.out.println("1. Add Vehicle");
                System.out.println("2. Update Vehicle");
                System.out.println("3. Remove Vehicle");
                System.out.println("4. View Available Vehicles");
                System.out.println("5. Back to Main Menu");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter vehicle details (ID Model Make Year Color RegistrationNumber Availability DailyRate):");
                        String[] input = scanner.nextLine().split("\\s+");
                        if (input.length != 8) {
                            System.out.println("Error: Please provide all 8 fields.");
                            continue;
                        }
                        Vehicle vehicle = new Vehicle(
                                Integer.parseInt(input[0]), input[1], input[2], Integer.parseInt(input[3]),
                                input[4], input[5], Boolean.parseBoolean(input[6]), Double.parseDouble(input[7]));
                        vehicleService.addVehicle(vehicle);
                        System.out.println("Vehicle added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter vehicle ID to update: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter updated details (Model Make Year Color RegistrationNumber Availability DailyRate):");
                        String[] updateInput = scanner.nextLine().split("\\s+");
                        if (updateInput.length != 7) {
                            System.out.println("Error: Please provide all 7 fields.");
                            continue;
                        }
                        Vehicle updatedVehicle = new Vehicle(
                                id, updateInput[0], updateInput[1], Integer.parseInt(updateInput[2]),
                                updateInput[3], updateInput[4], Boolean.parseBoolean(updateInput[5]), Double.parseDouble(updateInput[6]));
                        vehicleService.updateVehicle(updatedVehicle);
                        System.out.println("Vehicle updated successfully.");
                        break;
                    case 3:
                        System.out.print("Enter vehicle ID to remove: ");
                        int removeId = Integer.parseInt(scanner.nextLine());
                        vehicleService.removeVehicle(removeId);
                        System.out.println("Vehicle removed successfully.");
                        break;
                    case 4:
                        System.out.println("Available Vehicles:");
                        for (Vehicle availableVehicle : vehicleService.getAvailableVehicles()) {
                            System.out.println(availableVehicle);
                        }
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter valid numbers.");
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void handleReservationManagement() {
        ReservationService reservationService = new ReservationService();

        while (true) {
            try {
                System.out.println("\nReservation Management Menu:");
                System.out.println("1. Create Reservation");
                System.out.println("2. Update Reservation");
                System.out.println("3. Cancel Reservation");
                System.out.println("4. View Reservations by Customer ID");
                System.out.println("5. Back to Main Menu");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter reservation details (CustomerID VehicleID StartDate EndDate TotalCost Status):");
                        String[] input = scanner.nextLine().split("\\s+");
                        if (input.length != 6) {
                            System.out.println("Error: Please provide all 6 fields.");
                            continue;
                        }
                        Reservation reservation = new Reservation(
                                Integer.parseInt(input[0]), Integer.parseInt(input[1]),
                                input[2], input[3], Double.parseDouble(input[4]), input[5]);
                        reservationService.createReservation(reservation);
                        System.out.println("Reservation created successfully.");
                        break;
                    case 2:
                        System.out.print("Enter reservation ID to update: ");
                        int updateId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter updated details (CustomerID VehicleID StartDate EndDate TotalCost Status):");
                        String[] updateInput = scanner.nextLine().split("\\s+");
                        if (updateInput.length != 6) {
                            System.out.println("Error: Please provide all 6 fields.");
                            continue;
                        }
                        Reservation updatedReservation = new Reservation(
                                Integer.parseInt(updateInput[0]), Integer.parseInt(updateInput[1]),
                                updateInput[2], updateInput[3], Double.parseDouble(updateInput[4]), updateInput[5]);
                        reservationService.updateReservation(updateId, updatedReservation);
                        System.out.println("Reservation updated successfully.");
                        break;
                    case 3:
                        System.out.print("Enter reservation ID to cancel: ");
                        int cancelId = Integer.parseInt(scanner.nextLine());
                        reservationService.cancelReservation(cancelId);
                        System.out.println("Reservation cancelled successfully.");
                        break;
                    case 4:
                        System.out.print("Enter customer ID to view reservations: ");
                        int customerId = Integer.parseInt(scanner.nextLine());
                        for (Reservation res : reservationService.getReservationsByCustomerId(customerId)) {
                            System.out.println(res);
                        }
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter valid numbers.");
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
