// use of SLF4J and  Logback for logging.

package com.decipher.dinesh.jdbc.schoolManagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;
import java.io.InputStream;

public class StudentManagementWithLogger
{
    private static final Logger log = LoggerFactory.getLogger(StudentManagementWithLogger.class);
    Scanner scanner = new Scanner(System.in);
    private final Properties props = new Properties();

    //Database Connection starts here
    public StudentManagementWithLogger()
    {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties"))
        {
            if (input == null)
            {
                log.error("Unable to find application.properties");
                throw new RuntimeException("application.properties file not found in resources folder");
            }
            props.load(input);
            // Load driver class if necessary (optional for newer JDBC versions)
            Class.forName(props.getProperty("jdbc.driver"));
        }
        catch (Exception e)
        {
            log.error("Error loading database configuration: ", e);
            throw new RuntimeException(e);
        }
    }
    private Connection getConnection() throws SQLException {
        // Check environment variables first
        String envUrl = System.getenv("DB_URL");
        String envUser = System.getenv("DB_USER");
        String envPassword = System.getenv("DB_PASSWORD");

        String url = (envUrl != null) ? envUrl : props.getProperty("jdbc.url");
        String user = (envUser != null) ? envUser : props.getProperty("jdbc.username");
        String password = (envPassword != null) ? envPassword : props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, user, password);
    }


//    private Connection getConnection() throws SQLException
//    {
//        String url = props.getProperty("jdbc.postgresql://localhost:5432/schooldb");
//        String user = props.getProperty("jdbc.postgres");
//        String password = props.getProperty("jdbc.Dinesh6229");
//        return DriverManager.getConnection(url, user, password);
//    }

    void addStudent(String name, int age, String grade)
    {             //for student
        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        try
                (Connection conn = getConnection();   //conn connects to the database
                 PreparedStatement ps = conn.prepareStatement(sql))     //ps prepare the query
        {
            ps.setString(1, name);         // fills/set placeholder for ? in name
            ps.setInt(2, age);             // fills/set placeholder for ? in age
            ps.setString(3, grade);
            ps.executeUpdate();                         // to execute the query
            log.info("Student added successfully: Name={}, Age={}, Grade={}", name, age, grade);
        }
        catch (SQLException e)
        {
            log.error("Error adding student: Name={}, Age={}, Grade={}", name, age, grade, e);
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
            int rows = ps.executeUpdate();
            if (rows > 0) {
                log.info("Student updated: ID={}, Name={}, Age={}, Grade={}", id, name, age, grade);
            } else {
                log.warn("Student not found for update: ID={}", id);
            }
        }
        catch (SQLException e)
        {
            log.error("Error updating student: ID={}, Name={}, Age={}, Grade={}", id, name, age, grade, e);
        }
    }

    void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try
                (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                log.info("Student deleted: ID={}", id);
            } else {
                log.warn("Student not found for deletion: ID={}", id);
            }
        }
        catch (SQLException e)
        {
            log.error("Error deleting student: ID={}", id, e);
        }
    }

    void viewAllStudents() {
        String sql = "SELECT * FROM students";
        try
                (Connection conn = getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql))
        {
            log.info("Fetching all students from database");
            while (rs.next())
            {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Grade: " + rs.getString("grade"));
            }
        }
        catch (SQLException e)
        {
            log.error("Error fetching student list", e);
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
            log.info("Teacher added successfully: Name={}, Subject={}", name, subject);
        }
        catch (SQLException e)
        {
            log.error("Error adding teacher: Name={}, Subject={}", name, subject, e);
        }
    }

    void viewAllTeachers() {
        String sql = "SELECT * FROM teachers";
        try
                (Connection conn = getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql))
        {
            log.info("Fetching all teachers from database");
            while (rs.next())
            {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Subject: " + rs.getString("subject"));
            }
        }
        catch (SQLException e)
        {
            log.error("Error fetching teacher list", e);
        }
    }

    //Course
    void addCourse(String name, int teacherId)
    {
        String sql = "INSERT INTO courses (name, teacher_id) VALUES (?, ?)";
        try
                (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, name);
            ps.setInt(2, teacherId);
            ps.executeUpdate();
            log.info("Course added successfully: Name={}, TeacherID={}", name, teacherId);
        }
        catch (SQLException e)
        {
            log.error("Error adding course: Name={}, TeacherID={}", name, teacherId, e);
        }
    }

    void viewAllCourses() {
        String sql = "SELECT * FROM courses";
        try
                (Connection conn = getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql))
        {
            log.info("Fetching all courses from database");
            while (rs.next())
            {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Teacher ID: " + rs.getInt("teacher_id"));
            }
        }
        catch (SQLException e)
        {
            log.error("Error fetching course list", e);
        }
    }

    //Enrollment
    void enrollStudent(int studentId, int courseId)
    {
        String sql = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";
        try
                (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, studentId); ps.setInt(2, courseId);
            ps.executeUpdate();
            log.info("Student enrolled in course: StudentID={}, CourseID={}", studentId, courseId);
        }
        catch (SQLException e)
        {
            log.error("Error enrolling student: StudentID={}, CourseID={}", studentId, courseId, e);
        }
    }

    void viewAllEnrollments()
    {
        String sql = "SELECT * FROM enrollments";
        try
                (Connection conn = getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql))
        {
            log.info("Fetching all enrollments from database");
            while (rs.next())
            {
                System.out.println("Student ID: " + rs.getInt("student_id") +
                        ", Course ID: " + rs.getInt("course_id"));
            }
        }
        catch (SQLException e)
        {
            log.error("Error fetching enrollment list", e);
        }
    }

    //student's all functions start menu
    void studentMenu()
    {
        System.out.println("1. Add 2. Update 3. Delete 4. View All");
        int c = scanner.nextInt();
        scanner.nextLine();               // consume the leftover new line
        log.info("Student menu option selected: {}", c);
        switch (c)
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
        log.info("Teacher menu option selected: {}", c);
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
        log.info("Course menu option selected: {}", c);
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

    void enrollmentMenu()
    {
        System.out.println("1. Enroll Student 2. View All");
        int c = scanner.nextInt();
        log.info("Enrollment menu option selected: {}", c);
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

    // first display to choose from all
    void startMenu()
    {
        while (true)
        {
            System.out.println("\n Student Management ");
            System.out.println("1. Students  2. Teachers  3. Courses  4. Enrollments  5. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            log.info("Main menu option selected: {}", choice);
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
        new StudentManagementWithLogger().startMenu();         // anonymous object
    }
}
