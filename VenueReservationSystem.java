// Reservation Venue System //

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;

class Venue {
    private int venueId;
    private String venueType;
    private String reservedBy;
    private String phoneNumber;

    public Venue(int venueId) {
        this.venueId = venueId;
        this.venueType = "";
        this.reservedBy = "";
        this.phoneNumber = "";
    }

    // Getters and setters
    public int getVenueId() {
        return venueId;
    }

    public String getVenueType() {
        return venueType;
    }

    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

    public String getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

class Building {
    private List<Venue> venues;

    public Building() {
        venues = new ArrayList<>();
        initializeVenues();
    }

    private void initializeVenues() {
        for (int i = 1; i <= 30; i++) {
            venues.add(new Venue(i));
        }
    }

    public void displayVenues() {
        System.out.println("\nAvailable venues:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                int venueId = i + 1 + j * 10;
                if (venueId <= venues.size()) {
                    String status = venues.get(venueId - 1).getVenueType().isEmpty() ? "" : "(reserved)";
                    System.out.printf("Venue ID: %2d %s\t", venueId, status);
                } else {
                    System.out.print("\t\t");
                }
            }
            System.out.println();
        }
    }

    public boolean isVenueReserved(int venueId) {
        return !venues.get(venueId - 1).getVenueType().isEmpty();
    }

    public void makeReservation(int venueId, String name, String phoneNumber, String eventType) {
        Venue venue = venues.get(venueId - 1);
        venue.setVenueType(eventType);
        venue.setReservedBy(name);
        venue.setPhoneNumber(phoneNumber);
        System.out.println("Processing reservation for Venue ID: " + venueId + " for " + eventType);
    }

    public void viewAllReservations() {
        System.out.println("\nAll Reservations:");
        for (Venue venue : venues) {
            if (!venue.getVenueType().isEmpty()) {
                System.out.println("Reserved by: " + venue.getReservedBy() + ", Phone Number: " + venue.getPhoneNumber() + ", Venue ID: " + venue.getVenueId() + ", Type: " + venue.getVenueType());
            }
        }
    }
}

public class VenueReservationSystem {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final int TOTAL_VENUES = 30;
    private static final int OPENING_HOUR = 8;
    private static final int CLOSING_HOUR = 23;
    private static final BigDecimal FEE_RATE = new BigDecimal("10.00"); // Fee rate per half an hour

    private Building building;

    public VenueReservationSystem() {
        building = new Building();
    }

    public void displayVenues() {
        building.displayVenues();
    }

    public void makeReservation(Scanner scanner) {
        System.out.println("Please note: The venues are operating from 8am until 11pm.");

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

        System.out.print("Enter reservation date (YYYY-MM-DD): ");
        String dateString = scanner.nextLine();

        System.out.print("Enter start time (HH:mm): ");
        String startTimeString = scanner.nextLine(); // Fix: Add missing method call on scanner object

        System.out.print("Enter end time (HH:mm): ");
        String endTimeString = scanner.nextLine();
        LocalDateTime startTime = LocalDateTime.parse(dateString + " " + startTimeString, DATE_TIME_FORMATTER);

        LocalDateTime endTime = LocalDateTime.parse(dateString + " " + endTimeString, DATE_TIME_FORMATTER);

        if (endTime.isBefore(startTime)) {
            endTime = endTime.plusDays(1);
        }

        // Reservation logic
        if (reserveVenue(venueId, startTime, endTime)) {
            building.makeReservation(venueId, name, phoneNumber, eventType);
        }
    }

    public boolean reserveVenue(int venueNumber, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        // Check if the venue number is valid
        if (venueNumber < 1 || venueNumber > TOTAL_VENUES) {
            System.out.println("Invalid venue number.");
            return false;
        }

        // Check for valid reservation times
        if (!isValidReservationTime(startDateTime, endDateTime)) {
            return false;
        }

        // Venue availability logic
        // This logic is simplified. Implement conflict checking based on your application's needs.

        System.out.println("\nVenue reserved successfully.");
        calculateFee(startDateTime, endDateTime);
        return true;
    }

    private boolean isValidReservationTime(LocalDateTime start, LocalDateTime end) {
        // Check opening and closing times
        if (start.getHour() < OPENING_HOUR || end.getHour() > CLOSING_HOUR) {
            System.out.println("Venue is closed at this time.");
            return false;
        }
        // Check if the reservation pasts midnight
        if (!start.toLocalDate().isEqual(end.toLocalDate())) {
            System.out.println("Overnight reservations are not allowed.");
            return false;
        }
        return true;
    }

    private void calculateFee(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        long totalMinutes = (duration.toMinutes() + 29) / 30 * 30; // Rounding up to the nearest half-hour
        BigDecimal fee = FEE_RATE.multiply(new BigDecimal(totalMinutes / 30));
        System.out.println("The reservation fee is (RM10/half an hour): RM" + fee.setScale(2, RoundingMode.HALF_UP));
    }

    public void viewAllReservations() {
        building.viewAllReservations();
    }
}