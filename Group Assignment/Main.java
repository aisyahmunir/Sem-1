
//import java.math.BigInteger;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
//import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

    //variable for SQL connection
    public static String connectionURL = "jdbc:sqlserver://115.132.249.235:1043;databaseName=iHealth;user=ihealth;password=1234";
    //public IP address is dynamic IP, everyday changes. Request me for the public IP one time per day.

    //Main method
    public static void main(String[] args) throws ParseException {
        firstMenu();
    }

    //Other methods
    public static void firstMenu() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to iHealth");
        System.out.println("1. Login (for patient side)");
        System.out.println("2. Login (for clinic side)");
        System.out.println("3. Register");

        System.out.println("Select an option: ");
        int optionLoginMenu = sc.nextInt();
        sc.nextLine();
        switch (optionLoginMenu) {
            case 1:
                loginPageForPatient();
                break;
            case 2:
                loginPageForEmployee();
                break;
            case 3:
                register();
                break;
        }
    }

    public static void loginPageForPatient() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Patient Login");
        System.out.println("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        boolean auth = loginAuthForPatient(username, password);
        int userID = getUserID(username, password);
        if (auth == true) {
            System.out.println("Login Successful");
            patientMenu(userID);
        } else {
            System.out.println("Username or Password is incorrect");
            System.out.println("Back to Menu? (y/n)");
            String option = sc.next();
            if(option.equals("y")){
                firstMenu();
            }else{
                loginPageForPatient();
            }
        }

    }

    public static boolean loginAuthForPatient(String username, String password) {
        boolean auth = false;
        // Create a variable for the connection string.
        String connectionUrl = connectionURL;

        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM db_owner.Users WHERE user_type = 'patient'";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                if (rs.getString("name").equals(username) && rs.getString("password").equals(password)) {
                    auth = true;
                    break;
                }
            }
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        return auth;
    }

    public static void loginPageForEmployee() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Employee Login");
        System.out.println("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        boolean auth = loginAuthForEmployee(username, password);
        int userID = getUserID(username, password);
        if (auth == true) {
            System.out.println("Login Successful");
            employeeMenu(userID);
        } else {
            System.out.println("Username or Password is incorrect");
            System.out.println("Back to Menu? (y/n)");
            String option = sc.next();
            if(option.equals("y")){
                firstMenu();
            }else{
                loginPageForEmployee();
            }
        }

    }

    public static boolean loginAuthForEmployee(String username, String password) {
        boolean auth = false;
        // Create a variable for the connection string.
        String connectionUrl = connectionURL;

        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM db_owner.Users WHERE user_type = 'employee'";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                if (rs.getString("name").equals(username) && rs.getString("password").equals(password)) {
                    auth = true;
                    break;
                }
            }
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        return auth;
    }

    public static int getUserID(String username, String password) {
        int userID = 0;
        // Create a variable for the connection string.
        String connectionUrl = connectionURL;

        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM db_owner.Users";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                if (rs.getString("name").equals(username) && rs.getString("password").equals(password)) {
                    userID = rs.getInt("user_id");
                    break;
                }
            }
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        if (userID > 0) {
            return userID;
        } else {
            userID = 0;
        }
        return userID;
    }

    public static int getLastUserID() {
        int lastID = 0;
        // Create a variable for the connection string.
        String connectionUrl = connectionURL;

        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM db_owner.Users WHERE user_id=(SELECT max(user_id) FROM db_owner.Users);");

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                lastID = rs.getInt("user_id");
            }
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        return lastID;
    }

    public static void register() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Registration");
        System.out.println("Enter your username: ");
        String username = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        System.out.println("Are you patient or employee(P/E): ");
        String userType = sc.nextLine();
        System.out.println("Enter your phone number: ");
        String phone = sc.nextLine();
        System.out.println("Enter your NRIC: ");
        String NRIC = sc.nextLine();
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        System.out.println("Enter your home address: ");
        String address = sc.nextLine();
        int lastUserID = getLastUserID();
        if (userType.equals("P")) {
            userType = "patient";
        } else if (userType.equals("E")) {
            userType = "employee";
        }

        // Create a variable for the connection string.
        String connectionUrl = connectionURL;

        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            stmt.executeUpdate("INSERT INTO db_owner.Users (user_type, name, password, phone, NRIC, email, home_address)" + "VALUES ('" + userType + "', '" + username + "', '" + password + "', '" + phone + "', '" + NRIC + "', '" + email + "', '" + address + "')");
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        firstMenu();
    }

    /*
    //convert password to Md5
    public static String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value 
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
     */
    public static void patientMenu(int userID) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("Welcome to iHealth");
        System.out.println("1. My Appointment");
        System.out.println("2. Make Appointment");
        System.out.println("3. Logout");
        System.out.println("Select an option: ");
        int optionMainMenu = sc.nextInt();
        sc.nextLine();
        switch (optionMainMenu) {
            case 1: {
                int appID = 0;
                MyAppointment(userID, appID);
            }
            break;

            case 2:
                MakeAppointment(userID);
                break;
            case 3:
                System.out.println("You have logged out.");
                firstMenu();
                break;
        }
    }

    public static void employeeMenu(int userID) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("Welcome to iHealth");
        System.out.println("1. Appointment Listing");
        System.out.println("2. Set opening/closing time");
        System.out.println("3. Logout");
        System.out.println("Select an option: ");
        int optionMainMenu = sc.nextInt();
        sc.nextLine();
        switch (optionMainMenu) {
            case 1:
                ManageAppointmentListing(userID);
                break;
            case 2:
                System.out.println("Your schedule");
                getOpen_Close(userID);
                break;
            case 3:
                System.out.println("You have logged out.");
                firstMenu();
                break;
        }
    }

    //MyAppoinment section
    public static void MyAppointment(int userID, int appID) throws ParseException {

        Scanner sc = new Scanner(System.in);
        System.out.println("\t\tMy Appoinment");
        System.out.println("---------------------------------------------------");
        System.out.println("Appointment List");
        DetailsAppointment(userID, appID);

        System.out.println("Select Option :");
        System.out.println("1. Delete Appoinment");
        System.out.println("2. Back to Main Menu");
        int optionMainMenu = sc.nextInt();
        sc.nextLine();
        switch (optionMainMenu) {
            case 1:
                DetailsThisAppointment(userID, appID);// check appoinment list
                break;
            case 2:
                patientMenu(userID); // back to patient menu
                break;

        }

    }
    //option details appointment

    public static void DetailsAppointment(int userID, int appID) throws ParseException {
        String connectionUrl = connectionURL;

        //get details appointment that have been made by user 
        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM db_owner.Appointments WHERE user_id = '" + userID + "'";      // Iterate through the data appointment of that particular user.
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            if (rs.next() == false) {
                System.out.println("You haven't make an appointment.\n");
            } else {
                do {
                    System.out.println("Appointment ID :" + rs.getString("id") + "\n" + rs.getString("day") + " / " + rs.getString("month") + " / " + rs.getString("year") + "\nTime: " + rs.getString("start_time") + "\nExpected End: " + rs.getString("end_time") + "\n");
                } while (rs.next());
            }
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //option details appointment
    public static void DetailsThisAppointment(int userID, int appID) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String connectionUrl = connectionURL;
        System.out.println("Enter Appointment ID:");
        appID = sc.nextInt();
        //sc.next();

        //get specific details appointment that have been chosen by user 
        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM db_owner.Appointments WHERE id = '" + appID + "'";      // Iterate through the data appointment to find the id appointment..
            ResultSet rs = stmt.executeQuery(SQL);
            System.out.println("");
            System.out.println("Details Appointment:\n ");

            // Iterate through the data in the result set and display it.
            if (rs.next() == false) {
                System.out.println("You haven't make an appointment.");

            } else {
                do {
                    System.out.println(rs.getString("day") + " / " + rs.getString("month") + " / " + rs.getString("year") + "\nTime: " + rs.getString("start_time") + "\nExpected End: " + rs.getString("end_time") + "\n");
                } while (rs.next());
                //user get option to delete the appointment
                System.out.println("\nSelect your option: \n");
                System.out.println("1. Delete Appointment");
                System.out.println("2. Back to Menu");

                int optionMenu = sc.nextInt();
                sc.nextLine();
                switch (optionMenu) {
                    case 1:
                        deleteAppointment(userID);
                        break;
                    case 2:
                        patientMenu(userID);
                        break;
                }

            }
        } catch (SQLException e) {    // Handle any errors that may have occurred.
            e.printStackTrace();
        }

    }

    // Delete appoinment section
    public static void deleteAppointment(int userID) throws ParseException {
        String connectionUrl = connectionURL;
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("Enter Appointment ID:");
        int appID = sc.nextInt();
        try {
            // Get connection to database
            Connection con = DriverManager.getConnection(connectionURL);
            Statement stat = con.createStatement(); //create a statement

            // Delete appoinment that the user has made in the database, link with appoinment ID given
            String query = "DELETE FROM db_owner.Appointments WHERE id ='" + appID + "'";
            stat.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Appoinment Deleted\n"); //notice deleting successful
        DetailsAppointment(userID, appID);
        // After deleting, user will automatically go back to list of appoinment
    }

    //Make Appointments methods
    public static void MakeAppointment(int userID) throws ParseException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Date (dd/mm/yyyy): ");
        String date = sc.nextLine();
        System.out.println("Enter Time (hh:mm): ");
        String time = sc.nextLine();
        String[] split = date.split("/");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);

        //check available date and time
        boolean hasAvailable = hasAvailable(date, time);
        if (hasAvailable == true) {
            //check If any appointment clash
            boolean hasAppointment = hasAppointment(a, b, c, time);
            if (hasAppointment == true) {
                System.out.println("Other user has made appointment at that time.");
                makeSuggestion(a, b, c, time, userID);
            } else {
                System.out.println("Making your Appointment...");
                //Generate endTime
                String string1 = time;
                Date temp = new SimpleDateFormat("HH:mm").parse(string1);
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTime(temp);
                calendar1.add(Calendar.HOUR, 1);
                DateFormat df = new SimpleDateFormat("HH:mm");
                Date endTime = calendar1.getTime();
                String endTimeInString = df.format(endTime);

                //insert appointment           
                String connectionUrl = connectionURL;

                try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
                    stmt.executeUpdate("INSERT INTO db_owner.Appointments (user_id, day, month, year, start_time, end_time)" + "VALUES ('" + userID + "', '" + a + "', '" + b + "', '" + c + "', '" + time + "', '" + endTimeInString + "')");

                } // Handle any errors that may have occurred.
                catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("Appointment made.");
                patientMenu(userID);
            }
        } else {
            System.out.println("You cannot make appointment at this time.");
            patientMenu(userID);
        }
    }

    public static boolean hasAvailable(String date, String time) throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);
        String connectionUrl = connectionURL;

        Date temp = new SimpleDateFormat("HH:mm").parse(time);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(temp);
        c1.add(Calendar.HOUR, 1);
        DateFormat df = new SimpleDateFormat("HH:mm");
        Date endTime = c1.getTime();
        String endTimeInString = df.format(endTime);
        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM db_owner.Available_time");
            while (rs.next()) {
                String openingTime = rs.getString("opening_time");
                String closingTime = rs.getString("closing_time");
                boolean openingTimeInRange = false;
                boolean closingTimeInRange = false;
                try {

                    String string1 = openingTime;
                    Date time1 = new SimpleDateFormat("HH:mm").parse(string1);
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.setTime(time1);
                    calendar1.add(Calendar.DATE, 1);

                    String string2 = closingTime;
                    Date time2 = new SimpleDateFormat("HH:mm").parse(string2);
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.setTime(time2);
                    calendar2.add(Calendar.DATE, 1);

                    String inputTime = time;
                    Date d = new SimpleDateFormat("HH:mm").parse(inputTime);
                    Calendar calendar3 = Calendar.getInstance();
                    calendar3.setTime(d);
                    calendar3.add(Calendar.DATE, 1);

                    Date x = calendar3.getTime();
                    if ((x.equals(calendar1.getTime())) || (x.after(calendar1.getTime()) && x.before(calendar2.getTime()))) {
                        //checkes whether the current time is between 14:49:00 and 20:11:13.
                        openingTimeInRange = true;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //check endTime
                try {
                    String string3 = openingTime;
                    Date time3 = new SimpleDateFormat("HH:mm").parse(string3);
                    Calendar calendar4 = Calendar.getInstance();
                    calendar4.setTime(time3);
                    calendar4.add(Calendar.DATE, 1);

                    String string4 = closingTime;
                    Date time4 = new SimpleDateFormat("HH:mm").parse(string4);
                    Calendar calendar5 = Calendar.getInstance();
                    calendar5.setTime(time4);
                    calendar5.add(Calendar.DATE, 1);

                    String inputTime = endTimeInString;
                    Date d = new SimpleDateFormat("HH:mm").parse(inputTime);
                    Calendar calendar6 = Calendar.getInstance();
                    calendar6.setTime(d);
                    calendar6.add(Calendar.DATE, 1);

                    Date x = calendar6.getTime();
                    if ((x.equals(calendar5.getTime())) || (x.after(calendar4.getTime()) && x.before(calendar5.getTime()))) {
                        //checkes whether the current time is between 14:49:00 and 20:11:13.
                        closingTimeInRange = true;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (openingTimeInRange == true && closingTimeInRange == true) {
                    return true;
                }
            }
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean hasAppointment(int a, int b, int c, String time) {
        String connectionUrl = connectionURL;

        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM db_owner.Appointments");

            // Iterate through the data in the result set and display it.
            int day, month, year;
            String startTime, endTime;
            int timeInHour = Integer.parseInt(time.substring(0, 2));
            int timeEndInHour = timeInHour + 1;
            String timeEnd = timeEndInHour + time.substring(2);
            while (rs.next()) {
                day = rs.getInt("day");
                month = rs.getInt("month");
                year = rs.getInt("year");
                startTime = rs.getString("start_time");
                endTime = rs.getString("end_time");
                //check startTime
                if (day == a && month == b && year == c) {
                    boolean startTimeInRange = false;
                    boolean endTimeInRange = false;
                    try {
                        String string1 = startTime;
                        Date time1 = new SimpleDateFormat("HH:mm").parse(string1);
                        Calendar calendar1 = Calendar.getInstance();
                        calendar1.setTime(time1);
                        calendar1.add(Calendar.DATE, 1);

                        String string2 = endTime;
                        Date time2 = new SimpleDateFormat("HH:mm").parse(string2);
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.setTime(time2);
                        calendar2.add(Calendar.DATE, 1);

                        String inputTime = time;
                        Date d = new SimpleDateFormat("HH:mm").parse(inputTime);
                        Calendar calendar3 = Calendar.getInstance();
                        calendar3.setTime(d);
                        calendar3.add(Calendar.DATE, 1);

                        Date x = calendar3.getTime();
                        if ((x.equals(calendar1.getTime())) || (x.after(calendar1.getTime()) && x.before(calendar2.getTime()))) {
                            //checkes whether the current time is between 14:49:00 and 20:11:13.
                            startTimeInRange = true;
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    //check endTime
                    try {
                        String string3 = startTime;
                        Date time3 = new SimpleDateFormat("HH:mm").parse(string3);
                        Calendar calendar4 = Calendar.getInstance();
                        calendar4.setTime(time3);
                        calendar4.add(Calendar.DATE, 1);

                        String string4 = endTime;
                        Date time4 = new SimpleDateFormat("HH:mm").parse(string4);
                        Calendar calendar5 = Calendar.getInstance();
                        calendar5.setTime(time4);
                        calendar5.add(Calendar.DATE, 1);

                        String inputTime = timeEnd;
                        Date d = new SimpleDateFormat("HH:mm").parse(inputTime);
                        Calendar calendar6 = Calendar.getInstance();
                        calendar6.setTime(d);
                        calendar6.add(Calendar.DATE, 1);

                        Date x = calendar6.getTime();
                        if ((x.after(calendar4.getTime()) && x.before(calendar5.getTime()))) {
                            //checkes whether the current time is between 14:49:00 and 20:11:13.
                            endTimeInRange = true;
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (endTimeInRange == true || startTimeInRange == true) {
                        return true;
                    }
                }
            }
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void makeSuggestion(int a, int b, int c, String time, int userID) throws ParseException {
        String date = a + "/" + b + "/" + c;
        int plusCounter = 1, minusCounter = -1;
        String accept = "", generatedTime = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Finding available time...");
        Random r = new Random();
        int seq = r.nextInt(2);
        loop1:
        while (true) {
            String time1 = "";
            DateFormat df = new SimpleDateFormat("HH:mm");
            DateFormat df2 = new SimpleDateFormat("HH:mm");
            Date temp = df.parse(time);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(temp);
            calendar1.add(Calendar.MINUTE, plusCounter);
            Date currentTime = calendar1.getTime();
            String tempInString = df2.format(currentTime);
            if (hasAvailable(date, tempInString) == true) {
                if (hasAppointment(a, b, c, tempInString) == false) {

                } else {
                    plusCounter++;
                }
            } else {
                plusCounter++;
            }
            String time2 = "";
            Date temp2 = df.parse(time);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(temp2);
            calendar2.add(Calendar.MINUTE, minusCounter);
            Date currentTime2 = calendar2.getTime();
            String tempInString2 = df2.format(currentTime2);

            if (hasAvailable(date, tempInString2) == true) {
                if (hasAppointment(a, b, c, tempInString2) == false) {
                    time = findClosestTime(currentTime, currentTime2, temp, date);
                    break;
                } else {
                    minusCounter--;
                }
            } else {
                minusCounter--;
            }

        }

        System.out.println("Appointment starting at " + time);
        System.out.println("Make Appointment? (y/n)");
        accept = sc.nextLine();

        if (accept.equals("y")) {
            System.out.println("Making your Appointment...");
            //Generate endTime
            String string1 = time;
            Date temp = new SimpleDateFormat("HH:mm").parse(string1);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(temp);
            calendar1.add(Calendar.HOUR, 1);
            DateFormat df = new SimpleDateFormat("HH:mm");
            Date endTime = calendar1.getTime();
            String endTimeInString = df.format(endTime);

            //insert appointment           
            String connectionUrl = connectionURL;

            try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
                stmt.executeUpdate("INSERT INTO db_owner.Appointments (user_id, day, month, year, start_time, end_time)" + "VALUES ('" + userID + "', '" + a + "', '" + b + "', '" + c + "', '" + time + "', '" + endTimeInString + "')");

            } // Handle any errors that may have occurred.
            catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Appointment made.");
            patientMenu(userID);

        } else {
            //return to patient menu
            System.out.println("You have rejected time suggested by the system. Going back to main menu...");
            patientMenu(userID);
        }
    }

    public static String findClosestTime(Date a, Date b, Date time, String date) throws ParseException {

        DateFormat df2 = new SimpleDateFormat("HH:mm");

        long diffInMillies1 = a.getTime() - time.getTime();
        long diffSec1 = diffInMillies1 / 1000 / 60;
        long diffInMillies2 = time.getTime() - b.getTime();
        long diffSec2 = diffInMillies2 / 1000 / 60;
        if (diffSec1 < diffSec2) {
            String time1InString = df2.format(a);
            //System.out.println(time1InString);
            return time1InString;
        } else {
            String time2InString = df2.format(b);
            //System.out.println(time2InString);
            return time2InString;
        }
    }

    //Appointment Listing (Clinic side) methods
    public static void ManageAppointmentListing(int userID) throws ParseException {
        Scanner sc = new Scanner(System.in);
        LocalDate date = LocalDate.now();
        String datestr = date.toString();
        try ( Connection con = DriverManager.getConnection(connectionURL);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM db_owner.Appointments WHERE ( (year>" + date.getYear() + ") OR (year=" + date.getYear() + " AND month>" + date.getMonthValue() + ") OR (year=" + date.getYear() + " AND month=" + date.getMonthValue() + " AND (day>" + date.getDayOfMonth() + " OR day=" + date.getDayOfMonth() + ")));";
            ResultSet rs = stmt.executeQuery(SQL);
            System.out.println("Appointment Listing");
            if (rs.next() == false) {
                System.out.println("Don't have any appointment");
            } else {
                System.out.printf("%-4s %-11s %-6s %-6s\n", "", "Date", "Start", "End");
                do {
                    int i = 0;
                    System.out.printf("%-4s %-2s/%-2s/%-2s ", rs.getString("id"), rs.getString("day"), rs.getString("month"), rs.getString("year"));
                    System.out.printf("%-6s %-6s\n", rs.getString("start_time"), rs.getString("end_time"));
                    i++;
                } while (rs.next());
            }
            getExpiredAppointmentlistForClinic(userID);
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("0. Back to menu");
        System.out.println("Select an option: ");
        int option = sc.nextInt();
        sc.nextLine();
        if (option != 0) {
            getAppointmentDetailsForClinic(option, userID);
        } else {
            employeeMenu(userID);
        }

    }

    public static void getExpiredAppointmentlistForClinic(int userID) throws ParseException {
        Scanner sc = new Scanner(System.in);
        LocalDate date = LocalDate.now();
        String datestr = date.toString();
        try ( Connection con = DriverManager.getConnection(connectionURL);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM db_owner.Appointments WHERE NOT ( (year>" + date.getYear() + ") OR (year=" + date.getYear() + " AND month>" + date.getMonthValue() + ") OR (year=" + date.getYear() + " AND month=" + date.getMonthValue() + " AND (day>" + date.getDayOfMonth() + " OR day=" + date.getDayOfMonth() + ")));";
            ResultSet rs = stmt.executeQuery(SQL);
            System.out.println(" Expired Appointment Listing");
            if (rs.next() == false) {
                System.out.println("Don't have any Expired appointment");
            } else {
                System.out.printf("%-4s %-11s %-6s %-6s\n", "", "Date", "Start", "End");
                do {
                    int i = 0;
                    System.out.printf("%-4s %-2s/%-2s/%-2s ", rs.getString("id"), rs.getString("day"), rs.getString("month"), rs.getString("year"));
                    System.out.printf("%-6s %-6s\n", rs.getString("start_time"), rs.getString("end_time"));
                    i++;
                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void getAppointmentDetailsForClinic(int a, int userID) throws ParseException {
        Scanner sc = new Scanner(System.in);
        try ( Connection con = DriverManager.getConnection(connectionURL);  Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM db_owner.Appointments, db_owner.Users WHERE Users.user_id = Appointments.user_id AND Appointments.id='" + a + "'");
            int year = 0, month = 0, day = 0;
            String start_time = "", end_time = "", name = "", phone = "", nric = "", email = "", home_address = "";
            while (rs.next()) {
                year = rs.getInt("year");
                month = rs.getInt("month");
                day = rs.getInt("day");
                start_time = rs.getString("start_time");
                end_time = rs.getString("end_time");
                name = rs.getString("name");
                phone = rs.getString("phone");
                nric = rs.getString("NRIC");
                email = rs.getString("email");
                home_address = rs.getString("home_address");
            }
            String date = day + "/" + month + "/" + year;
            System.out.println("Appointment Details");
            System.out.println("Date: " + date + "\tTime: " + start_time + " - " + end_time);
            System.out.println("Patient Details");
            System.out.println("Name: " + name);
            System.out.println("Phone number: " + phone);
            System.out.println("NRIC: " + nric);
            System.out.println("Email: " + email);
            System.out.println("Home address: " + home_address);
            System.out.println("");
            System.out.println("1. Edit Appointment");
            System.out.println("2. Back to Appointment Listing");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    //Go to edit appointment page
                    editAppointment(userID, a);
                    break;
                case 2:
                    ManageAppointmentListing(userID);
                    break;
            }
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Edit appointment method
    public static void editAppointment(int userID, int id) throws ParseException {
        Scanner sc = new Scanner(System.in);
        //need to refer to appointments table for available time
        System.out.println("*Refer to appointments table and available time table*");
        System.out.println("Enter the year");
        String year = sc.next();
        System.out.println("Enter the month");
        String month = sc.next();
        System.out.println("Enter the day");
        String day = sc.next();
        System.out.println("Enter the start time (HH:mm)");
        String start_time = sc.next();

        DateFormat df = new SimpleDateFormat("HH:mm");
        Date temp = df.parse(start_time);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(temp);
        calendar1.add(Calendar.HOUR, 1);
        Date currentTime = calendar1.getTime();
        String end_time = df.format(currentTime);
        
        try ( Connection con = DriverManager.getConnection(connectionURL);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM db_owner.Appointments WHERE id = '" + id + "'";      // Iterate through the data appointment of that particular user.
            ResultSet rs = stmt.executeQuery(SQL);
            stmt.execute("UPDATE db_owner.Appointments SET year='" + year + "' WHERE id='" + id + "';");
            stmt.execute("UPDATE db_owner.Appointments SET month='" + month + "' WHERE id='" + id + "';");
            stmt.execute("UPDATE db_owner.Appointments SET day='" + day + "' WHERE id='" + id + "';");
            stmt.execute("UPDATE db_owner.Appointments SET start_time='" + start_time + "' WHERE id='" + id + "';");
            stmt.execute("UPDATE db_owner.Appointments SET end_time='" + end_time + "' WHERE id='" + id + "';");
            System.out.println("Appointment " + id + " editted");

        } catch (SQLException e) {
            System.out.println("Not available on this time");
            e.printStackTrace();
        }
        System.out.println("");
        ManageAppointmentListing(userID);
    }

    //Set opening/closing time methods
    public static void getOpen_Close(int userID) throws ParseException {
        Scanner sc = new Scanner(System.in);
        try ( Connection con = DriverManager.getConnection(connectionURL);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM db_owner.Available_time WHERE user_id ='" + userID + "'";
            ResultSet rs = stmt.executeQuery(SQL);
            // Iterate through the data in the result set and display it.
            if (rs.next() == false) {
                System.out.println("You haven't set your schedule. Set your schedule.");
                setOpen_Close(userID);
            } else {
                System.out.printf("%-4s %-10s %-11s\n", "", "Date", "Time of Slot");
                do {
                    System.out.printf("%-4s ", rs.getString("slot_num"));
                    System.out.printf("%-10s (%s-%s)\n", rs.getString("date"), rs.getString("opening_time"), rs.getString("closing_time"));
                } while (rs.next());
                System.out.println("Do you wish to edit your schedule?(Y/N)");
                if (sc.nextLine().equals("Y")) {
                    editOpen_Close(userID);
                } else {
                    employeeMenu(userID);
                }
            }
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editOpen_Close(int userID) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to delete your slot?(Y/N)");
        if (sc.nextLine().equals("Y")) {
            System.out.println("Which one?");
            int delSlot = sc.nextInt();
            try ( Connection con = DriverManager.getConnection(connectionURL);  Statement stmt = con.createStatement();) {
                stmt.execute("DELETE FROM db_owner.Available_time WHERE (user_id='" + userID + "' AND slot_num='" + delSlot + "');");
                System.out.println("Slot " + delSlot + " have deleted");
            } // Handle any errors that may have occurred.
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Which slot you wish to edit?(Enter \"0\" to skip)");
        int slot = sc.nextInt();
        if (slot != 0) {
            try ( Connection con = DriverManager.getConnection(connectionURL);  Statement stmt = con.createStatement();) {
                System.out.println("Enter opening time (HH:mm)");
                String open_time = sc.next();
                System.out.println("Enter closing time (HH:mm)");
                String close_time = sc.next();
                if (check_Availablity(userID, slot, open_time, close_time)) {
                    stmt.execute("UPDATE db_owner.Available_time SET opening_time='" + open_time + "' WHERE user_id='" + userID + "' AND slot_num='" + slot + "';");
                    stmt.execute("UPDATE db_owner.Available_time SET closing_time='" + close_time + "' WHERE user_id='" + userID + "' AND slot_num='" + slot + "';");
                } else {
                    System.out.println("Not available on that time (redirect to edit)");
                    editOpen_Close(userID);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Do you want to add a new slot?(Y/N)");
        if (sc.next().equals("Y")) {
            setOpen_Close(userID);
        }
        System.out.println("Enter \"0\" to go Menu or \"1\" to Edit Your schedule again(0/1)");
        if (sc.nextInt() == 1) {
            editOpen_Close(userID);
        } else {
            employeeMenu(userID);
        }
    }

    public static void setOpen_Close(int userID) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the date (DD/MM/YYYY)");
        String date = sc.nextLine();
        System.out.println("Enter the Opening time (HH:mm)");
        String openingTime = sc.next();
        System.out.println("Enter the Closing time (HH:mm)");
        String closingTime = sc.next();
        try ( Connection con = DriverManager.getConnection(connectionURL);  Statement stmt = con.createStatement();) {
            if (check_Availablity(userID, date, openingTime, closingTime)) {
                stmt.executeUpdate("INSERT INTO db_owner.Available_time (user_id,date,opening_time,closing_time)" + "VALUES ('" + userID + "', '" + date + "', '" + openingTime + "', '" + closingTime + "')");
            } else {
                System.out.println("Not available on that time (redirect to edit)");
                editOpen_Close(userID);
            }
            // Iterate through the data in the result set and display it.
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Enter \"0\" to exit to Menu or \"1\" to add another slot ");
        if (sc.nextInt() == 1) {
            setOpen_Close(userID);
        } else {
            employeeMenu(userID);
        }
    }

    public static boolean check_Availablity(int userID, int slot, String open_time, String close_time) {
        int num_Column = 0;
        String open_time2 = open_time.substring(0, 1) + open_time.substring(3, 4);
        String close_time2 = close_time.substring(0, 1) + close_time.substring(3, 4);
        String date = "";
        try ( Connection con = DriverManager.getConnection(connectionURL);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM db_owner.Available_time WHERE user_id='" + userID + "' AND slot_num='" + slot + "' AND date IS NOT NULL";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                date = rs.getString("date");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try ( Connection con = DriverManager.getConnection(connectionURL);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM db_owner.Available_time WHERE user_id='" + userID + "' AND NOT slot_num='" + slot + "' AND date='" + date + "'";
            ResultSet rs = stmt.executeQuery(SQL);
            for (int i = 0; rs.next(); i++) {
                num_Column++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[][] time = new String[num_Column][2];
        try ( Connection con = DriverManager.getConnection(connectionURL);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM db_owner.Available_time WHERE user_id='" + userID + "' AND NOT slot_num='" + slot + "' AND date='" + date + "'";
            ResultSet rs = stmt.executeQuery(SQL);
            for (int i = 0; rs.next(); i++) {
                String openTime = rs.getString("opening_time");
                String closeTime = rs.getString("closing_time");
                time[i][0] = openTime.substring(0, 1) + openTime.substring(3, 4);
                time[i][1] = closeTime.substring(0, 1) + closeTime.substring(3, 4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean available = true;
        for (int i = 0; i < num_Column; i++) {
                if ((Integer.parseInt(time[i][0]) <= Integer.parseInt(open_time2) && Integer.parseInt(time[i][1]) > Integer.parseInt(open_time2)) || (Integer.parseInt(time[i][0]) <= Integer.parseInt(close_time2) && Integer.parseInt(time[i][1]) > Integer.parseInt(close_time2)) || (Integer.parseInt(time[i][0]) > Integer.parseInt(open_time2) && Integer.parseInt(time[i][1]) < Integer.parseInt(close_time2))) {
                    available = false;
            }
        }
        return available;
    }

    public static boolean check_Availablity(int userID, String date, String open_time, String close_time) {
        int num_Column = 0;
        String open_time2 = open_time.substring(0, 1) + open_time.substring(3, 4);
        String close_time2 = close_time.substring(0, 1) + close_time.substring(3, 4);
        try ( Connection con = DriverManager.getConnection(connectionURL);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM db_owner.Available_time WHERE user_id='" + userID + "' AND date='" + date + "'";
            ResultSet rs = stmt.executeQuery(SQL);
            for (int i = 0; rs.next(); i++) {
                num_Column++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[][] time = new String[num_Column][2];
        try ( Connection con = DriverManager.getConnection(connectionURL);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM db_owner.Available_time WHERE user_id='" + userID + "' AND date='" + date + "'";
            ResultSet rs = stmt.executeQuery(SQL);
            for (int i = 0; rs.next(); i++) {
                String openTime = rs.getString("opening_time");
                String closeTime = rs.getString("closing_time");
                time[i][0] = openTime.substring(0, 1) + openTime.substring(3, 4);
                time[i][1] = closeTime.substring(0, 1) + closeTime.substring(3, 4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean available = true;
        for (int i = 0; i < num_Column; i++) {
                if ((Integer.parseInt(time[i][0]) <= Integer.parseInt(open_time2) && Integer.parseInt(time[i][1]) > Integer.parseInt(open_time2)) || (Integer.parseInt(time[i][0]) <= Integer.parseInt(close_time2) && Integer.parseInt(time[i][1]) > Integer.parseInt(close_time2)) || (Integer.parseInt(time[i][0]) > Integer.parseInt(open_time2) && Integer.parseInt(time[i][1]) < Integer.parseInt(close_time2))) {
                    available = false;
            }
        }
        return available;
    }

    /*public static String getDay(String Date) {
        String Day = "";
        String str[] = Date.split("/");  //return
        int day = 0;  //return
        String month = str[1];   //from data
        int date = Integer.parseInt(str[0]);   //from data
        int year = Integer.parseInt(str[2]);       //from data
        int ini_year = 2021;
        int diff = year - ini_year;
        int totalDay = 0;
        for (int i = 0; i < diff && ini_year < year; i++, ini_year++) {
            if (ini_year % 4 == 0) {
                totalDay += 366;
            } else {
                totalDay += 365;
            }
        }
        int firstDay = totalDay % 7 + 5;    //first day of year
        int jan = 31, feb = 28, march = 31, april = 30, may = 31, june = 30, july = 31, august = 31, september = 30, october = 31, november = 30, december = 31;
        if (year % 4 == 0) {
            feb++;
        }
        switch (month) {
            case "1":
                day = (firstDay + date - 1) % 7;
                break;
            case "2":
                day = (firstDay + jan + date - 1) % 7;
                break;
            case "3":
                day = (firstDay + jan + feb + date - 1) % 7;
                break;
            case "4":
                day = (firstDay + jan + feb + march + date - 1) % 7;
                break;
            case "5":
                day = (firstDay + jan + feb + march + april + date - 1) % 7;
                break;
            case "6":
                day = (firstDay + jan + feb + march + april + may + date - 1) % 7;
                break;
            case "7":
                day = (firstDay + jan + feb + march + april + may + june + date - 1) % 7;
                break;
            case "8":
                day = (firstDay + jan + feb + march + april + may + june + july + date - 1) % 7;
                break;
            case "9":
                day = (firstDay + jan + feb + march + april + may + june + july + august + date - 1) % 7;
                break;
            case "10":
                day = (firstDay + jan + feb + march + april + may + june + august + september + date - 1) % 7;
                break;
            case "11":
                day = (firstDay + jan + feb + march + april + may + june + august + september + october + date - 1) % 7;
                break;
            case "12":
                day = (firstDay + jan + feb + march + april + may + june + august + september + october + november + date - 1) % 7;
                break;
        }
        switch (day) {
            case 0:
                Day = "Sunday";
                break;
            case 1:
                Day = "Monday";
                break;
            case 2:
                Day = "Tuesday";
                break;
            case 3:
                Day = "Wednesday";
                break;
            case 4:
                Day = "Thursday";
                break;
            case 5:
                Day = "Friday";
                break;
            case 6:
                Day = "Saturday";
                break;

        }
        return Day;
    }*/

}
