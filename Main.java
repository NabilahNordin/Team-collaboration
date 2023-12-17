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


public class MainReservation {
    public static void main(String[] args) {
        VenueReservationManager manager = new VenueReservationManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Make a reservation");
            System.out.println("2. Checking");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                System.out.print("Enter venue number (1-30): ");
                VenueReservationManager reservationSystem = new VenueReservationManager();

                int venueNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                System.out.print("Enter reservation date (YYYY-MM-DD): ");
                String dateString = scanner.nextLine();

                System.out.print("Enter start time (HH:mm): ");
                String startTimeString = scanner.nextLine();
                LocalDateTime startTime = LocalDateTime.parse(dateString + " " + startTimeString, manager.DATE_TIME_FORMATTER);

                System.out.print("Enter end time (HH:mm): ");
                String endTimeString = scanner.nextLine();
                LocalDateTime endTime = LocalDateTime.parse(dateString + " " + endTimeString, manager.DATE_TIME_FORMATTER);

                reservationSystem.reserveVenue(venueNumber, startTime, endTime);
                break;
                case 2: // Checking reservations
                      System.out.println("Options\n1. Enter a venue\n2. Enter a date\n3. Enter a time\n\nChoose option:");
    int subChoice = scanner.nextInt();
    scanner.nextLine(); // Consume the newline

    switch (subChoice) {
        case 1:
            // Logic for checking reservations by venue
            System.out.println("Enter a venue number (1-30):");
            int venueNum = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            manager.checkReservationsByVenue(venueNum);
            break;
        case 2:
            // Logic for checking reservations by date
            System.out.println("Enter a date (YYYY-MM-DD):");
            String dateStr = scanner.nextLine();
            try {
                LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
                manager.checkReservationsByDate(date);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format.");
            }
            break;
        case 3:
            // Logic for checking reservations by time
            System.out.println("Enter a time (HH:mm):");
            String timeStr = scanner.nextLine();
            try {
                LocalTime time = LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm"));
                manager.checkReservationsByTime(time);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format.");
            }
            break;
        default:
            System.out.println("Invalid option.");
            break;
    }
    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}

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

