// Reservation Venue System //

// DAMIA'S PART //

import java.util.ArrayList;
import java.util.List;

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
        this.venues = new ArrayList<>();
        initializeVenues();
    }

    private void initializeVenues() {
        for (int i = 1; i <= 30; i++) {
            venues.add(new Venue(i));
        }
    }

    public List<Venue> getVenues() {
        return venues;
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
        if (venueId < 1 || venueId > venues.size()) {
            return true; 
        }
        Venue venue = venues.get(venueId - 1);
        return !venue.getVenueType().isEmpty();
    }


    public void makeReservation(int venueId, String name, String phoneNumber, String eventType) {
        Venue selectedVenue = getVenueById(venueId);

        if (selectedVenue != null && selectedVenue.getVenueType().isEmpty()) {
            System.out.println("Processing reservation for Venue ID: " + venueId + " for " + eventType);
            selectedVenue.setVenueType(eventType);
            selectedVenue.setReservedBy(name);
            selectedVenue.setPhoneNumber(phoneNumber);
        } else {
            System.out.println("The venue is already reserved. Please enter a different venue.");
        }
    }

    private Venue getVenueById(int venueId) {
        for (Venue venue : venues) {
            if (venue.getVenueId() == venueId) {
                return venue;
            }
        }
        return null;
    }

    public void viewAllReservations() {
        System.out.println("\nAll Reservations:");
        for (Venue venue : venues) {
            if (!venue.getVenueType().isEmpty()) {
                System.out.println("Reserved by: " + venue.getReservedBy() + ", Phone Number: "
                        + venue.getPhoneNumber() + ", Venue ID: " + venue.getVenueId() + ", Type: " + venue.getVenueType());
            }
        }
    }
}





// NABILAH'S PART (combination with AMIRA's PART) //

class Reservation {
    private LocalDateTime start;
    private LocalDateTime end;

