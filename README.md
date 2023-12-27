# Team-collaboration
A project called "A Venue Reservation System"
<br/><br/><br/>

### **i. Group Name** - Amira

  Group 5

<br/><br/>

### **ii. Group Member Details (Name & Matric No)** - Damia
1. Nabilah Binti Ahmad Nordin (2225498)
2. Siti Damia Binti Ab Razak (2210034)
3. ⁠Nur Amira Binti Azhari(2217176)
4. ⁠Diniy Binti Johan (2224132)

<br/><br/>

### **iii. The assign task for each group member** - Diniy

**LEADER:** Nabilah
1. Venue Details - Damia
2. Date & Time management - Nabilah
3. First come first serve basis implementation - Amira
4. Availability checking - Amira
5. Operating hours setting - Damia
6. Cancellation - Diniy

| Name        | Matric No    |  Task                                                                        |
| ----------- | -------------|----------------------------------------------------------------------------- |
| Nabilah     | 2225498      | - Date & time management <br/> - Date checking (booking must start from present - onwards)  <br/> - Two booking sessions (8am - 6pm & 6pm - 11pm)                                                                                              |
| Damia       | 2210034      | - Venue details <br/> - Phone number conditions ( 10 or 11 characters only) <br/> - Displaying main page to inform users regarding booking conditions                                                                           |
| Amira       | 2217176      | - Availability checking <br/> - Find reservations by entering venue ID <br/> - Handle overlapping bookings                                   |
| Diniy       | 2224132      | - Booking cancellation <br/> - Fee (implementation of inheritance) <br/> - Calculate fee (RM10/hour)                                                                  |


<br/><br/>


### **iv. Brief Description of the case study** - Nabilah 

- *Title & Requirements*: 
The system is designed for a building with 30 venues suitable for conferences and seminars. It must ensure no scheduling conflicts occur, operating on a first-come, first-served basis, only available venues can be reserved, the booking can also be cancelled and the fee will be displayed as well. The venues are open from 8 am to 11 pm.

- *Development Criteria*: 
The system should be built with separate classes using encapsulation, inheritance if possible, and use an ArrayList or an Array for data storage. Date and time management is critical, and the system should include error checking for both input and output.

- *Session for our system*:
Our system have two session which is session A and B . A is from 8.00 am - 6.00 pm and B is from 6.00 pm- 11.00 pm

<br/><br/>

### **v. Class Diagram**
Consisting has-a(composition) and is-a(inheritance) relationship** - all members 

*steady but surely*

<br/><br/>

### **vi. UML Diagram**

![Reference Image](/Team-collaboration/Output/UML%20DIAGRAM.png) 

<br/><br/>

### **vii. Sample output**
<br/>
Main page

![Reference Image](/Team-collaboration/Output/mp.png)
<br/><br/>

Option 1: View unavailable venues

![Reference Image](/Team-collaboration/Output/opt1bfr.png)
> Before reservation

<br/>

Option 2: Make Reservation

![Reference Image](/Team-collaboration/Output/opt2default.png)
>Default display

<br/>

Option 2: Make Reservation

![Reference Image](/Team-collaboration/Output/opt2mkeres.png)
>Make reservation

<br/>

Option 2: Make Reservation

![Reference Image](/Team-collaboration/Output/opt2invdate.png)
>Invalid date

<br/>

Option 2: Make Reservation

![Reference Image](/Team-collaboration/Output/opt2error.png)
>Same venue, date, time etc. Display error

<br/>

Option 2: Make Reservation

![Refrence Image](/Team-collaboration/Output/opt2cancel.png)
>Cancel - it will display the main page once cancelled

<br/>

Option 1: View unavailable venues

![Reference Image](/Team-collaboration/Output/opt1aftres.png)
>After reservations

<br/> 

Option 3: Find reservation(s)

![Reference IMage](/Team-collaboration/Output/opt3.png)
>Display the reservations for matching IDs

<br/>

Option 4: Cancel reservation

![Reference IMage](/Team-collaboration/Output/opt4usingID.png)
>Using ID

<br/>

Option 4: Cancel reservation

![Refrence Image](/Team-collaboration/Output/opt4usingvenueID.png)
>Using venue ID

<br/>

Option 1: View unavailable venues

![Reference Image](/Team-collaboration/Output/opt1check.png)
>Check effectiveness after cancellations by choosing option 1. Cancellation Successful

<br/><br/>

### **vii. References**
 
  * Reservation system (stores an array list and has multiple methods). (2019). Stakeoverflow. https://stackoverflow.com/questions/53381640/im-trying-to-write-a-class-that-stores-an-array-list-and-has-multiple-methods

  * date is after today java. (2020). Stackoverflow. https://stackoverflow.com/questions/36839961/how-to-check-if-a-date-is-after-today-java

  * W3Schools. (n.d.). Java date and time. W3Schools Online Web Tutorials. https://www.w3schools.com/java/java_date 