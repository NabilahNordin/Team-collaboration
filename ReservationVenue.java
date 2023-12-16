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





// NABILAH'S PART //




// AMIRAH'S PART //




// DINIY'S PART //