    public Reservation(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public boolean conflictsWith(LocalDateTime otherStart, LocalDateTime otherEnd) {
        return !start.isAfter(otherEnd) && !end.isBefore(otherStart);
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}

class Venue {
    private String name;
    private List<Reservation> reservations;

    public Venue(String name) {
        this.name = name;
        this.reservations = new ArrayList<>();
    }

    public boolean tryReserve(LocalDateTime start, LocalDateTime end) {
        for (Reservation reservation : reservations) {
            if (reservation.conflictsWith(start, end)) {
                return false;
            }
        }
        reservations.add(new Reservation(start, end));
        return true;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public String getName() {
        return name;
    }
}

class VenueReservationManager {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private List<Venue> venues;

    public VenueReservationManager() {
        venues = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            venues.add(new Venue("Venue " + (i + 1)));
        }
    }

    public boolean reserveVenue(int venueNumber, LocalDateTime start, LocalDateTime end) {
        if (venueNumber < 1 || venueNumber > venues.size()) {
            System.out.println("Invalid venue number");
            return false;
        }
        if (!venues.get(venueNumber - 1).tryReserve(start, end)) {
            System.out.println("Venue is already reserved at this time.");
            return false;
        }
        System.out.println("Venue reserved successfully.");
        Duration duration = Duration.between(start, end);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        System.out.println("Your reservation is for " + hours + " hour(s) and " + minutes + " minute(s).");
        return true;
    }

    // Implement checkReservationsByVenue, checkReservationsByDate, checkReservationsByTime methods
    // ... (Add these methods here)
    public void checkReservationsByVenue(int venueNumber) {
        if (venueNumber < 1 || venueNumber > venues.size()) {
            System.out.println("Invalid venue number");
            return;
        }
        Venue venue = venues.get(venueNumber - 1);
        if (venue.getReservations().isEmpty()) {
            System.out.println("No reservations for Venue " + venueNumber);
            return;
        }
        for (Reservation reservation : venue.getReservations()) {
            System.out.println("Reserved from " +
                               reservation.getStart().format(DATE_TIME_FORMATTER) +
                               " to " +
                               reservation.getEnd().format(DATE_TIME_FORMATTER));
        }
    }

    public void checkReservationsByDate(LocalDate date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        boolean foundReservation = false;
        for (Venue venue : venues) {
            for (Reservation reservation : venue.getReservations()) {
                if (reservation.getStart().toLocalDate().equals(date)) {
                    System.out.println(venue.getName() + " reserved from " +
                                       reservation.getStart().format(DATE_TIME_FORMATTER) +
                                       " to " +
                                       reservation.getEnd().format(DATE_TIME_FORMATTER));
                    foundReservation = true;
                }
            }
        }
        if (!foundReservation) {
            System.out.println("No reservations found on " + date.format(dateFormatter));
        }
    }

    public void checkReservationsByTime(LocalTime time) {
        boolean foundReservation = false;
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        for (Venue venue : venues) {
            for (Reservation reservation : venue.getReservations()) {
                if (!reservation.getStart().toLocalTime().isAfter(time) &&
                    !reservation.getEnd().toLocalTime().isBefore(time)) {
                    System.out.println(venue.getName() + " has a reservation around " +
                                       time.format(timeFormatter) +
                                       " on " +
                                       reservation.getStart().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    foundReservation = true;
                }
            }
        }
        if (!foundReservation) {
            System.out.println("No reservations found around " + time.format(timeFormatter));
        }
    }
}


// AMIRA'S PART //


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.*;

public class VenueReservationSystem {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final int TOTAL_VENUES = 30;
    private static final int OPENING_HOUR = 8;
    private static final int CLOSING_HOUR = 23;
    private Map<Integer, PriorityQueue<LocalDateTime>> venueReservations;

    public VenueReservationSystem() {
        venueReservations = new HashMap<>();
        for (int i = 1; i <= TOTAL_VENUES; i++) {
            venueReservations.put(i, new PriorityQueue<>());
        }
    }

    public boolean reserveVenue(int venueNumber, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (venueNumber < 1 || venueNumber > TOTAL_VENUES) {
            System.out.println("Invalid venue number.");
            return false;
        }
        if (startDateTime.getHour() < OPENING_HOUR || (startDateTime.getHour() == CLOSING_HOUR && startDateTime.getMinute() > 0) || endDateTime.getHour() > CLOSING_HOUR || (endDateTime.getHour() == CLOSING_HOUR && endDateTime.getMinute() > 0)) {
            System.out.println("Venue is closed at this time.");
            return false;
        }
        PriorityQueue<LocalDateTime> reservations = venueReservations.get(venueNumber);
        for (LocalDateTime existing : reservations) {
            if ((startDateTime.isEqual(existing) || startDateTime.isAfter(existing)) && startDateTime.isBefore(existing.plusHours(1))) {
                System.out.println("Venue is already reserved at this time.");
                return false;
            }
            if ((endDateTime.isEqual(existing) || endDateTime.isAfter(existing)) && endDateTime.isBefore(existing.plusHours(1))) {
                System.out.println("Venue is already reserved at this time.");
                return false;
            }
        }
        reservations.add(startDateTime);
        reservations.add(endDateTime);
        System.out.println("Venue reserved successfully.");
    
        Duration duration = Duration.between(startDateTime, endDateTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        System.out.println("Your reservation is for " + hours + " hour(s) and " + minutes + " minute(s).");
    
        return true;
    }

    public void serveNextReservation(int venueNumber) {
        if (venueNumber < 1 || venueNumber > TOTAL_VENUES) {
            System.out.println("Invalid venue number.");
            return;
        }
        PriorityQueue<LocalDateTime> reservations = venueReservations.get(venueNumber);
        if (reservations.isEmpty()) {
            
            return;
        }
        LocalDateTime nextReservation = reservations.poll();
        System.out.println("Serving reservation for venue " + venueNumber + " at " + nextReservation.format(DATE_TIME_FORMATTER));
    }
}


// DINIY'S PART //
