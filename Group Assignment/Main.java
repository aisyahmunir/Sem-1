package appoinment;

//import java.math.BigInteger;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Main {
    
    //variable for SQL connection

    public static String connectionURL = "jdbc:sqlserver://115.132.228.252:1043;databaseName=iHealth;user=ihealth;password=1234";
    //public IP address is dynamic IP, everyday changes. Request me for the public IP one time per day.
    
    //Main method
    public static void main(String[] args) {
        firstMenu();
    }

    //Other methods
    public static void firstMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\tWelcome to iHealth\n\n");
        System.out.println("1. Login (for patient side)");
        System.out.println("2. Login (for clinic side)");
        System.out.println("3. Register");

        System.out.println("\nSelect an option: ");
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

    public static void loginPageForPatient() {
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
            loginPageForPatient();
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
    
    public static void loginPageForEmployee() {
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
            loginPageForEmployee();
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

    public static void register() {
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

        try ( Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
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

    public static void patientMenu(int userID) {
        Scanner sc = new Scanner(System.in);
        System.out.println("User ID: " + userID);
        System.out.println("Welcome to iHealth");
        System.out.println("1. My Profile");
        System.out.println("2. My Appointment");
        System.out.println("3. Make Appointment");
        System.out.println("4. Logout");
        System.out.println("\nSelect an option: ");
        int optionMainMenu = sc.nextInt();
        sc.nextLine();
        switch (optionMainMenu) {
            case 1:
                
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                System.out.println("You have logged out.");
                firstMenu();
                break;
        }
    }
    
    public static void employeeMenu(int userID) {
        Scanner sc = new Scanner(System.in);
        System.out.println("User ID: " + userID);
        System.out.println("Welcome to iHealth");
        System.out.println("1. My Profile");
        System.out.println("2. Appointment Listing");
        System.out.println("3. Set opening/closing time");
        System.out.println("4. Logout");
        System.out.println("Select an option: ");
        int optionMainMenu = sc.nextInt();
        sc.nextLine();
        switch (optionMainMenu) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                System.out.println("You have logged out.");
                firstMenu();
                break;
        }
    }
    
    public static void MakeAppointment(int userID){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter Date (31/12/20): ");
        String date = sc.nextLine();
        System.out.println("Enter Time (24 hours): ");
        int time = sc.nextInt();
        
        String[] split = date.split("/");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);
        
        System.out.println(a + " " +  b + " " + c);
        
          String connectionUrl = connectionURL;
          
         try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM db_owner.Appointments WHERE ( day = ' " + a + " ' ) AND ( month = ' " + b + " ' ) AND (year = ' " + c + " ' ) AND (start_time = ' " + time + " ' ) AND (end_time = ' " + time+1 + " ') " );

            // Iterate through the data in the result set and display it.
            boolean app = false;
            
            if (rs.next()) {
                app = true;
            }
             System.out.println(app);
            
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void MyAppoinment(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Details : ");
        System.out.println("2. Edit : ");
        System.out.println("3. Delete : ");
        System.out.println("4. Go back to Main Menu\n");
        
        System.out.println("Select your option : ");
        int optionMainMenu = sc.nextInt();
        sc.nextLine();
        
        switch(optionMainMenu) {
            case 1:
                
                break;
            case 2:
                break;
            case 3:
                deleteAppoinment();
                break;
            case 4:
                break;
        }
    }
    
    
    public static void deleteAppoinment() {
    
        Connection connection = null;
        Statement data = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:sqlserver://115.132.228.252:1043;databaseName=iHealth;user=ihealth;password=1234");
             
            data = connection.createStatement();
            data.execute("DELETE FROM db_owner.Appoinments WHERE ID >= 1");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {   
                data.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
