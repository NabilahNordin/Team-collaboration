// test for our Reservation Venue System //
/* Members of the Group 5 are :
   NABILAH BINTI AHMAD NORDIN (2225498),
   SITI DAMIA BINTI AB RAZAK  (2210034),
   NUR AMIRA BINTI AZHARI     (2217176),
   DINIY BINTI JOHAN          (2224132). */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        VenueReservationSystem venueReservationSystem = new VenueReservationSystem();
        boolean continueLoop = true; // Determines if the program should continue looping

        while (continueLoop) {
            displayMenu();

            int option = input.nextInt();
            input.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    venueReservationSystem.availableVenues();
                    break;
                case 2:
                    venueReservationSystem.makeReservation(venueReservationSystem.getBookings());
                    break;
                case 3:
                    venueReservationSystem.findReservation(venueReservationSystem.getBookings());
                    break;
                case 4:
                    venueReservationSystem.cancelReservation(venueReservationSystem.getBookings());
                    break;
                case 5:
                    continueLoop = false;
                    System.out.println("All memory cache data deleted. Bye2");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        input.close();
    }

    private static void displayMenu() {
        System.out.println("#################################################");
        System.out.println("####  Welcome To Venue Reservation System  ####");
        System.out.println("#################################################");
        System.out.println("Choose your option: \n1. View unavailable venues \n2. Make a reservation \n3. Find reservations \n4. Cancel Reservation \n5. Exit");
        System.out.println("Enter your option:");
    }
}
