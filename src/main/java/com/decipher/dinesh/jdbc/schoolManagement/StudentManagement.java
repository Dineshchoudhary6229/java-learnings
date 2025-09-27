// with jdbc and postgres sql student management

package com.decipher.dinesh.jdbc.schoolManagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;
import java.io.InputStream;

public class StudentManagement
{         //logger is used for info regarding debugging,error tracking
    private static final Logger log = LoggerFactory.getLogger(StudentManagement.class);    //creates logger instance for loging
    Scanner scanner = new Scanner(System.in);
    private final Properties props = new Properties();
    //used for application.properties file to load config setting from there like url,password, username

    //Database Connection starts here
    public StudentManagement()
    {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties"))//loads a resource file(application.properties )from class path as input stream
        {
            if (input == null)
            {
                log.error("Unable to find application.properties");
                throw new RuntimeException("application.properties file not found in resources folder");
            }
            props.load(input);
            // configuration properties are loaded from the input stream into the Properties object
            Class.forName(props.getProperty("jdbc.driver"));
            //the driver class for JDBC is loaded using the name provided in the properties file
        }
        catch (Exception e)
        {
            log.error("Error loading database configuration: ", e);
            throw new RuntimeException(e);
        }
    }
    private Connection getConnection() throws SQLException
    //a method is defined to establish a database connection using the loaded configuration
    {
        String url = props.getProperty("jdbc.url");
        //the method retrieves the JDBC URL from the configuration properties
        String user = props.getProperty("jdbc.username");
        //the method gets the database username from the properties
        String password = props.getProperty("jdbc.password");
        return DriverManager.getConnection(url, user, password);
        //database connection is established
    }
    void addStudent(String name, int age, String grade)
    {             //for student
        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        //a parameterized SQL insert query is created for adding a student
        try
                (Connection conn = getConnection();   //a new database connection and PreparedStatement for the insert query are created
                 PreparedStatement ps = conn.prepareStatement(sql))     //ps prepare the query
        {
            ps.setString(1, name);         // fills/set placeholder for ? in name
            ps.setInt(2, age);             // fills/set placeholder for ? in age
            ps.setString(3, grade);
            ps.executeUpdate();                         // to execute the query
            System.out.println("Student added");
        }
        catch (SQLException e)
        {
            log.error("e: ", e);
        }
    }
    void updateStudent(int id, String name, int age, String grade)
    {
        String sql = "UPDATE students SET name=?, age=?, grade=? WHERE id=?";
        try
                (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, grade);
            ps.setInt(4, id);
            int rows = ps.executeUpdate(); //the update query is executed and the number of affected rows is captured.
            System.out.println(rows > 0 ? " Student updated." : " Student not found.");
        }
        catch (SQLException e)
        {
            log.error("e: ", e);
        }
    }
    void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try
                (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? " Student deleted." : " Student not found.");
        }
        catch (SQLException e)
        {
            log.error("e: ", e);
        }
    }
    void viewAllStudents() {
        String sql = "SELECT * FROM students";
        try
                (Connection conn = getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql))
        {
            while (rs.next()) // the ResultSet cursor advances to the next record
            {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Grade: " + rs.getString("grade"));
            }
        }
        catch (SQLException e)
        {
            log.error("e: ", e);
        }
    }
    // Teacher
    void addTeacher(String name, String subject)
    {
        String sql = "INSERT INTO teachers (name, subject) VALUES (?, ?)";
        try
                (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, name);
            ps.setString(2, subject);
            ps.executeUpdate();
            System.out.println(" Teacher added.");
        }
        catch (SQLException e)
        {
            log.error("e: ", e);
        }
    }
    void viewAllTeachers() {
        String sql = "SELECT * FROM teachers";
        try
                (Connection conn = getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql))
        {
            while (rs.next())
            {
                //information is retrieved from ResultSet and displayed
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Subject: " + rs.getString("subject"));
            }
        }
        catch (SQLException e)
        {
            log.error("e: ", e);
        }
    }
    //a method to add a new course assigned to a teacher
    void addCourse(String name, int teacherId)
    {
        String sql = "INSERT INTO courses (name, teacher_id) VALUES (?, ?)";
        try
                (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, name);
            ps.setInt(2, teacherId);
            ps.executeUpdate();
            System.out.println(" Course added.");
        }
        catch (SQLException e)
        {
            log.error("e: ", e);
        }
    }
    void viewAllCourses() {
        String sql = "SELECT * FROM courses";
        try
                (Connection conn = getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql))
        {
            while (rs.next())
            {
                //course information is read from the ResultSet
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Teacher ID: " + rs.getInt("teacher_id"));
            }
        }
        catch (SQLException e)
        {
            log.error("e: ", e);
        }
    }
    //a method to enroll a student to a course
    void enrollStudent(int studentId, int courseId)
    {
        String sql = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";
        try
                (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);//placeholders are set for student ID and course ID
            ps.executeUpdate();  //the enrollment is registered in the database
            System.out.println(" Student enrolled in course.");
        }
        catch (SQLException e)
        {
            log.error("e: ", e);
        }
    }
    void viewAllEnrollments()
    {
        String sql = "SELECT * FROM enrollments";
        try
                (Connection conn = getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql))  //executed query for enrollments is created
        {
            while (rs.next())
            {
                System.out.println("Student ID: " + rs.getInt("student_id") +
                        ", Course ID: " + rs.getInt("course_id"));
            }
        }
        catch (SQLException e)
        {
            log.error("e: ", e);
        }
    }
    //student's all functions start menu
    void studentMenu()
    {
        System.out.println("1. Add 2. Update 3. Delete 4. View All");
        int c = scanner.nextInt();
        scanner.nextLine();               // consume the leftover new line
        switch (c)                      //switch-case is used to select the operation menu chosen by the user
        {
            case 1 ->
            {
                System.out.print("Name: ");
                String name=scanner.nextLine();
                System.out.print("Age: ");
                int age=scanner.nextInt();
                scanner.nextLine();
                System.out.print("Grade: ");
                String grade=scanner.nextLine();
                addStudent(name,age,grade);
            }
            case 2 ->
            {
                System.out.print("ID: ");
                int id=scanner.nextInt();
                scanner.nextLine();
                System.out.print("Name: ");
                String name=scanner.nextLine();
                System.out.print("Age: ");
                int age=scanner.nextInt();
                scanner.nextLine();
                System.out.print("Grade: ");
                String grade=scanner.nextLine();
                updateStudent(id,name,age,grade);
            }
            case 3 ->
            {
                System.out.print("ID: ");
                int id=scanner.nextInt();
                deleteStudent(id);
            }
            case 4 -> viewAllStudents();
        }
    }
    //teacher all functions start menu
    void teacherMenu()
    {
        System.out.println("1. Add 2. View All");
        int c = scanner.nextInt();
        scanner.nextLine();
        switch (c)
        {
            case 1 ->
            {
                System.out.print("Name: ");
                String name=scanner.nextLine();
                System.out.print("Subject: ");
                String subject=scanner.nextLine();
                addTeacher(name,subject);
            }
            case 2 -> viewAllTeachers();
        }
    }
    // course all functions start menu
    void courseMenu()
    {
        System.out.println("1. Add 2. View All");
        int c = scanner.nextInt();
        scanner.nextLine();
        switch (c)
        {
            case 1 ->
            {
                System.out.print("Name: ");
                String name=scanner.nextLine();
                System.out.print("Teacher ID: ");
                int tid=scanner.nextInt();
                addCourse(name,tid);
            }
            case 2 -> viewAllCourses();
        }
    }
    void enrollmentMenu()                   //menu for enrollment is provided, offering enroll and view options
    {
        System.out.println("1. Enroll Student 2. View All");
        int c = scanner.nextInt();
        switch (c)
        {
            case 1 ->
            {
                System.out.print("Student ID: ");
                int sid=scanner.nextInt();
                System.out.print("Course ID: ");
                int cid=scanner.nextInt();
                enrollStudent(sid,cid);
            }
            case 2 -> viewAllEnrollments();
        }
    }
    // first display to choose from all ,the main application menu is implemented, looping for user options
    void startMenu()
    {
        while (true)
        {
            System.out.println("\n Student Management ");
            System.out.println("1. Students  2. Teachers  3. Courses  4. Enrollments  5. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1 -> studentMenu();
                case 2 -> teacherMenu();
                case 3 -> courseMenu();
                case 4 -> enrollmentMenu();

                case 5 -> System.exit(0);
            }
        }
    }
    public static void main(String[] args)

    {

        StudentManagement object =new StudentManagement();
        object.startMenu();
        //the startMenu method is called using the object instance to begin the interactive menu
    }
}
