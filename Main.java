// test for our Reservation Venue System //

// DAMIA'S PART //
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Building building = new Building();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            // Display menu
            System.out.println("\n Choose your option:");
            System.out.println("1. View available venues");
            System.out.println("2. Make a reservation");
            System.out.println("3. View all reservations");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    building.displayVenues();
                    break;
                case 2:
                    System.out.println("Please note: The venues are operating from 8am until 11pm.");
                    makeReservation(scanner, building);
                    break;
                case 3:
                    building.viewAllReservations();
                    break;
                case 4:
                    System.out.println("Thank you. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);

        scanner.close();
    }

    private static void makeReservation(Scanner scanner, Building building) {
        int venueId;
        do {
            System.out.print("\nEnter the venue ID to reserve (1-30): ");
            venueId = scanner.nextInt();
            scanner.nextLine();
    
            if (building.isVenueReserved(venueId)) {
                System.out.println("The venue is already reserved. Please enter a different venue.");
            }
        } while (building.isVenueReserved(venueId));
    
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();
    
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine().trim();
    
        System.out.print("Enter the type of event (Conference or Seminar): ");
        String eventType = scanner.nextLine().trim();
    
        building.makeReservation(venueId, name, phoneNumber, eventType);
    }
}


// NABILAH'S PART //




// AMIRA'S PART //

import java.time.LocalDateTime;
import java.util.Scanner;

public class MainReservation {
    public static void main(String[] args) {
        VenueReservationSystem reservationSystem = new VenueReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Make a reservation");
System.out.println("2. Exit");
System.out.print("Enter your choice: ");
int choice = scanner.nextInt();
scanner.nextLine(); // Consume newline left-over

switch (choice) {
    case 1:
    System.out.print("Enter venue number (1-30): ");
    int venueNumber = scanner.nextInt();
    scanner.nextLine(); // Consume newline left-over

    System.out.print("Enter reservation date (YYYY-MM-DD): ");
    String dateString = scanner.nextLine();

    System.out.print("Enter start time (HH:mm): ");
    String startTimeString = scanner.nextLine();
    LocalDateTime startTime = LocalDateTime.parse(dateString + " " + startTimeString, VenueReservationSystem.DATE_TIME_FORMATTER);

    System.out.print("Enter end time (HH:mm): ");
    String endTimeString = scanner.nextLine();
    LocalDateTime endTime = LocalDateTime.parse(dateString + " " + endTimeString, VenueReservationSystem.DATE_TIME_FORMATTER);

    reservationSystem.reserveVenue(venueNumber, startTime, endTime);
    break;
    case 2:
        System.out.println("Exiting...");
        scanner.close();
        return;
    default:
        System.out.println("Invalid choice. Please enter 1 or 2.");
}
        }
    }
}


// DINIY'S PART //

