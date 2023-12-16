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




// AMIRAH'S PART //




// DINIY'S PART //

