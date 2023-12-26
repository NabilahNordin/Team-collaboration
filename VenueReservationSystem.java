//GROUP 5//
// Reservation Venue System //
/* Members of the Group 5 are :
   NABILAH BINTI AHMAD NORDIN (2225498),
   SITI DAMIA BINTI AB RAZAK  (2210034),
   NUR AMIRA BINTI AZHARI     (2217176),
   DINIY BINTI JOHAN          (2224132). */

   import java.util.ArrayList;
   import java.util.List;
   import java.util.Scanner;
   
   public class VenueReservationSystem {
   
       private List<Booking> bookings;
       private Scanner scanner;
       private int venueId;
       private String phone;
       private String type;
       private String reservationDateString;
       private String time;
   
       public VenueReservationSystem() {
           bookings = new ArrayList<>();
           scanner = new Scanner(System.in);
           venueId = 0; // Initialize the variable venueId
           phone = ""; // Initialize the variable phone
           type = ""; // Initialize the variable type
           reservationDateString = ""; // Initialize the variable reservationDateString
           time = ""; // Initialize the variable time
       }
   
       void availableVenues() {
           if (bookings.isEmpty()) {
               System.out.println("\n---------------\nAll venues available. \n\n---------------\n");
           } else {
               System.out.println("#################################################");
               System.out.println("####   Booking ID already reserved           ####");
               System.out.println("####    A) 8:00 am - 6:00 pm                 ####");
               System.out.println("####    B) 6:00 pm - 11:00 pm                ####");
               System.out.println("#################################################");
               System.out.println("Booking ID already reserved : \n");
               System.out.println("############################################################################################");
   
               for (int key = 0; key < bookings.size(); key++) {
                   Booking val = bookings.get(key);
                   String rt = (val.getTime().equals("A")) ? "A = for 8:00 am until 6:00 pm" : "B = for 6:00 pm until 11:00 pm";
                   String ty;
                   if (val.getType().equals("1")) {
                       ty = "1 = Conference";
                   } else if (val.getType().equals("2")) {
                       ty = "2 = Seminar";
                   } else {
                       ty = val.getType();
                   }
   
                   System.out.println("ID: " + (key + 1) + ", Venue: " + val.getVenueId() + ", Name: " + val.getName() + ", Phone: " + val.getPhone() +
                           ", Date: " + val.getReservationDate() + ", Time: " + rt);
               }
         //      System.out.println("############################################################################################");
               System.out.println("---------------\n\n\n");
           }
       }
   
       List<Booking> makeReservation(List<Booking> bookings) {
           System.out.println("\n##############################################################################");
           System.out.println("####                         Make Reservation                             ####");
           System.out.println("####----------------------------------------------------------------------####");
           System.out.println("####  Please note: The venues are operating from 8:00 am until 11:00 pm   ####");
           System.out.println("####               2 sessions in a day.                                   ####");
           System.out.println("####               A) 8:00 am - 6:00 pm                                   ####");
           System.out.println("####               B) 6:00 pm - 11:00 pm                                  ####");
           System.out.println("##############################################################################");
   
           boolean x = false;
           while (!x) {
               System.out.println("\nEnter the venue ID to reserve (1-30):");
               int venueId = Integer.parseInt(scanner.nextLine());
   
               if (venueId < 1 || venueId > 30) {
                   System.out.println("Error venue ID. Please input 1 to 30 only.");
                   x = false;
               } else {
                   x = true;
   
                   int bothAB = 0;
                   for (Booking val : bookings) {
                       if (venueId == val.getVenueId() && (val.getTime().equals("A") || val.getTime().equals("B"))) {
                           bothAB++;
                       }
                       if (bothAB > 1) {
                           System.out.println("Error " + venueId + " already reserved. Please input 1 to 30 except " + venueId);
                           x = false;
                           break;
                       }
                   }
                   // Update the venueId instance variable
               this.venueId = venueId;
               }
           }
   
           System.out.println("Enter your Name:");
           String name = scanner.nextLine();
   
           boolean z = false;
           while (!z) {
               System.out.println("Enter your phone number:");
               this.phone = scanner.nextLine();
               if (this.phone.matches("\\d{10,11}")) {
                   z = true;
               } else {
                   System.out.println("The phone number is not valid. Phone Number must be 10 or 11 digits.");
               }
           }
   
           z = false;
           while (!z) {
               System.out.println("Enter the type of event \n'1' = Conference\n'2' = Seminar");
               this.type = scanner.nextLine();
               if (this.type.equals("1") || this.type.equals("2")) {
                   z = true;
               } else {
                   System.out.println("The type of event is not valid. Please input 1 or 2 only.");
               }
           }
   
           z = false;
           while (!z) {
               System.out.println("Enter reservation date (YYYY-MM-DD):");
               this.reservationDateString = scanner.nextLine();
               if (is_valid_date_format(this.reservationDateString)) {
                   if (is_date_before_today(this.reservationDateString)) {
                       z = true;
                   } else {
                       System.out.println("Please input a reservation date (YYYY-MM-DD) that is more than today. Example: " + java.time.LocalDate.now());
                   }
               } else {
                   System.out.println("Please input a reservation date (YYYY-MM-DD). Example: " + java.time.LocalDate.now());
               }
           }
   
           z = false;
           while (!z) {
               System.out.println("Enter reservation time \n'A' = 8:00 am until 6:00 pm \n'B' = 6:00 pm until 11:00 pm: \n'C' = cancel");
               this.time = scanner.nextLine();
               if (this.time.equals("A") || this.time.equals("B")) {
                   z = true;
               } else {
                   System.out.println("Please input 'A' for 8:00 am until 6:00 pm or 'B' for 6:00 pm until 11:00 pm only.");
               }
   
               if (z) {
                   for (Booking val : bookings) {
                       if (this.time.equals(val.getTime()) && venueId == val.getVenueId()) {
                           if (val.getTime().equals("A")) {
                               System.out.println("Error. 'A' = for 8:00 am until 6:00 pm already reserved. Please select 'B' = for 6:00 pm until 11:00 pm only.");
                           } else {
                               System.out.println("Error. 'B' = for 6:00 pm until 11:00 pm already reserved. Please select 'A' = for 8:00 am until 6:00 pm only.");
                           }
   
                           x = false;
                           z = false;
                           break;
                       }
                   }
               }
   
               if (this.time.equals("C")) {
                   System.out.println("Cancel Reservation\n\n\n\n");
                   return bookings;
   
                   
               }
           }
   
           bookings.add(new Booking(this.venueId, name, this.phone, this.type, this.reservationDateString, this.time));
   
           String rt = (this.time.equals("A")) ? "A = for 8:00 am until 6:00 pm" : "B = for 6:00 pm until 11:00 pm";
           String ty;
           if (this.type.equals("1")) {
               ty = "1 = Conference";
           } else if (this.type.equals("2")) {
               ty = "2 = Seminar";
           } else {
               ty = this.type;
           }
   
           System.out.println("\n#############################################################################");
           System.out.println("####                       Success Make Reservation                      ####");
           System.out.println("####---------------------------------------------------------------------####");
           System.out.println("####   Venue ID             :" + bookings.get(bookings.size() - 1).getVenueId());
           System.out.println("####   Name                 :" + name);
           System.out.println("####   Phone                :" + this.phone);
           System.out.println("####   Type                 :" + ty);
           System.out.println("####   Reservation Date     :" + this.reservationDateString);
           System.out.println("####   Reservation Time     :" + rt);
           System.out.println("#############################################################################\n\n\n");
   
           return bookings;
       }
   
       private boolean is_valid_date_format(String date_string) {
           return date_string.matches("\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1])");
       }
   
       private boolean is_date_before_today(String date_string) {
           String today = java.time.LocalDate.now().toString();
           java.time.LocalDate input_date = java.time.LocalDate.parse(date_string);
           java.time.LocalDate today_date = java.time.LocalDate.parse(today);
   
           return input_date.isAfter(today_date);
       }
   
       void findReservation(List<Booking> bookings) {
           System.out.println("Please input Venue Id:");
           int find = Integer.parseInt(scanner.nextLine());
           int count = 0;
           for (int key = 0; key < bookings.size(); key++) {
               Booking val = bookings.get(key);
               String rt = (val.getTime().equals("A")) ? "A = for 8:00 am until 6:00 pm" : "B = for 6:00 pm until 11:00 pm";
               String ty;
               if (val.getType().equals("1")) {
                   ty = "1 = Conference";
               } else if (val.getType().equals("2")) {
                   ty = "2 = Seminar";
               } else {
                   ty = val.getType();
               }
   
               if (find == val.getVenueId()) {
                   System.out.println("\n#############################################################################");
                   System.out.println("####                                   Found                             ####");
                   System.out.println("####---------------------------------------------------------------------####");
                   System.out.println("####   Venue ID             :" + val.getVenueId());                       
                   System.out.println("####   Name                 :" + val.getName());
                   System.out.println("####   Phone                :" + val.getPhone());
                   System.out.println("####   Type                 :" + ty);
                   System.out.println("####   Reservation Date     :" + val.getReservationDate());
                   System.out.println("####   Reservation Time     :" + rt);
                   System.out.println("#############################################################################\n\n\n\n");
   
                   count++;
               }
           }
           if (count == 0) {
               System.out.println("\n#############################################################################");
               System.out.println("####         Not Found. Maybe venue ID " + find + " Available                      ####");
               System.out.println("####---------------------------------------------------------------------####\n\n\n\n");
           }
       }
   
       List<Booking> cancelReservation(List<Booking> bookings) {
           boolean loop = false;
           while (!loop) {
               System.out.println("\nPlease input type for cancel reservation");
               System.out.println("1 = cancel using ID");
               System.out.println("2 = cancel using Venue ID");
               String typeCancel = scanner.nextLine();
               if (typeCancel.equals("1")) {
                   bookings = cancelUsingID(bookings);
                   loop = true;
               } else if (typeCancel.equals("2")) {
                   bookings = cancelUsingVenue(bookings);
                   loop = true;
               } else {
                   System.out.println("Please choose 1 or 2 only");
               }
           }
   
           return bookings;
       }
   
       private List<Booking> cancelUsingID(List<Booking> bookings) {
           System.out.println("Please input ID for cancel reservation:");
           int id = Integer.parseInt(scanner.nextLine());
   
           int count = 0;
           for (int key = 0; key < bookings.size(); key++) {
               Booking val = bookings.get(key);
               String rt = (val.getTime().equals("A")) ? "A = for 8:00 am until 6:00 pm" : "B = for 6:00 pm until 11:00 pm";
   
               if ((key + 1) == id) {
                   System.out.println("Found ");
                   System.out.println("ID: " + (key + 1) + ", Venue: " + val.getVenueId() + ", Name: " + val.getName() + ", Phone: " + val.getPhone() +
                           ", Date: " + val.getReservationDate() + ", Time: " + rt);
                   System.out.println("Cancel This? Type 'Y' for Yes");
                   String answer = scanner.nextLine();
                   if (answer.equalsIgnoreCase("Y")) {
                       bookings.remove(key);
                       System.out.println("Successfully deleted\n\n\n\n");
                   } else {
                       System.out.println("Do Nothing\n\n\n\n");
                   }
   
                   count++;
               }
           }
   
           if (count == 0) {
               System.out.println("Nothing deleted\n");
           }
           System.out.println("------------\n\n\n\n");
           return bookings;
       }
   
       private List<Booking> cancelUsingVenue(List<Booking> bookings) {
           System.out.println("Please input Venue for cancel reservation:");
           int venueId = Integer.parseInt(scanner.nextLine());
   
           for (int key = 0; key < bookings.size(); key++) {
               Booking val = bookings.get(key);
               if (venueId == val.getVenueId() && val.getTime().equals("A")) {
                   System.out.println("Found " + venueId + " for A) 8:00 am - 6:00 pm. Cancel This? Type 'Y' ");
                   String answer = scanner.nextLine();
                   if (answer.equalsIgnoreCase("Y")) {
                       bookings.remove(key);
                       System.out.println("Successfully deleted\n\n\n\n");
                   } else {
                       System.out.println("Do Nothing\n\n\n\n");
                   }
               }
               if (venueId == val.getVenueId() && val.getTime().equals("B")) {
                   System.out.println("Found " + venueId + " for B) 6:00 pm - 11:00 pm. Cancel This? Type 'Y' ");
                   String answer = scanner.nextLine();
                   if (answer.equalsIgnoreCase("Y")) {
                   bookings.remove(key);
                   System.out.println("Successfully deleted\n\n\n\n");
                   } else {
                   System.out.println("Do Nothing\n\n\n\n");
                   }
                   }
                   }
   
                   System.out.println("------------\n\n\n");
                   return bookings;
               }
   
      
       public List<Booking> getBookings() {
           return bookings;
       }
           }
   
           class Booking {
           private int venueId;
           private String name;
           private String phone;
           private String type;
           private String reservationDate;
           private String time;
   
           public Booking(int venueId, String name, String phone, String type, String reservationDate, String time) {
       this.venueId = venueId;
       this.name = name;
       this.phone = phone;
       this.type = type;
       this.reservationDate = reservationDate;
       this.time = time;
   }
   
   
   public int getVenueId() {
       return venueId;
   }
   
   public String getName() {
       return name;
   }
   
   public String getPhone() {
       return phone;
   }
   
   public String getType() {
       return type;
   }
   
   public String getReservationDate() {
       return reservationDate;
   }
   
   public String getTime() {
       return time;
   }
   
}