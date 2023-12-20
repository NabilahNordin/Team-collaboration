// test for our Reservation Venue System //

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VenueReservationSystem reservationSystem = new VenueReservationSystem();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nChoose your option:");
            System.out.println("1. View available venues");
            System.out.println("2. Make a reservation");
            System.out.println("3. View all reservations");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    reservationSystem.displayVenues();
                    break;
                case 2:
                    reservationSystem.makeReservation(scanner);
                    break;
                case 3:
                    reservationSystem.viewAllReservations();
                    break;
                case 4:
                    // Add logic for cancellation as in your original code
                    break;
                case 5:
                    System.out.println("Thank you. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }
}