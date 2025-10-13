package com.decipher.dinesh.singleservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;
import java.io.InputStream;

@WebServlet("/studentmanagement")
public class StudentManagementServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(StudentManagementServlet.class);
    private final Properties props = new Properties();

    @Override
    public void init() throws ServletException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) throw new RuntimeException("application.properties not found");
            props.load(input);
            Class.forName(props.getProperty("jdbc.driver"));
        } catch (Exception e) {
            log.error("Error initializing servlet", e);
            throw new ServletException(e);
        }
    }

    private Connection getConnection() throws SQLException {
        String url = System.getenv("DB_URL") != null ? System.getenv("DB_URL") : props.getProperty("jdbc.url");
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : props.getProperty("jdbc.username");
        String password = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : props.getProperty("jdbc.password");
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String entity = request.getParameter("entity"); // student, teacher, course, enrollment
        String action = request.getParameter("action"); // add, update, delete, view

        if (entity == null) {
            showMainMenu(out);
            return;
        }

        switch (entity) {
            case "student" -> handleStudent(request, out, action);
            case "teacher" -> handleTeacher(request, out, action);
            case "course" -> handleCourse(request, out, action);
            case "enrollment" -> handleEnrollment(request, out, action);
            default -> out.println("<p>Unknown entity</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void showMainMenu(PrintWriter out) {
        out.println("<h1>Student Management</h1>");
        out.println("<ul>");
        out.println("<li><a href='?entity=student&action=view'>Students</a></li>");
        out.println("<li><a href='?entity=teacher&action=view'>Teachers</a></li>");
        out.println("<li><a href='?entity=course&action=view'>Courses</a></li>");
        out.println("<li><a href='?entity=enrollment&action=view'>Enrollments</a></li>");
        out.println("</ul>");
    }

    // student details
    private void handleStudent(HttpServletRequest request, PrintWriter out, String action) {
        try {
            if (action == null || action.equals("view")) {
                viewAllStudentsHTML(out);
                showStudentForms(out);
                return;
            }

            String idStr = request.getParameter("id");
            String name = request.getParameter("name");
            String ageStr = request.getParameter("age");
            String grade = request.getParameter("grade");

            switch (action) {
                case "add" -> addStudent(name, Integer.parseInt(ageStr), grade, out);
                case "update" -> updateStudent(Integer.parseInt(idStr), name, Integer.parseInt(ageStr), grade, out);
                case "delete" -> deleteStudent(Integer.parseInt(idStr), out);
            }
            viewAllStudentsHTML(out);
            showStudentForms(out);
        } catch (Exception e) {
            out.println("<p>Error processing student</p>");
            log.error("Student error", e);
        }
    }

    private void addStudent(String name, int age, String grade, PrintWriter out) throws SQLException {
        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name); ps.setInt(2, age); ps.setString(3, grade); ps.executeUpdate();
            out.println("<p>Student added!</p>");
        }
    }

    private void updateStudent(int id, String name, int age, String grade, PrintWriter out) throws SQLException {
        String sql = "UPDATE students SET name=?, age=?, grade=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name); ps.setInt(2, age); ps.setString(3, grade); ps.setInt(4, id);
            int rows = ps.executeUpdate();
            out.println(rows > 0 ? "<p>Student updated!</p>" : "<p>ID not found</p>");
        }
    }

    private void deleteStudent(int id, PrintWriter out) throws SQLException {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id); int rows = ps.executeUpdate();
            out.println(rows > 0 ? "<p>Student deleted!</p>" : "<p>ID not found</p>");
        }
    }

    private void viewAllStudentsHTML(PrintWriter out) throws SQLException {
        String sql = "SELECT * FROM students";
        try (Connection conn = getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            out.println("<h2>Students List</h2><ul>");
            while (rs.next()) {
                out.println("<li>ID:" + rs.getInt("id") + ", Name:" + rs.getString("name") + ", Age:" + rs.getInt("age") + ", Grade:" + rs.getString("grade") + "</li>");
            }
            out.println("</ul>");
        }
    }

    private void showStudentForms(PrintWriter out) {
        out.println("<h3>Add Student</h3><form method='get'>Name:<input name='name'/><br/>Age:<input name='age'/><br/>Grade:<input name='grade'/><input type='hidden' name='entity' value='student'/><input type='hidden' name='action' value='add'/><input type='submit' value='Add'/></form>");
        out.println("<h3>Update Student</h3><form method='get'>ID:<input name='id'/><br/>Name:<input name='name'/><br/>Age:<input name='age'/><br/>Grade:<input name='grade'/><input type='hidden' name='entity' value='student'/><input type='hidden' name='action' value='update'/><input type='submit' value='Update'/></form>");
        out.println("<h3>Delete Student</h3><form method='get'>ID:<input name='id'/><input type='hidden' name='entity' value='student'/><input type='hidden' name='action' value='delete'/><input type='submit' value='Delete'/></form>");
    }

    // teacher details
    private void handleTeacher(HttpServletRequest request, PrintWriter out, String action) {
        try {
            if (action == null || action.equals("view")) { viewAllTeachersHTML(out); showTeacherForms(out); return; }

            String idStr = request.getParameter("id");
            String name = request.getParameter("name");
            String subject = request.getParameter("subject");

            switch (action) {
                case "add" -> addTeacher(name, subject, out);
                case "update" -> updateTeacher(Integer.parseInt(idStr), name, subject, out);
                case "delete" -> deleteTeacher(Integer.parseInt(idStr), out);
            }
            viewAllTeachersHTML(out);
            showTeacherForms(out);
        } catch (Exception e) { out.println("<p>Error processing teacher</p>"); log.error("Teacher error", e); }
    }

    private void addTeacher(String name, String subject, PrintWriter out) throws SQLException {
        String sql = "INSERT INTO teachers (name, subject) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) { ps.setString(1, name); ps.setString(2, subject); ps.executeUpdate(); out.println("<p>Teacher added!</p>"); }
    }

    private void updateTeacher(int id, String name, String subject, PrintWriter out) throws SQLException {
        String sql = "UPDATE teachers SET name=?, subject=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) { ps.setString(1, name); ps.setString(2, subject); ps.setInt(3, id); int rows = ps.executeUpdate(); out.println(rows>0?"<p>Teacher updated!</p>":"<p>ID not found</p>"); }
    }

    private void deleteTeacher(int id, PrintWriter out) throws SQLException {
        String sql = "DELETE FROM teachers WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) { ps.setInt(1, id); int rows = ps.executeUpdate(); out.println(rows>0?"<p>Teacher deleted!</p>":"<p>ID not found</p>"); }
    }

    private void viewAllTeachersHTML(PrintWriter out) throws SQLException {
        String sql = "SELECT * FROM teachers";
        try (Connection conn = getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            out.println("<h2>Teachers List</h2><ul>");
            while(rs.next()) out.println("<li>ID:"+rs.getInt("id")+", Name:"+rs.getString("name")+", Subject:"+rs.getString("subject")+"</li>");
            out.println("</ul");
        }
    }

    private void showTeacherForms(PrintWriter out) {
        out.println("<h3>Add Teacher</h3><form method='get'>Name:<input name='name'/><br/>Subject:<input name='subject'/><input type='hidden' name='entity' value='teacher'/><input type='hidden' name='action' value='add'/><input type='submit' value='Add'/></form>");
        out.println("<h3>Update Teacher</h3><form method='get'>ID:<input name='id'/><br/>Name:<input name='name'/><br/>Subject:<input name='subject'/><input type='hidden' name='entity' value='teacher'/><input type='hidden' name='action' value='update'/><input type='submit' value='Update'/></form>");
        out.println("<h3>Delete Teacher</h3><form method='get'>ID:<input name='id'/><input type='hidden' name='entity' value='teacher'/><input type='hidden' name='action' value='delete'/><input type='submit' value='Delete'/></form>");
    }

    // courses details
    private void handleCourse(HttpServletRequest request, PrintWriter out, String action) {
        try {
            if (action == null || action.equals("view")) { viewAllCoursesHTML(out); showCourseForms(out); return; }

            String idStr = request.getParameter("id");
            String name = request.getParameter("name");
            String teacherIdStr = request.getParameter("teacher_id");

            switch (action) {
                case "add" -> addCourse(name, Integer.parseInt(teacherIdStr), out);
                case "update" -> updateCourse(Integer.parseInt(idStr), name, Integer.parseInt(teacherIdStr), out);
                case "delete" -> deleteCourse(Integer.parseInt(idStr), out);
            }
            viewAllCoursesHTML(out);
            showCourseForms(out);
        } catch (Exception e) { out.println("<p>Error processing course</p>"); log.error("Course error", e); }
    }

    private void addCourse(String name, int teacherId, PrintWriter out) throws SQLException {
        String sql = "INSERT INTO courses (name, teacher_id) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) { ps.setString(1, name); ps.setInt(2, teacherId); ps.executeUpdate(); out.println("<p>Course added!</p>"); }
    }

    private void updateCourse(int id, String name, int teacherId, PrintWriter out) throws SQLException {
        String sql = "UPDATE courses SET name=?, teacher_id=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) { ps.setString(1, name); ps.setInt(2, teacherId); ps.setInt(3, id); int rows = ps.executeUpdate(); out.println(rows>0?"<p>Course updated!</p>":"<p>ID not found</p>"); }
    }

    private void deleteCourse(int id, PrintWriter out) throws SQLException {
        String sql = "DELETE FROM courses WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) { ps.setInt(1, id); int rows = ps.executeUpdate(); out.println(rows>0?"<p>Course deleted!</p>":"<p>ID not found</p>"); }
    }

    private void viewAllCoursesHTML(PrintWriter out) throws SQLException {
        String sql = "SELECT * FROM courses";
        try (Connection conn = getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            out.println("<h2>Courses List</h2><ul>");
            while(rs.next()) out.println("<li>ID:"+rs.getInt("id")+", Name:"+rs.getString("name")+", TeacherID:"+rs.getInt("teacher_id")+"</li>");
            out.println("</ul>");
        }
    }
                  // FORMS for Course
    private void showCourseForms(PrintWriter out) {
        out.println("<h3>Add Course</h3><form method='get'>Name:<input name='name'/><br/>TeacherID:<input name='teacher_id'/><input type='hidden' name='entity' value='course'/><input type='hidden' name='action' value='add'/><input type='submit' value='Add'/></form>");
        out.println("<h3>Update Course</h3><form method='get'>ID:<input name='id'/><br/>Name:<input name='name'/><br/>TeacherID:<input name='teacher_id'/><input type='hidden' name='entity' value='course'/><input type='hidden' name='action' value='update'/><input type='submit' value='Update'/></form>");
        out.println("<h3>Delete Course</h3><form method='get'>ID:<input name='id'/><input type='hidden' name='entity' value='course'/><input type='hidden' name='action' value='delete'/><input type='submit' value='Delete'/></form>");
    }

    // enrollments details
    private void handleEnrollment(HttpServletRequest request, PrintWriter out, String action) {
        try {
            if (action == null || action.equals("view")) { viewAllEnrollmentsHTML(out); showEnrollmentForms(out); return; }

            String studentIdStr = request.getParameter("student_id");
            String courseIdStr = request.getParameter("course_id");

            switch(action){
                case "add" -> enrollStudent(Integer.parseInt(studentIdStr), Integer.parseInt(courseIdStr), out);
                case "delete" -> deleteEnrollment(Integer.parseInt(studentIdStr), Integer.parseInt(courseIdStr), out);
            }

            viewAllEnrollmentsHTML(out); showEnrollmentForms(out);
        } catch(Exception e){ out.println("<p>Error processing enrollment</p>"); log.error("Enrollment error", e);}
    }

    private void enrollStudent(int studentId, int courseId, PrintWriter out) throws SQLException {
        String sql = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";
        try(Connection conn=getConnection(); PreparedStatement ps=conn.prepareStatement(sql)){ ps.setInt(1, studentId); ps.setInt(2, courseId); ps.executeUpdate(); out.println("<p>Enrollment added!</p>"); }
    }

    private void deleteEnrollment(int studentId, int courseId, PrintWriter out) throws SQLException {
        String sql = "DELETE FROM enrollments WHERE student_id=? AND course_id=?";
        try(Connection conn=getConnection(); PreparedStatement ps=conn.prepareStatement(sql)){ ps.setInt(1, studentId); ps.setInt(2, courseId); int rows=ps.executeUpdate(); out.println(rows>0?"<p>Enrollment deleted!</p>":"<p>Enrollment not found</p>"); }
    }

    private void viewAllEnrollmentsHTML(PrintWriter out) throws SQLException {
        String sql = "SELECT * FROM enrollments";
        try(Connection conn=getConnection(); Statement st=conn.createStatement(); ResultSet rs=st.executeQuery(sql)){ out.println("<h2>Enrollments List</h2><ul>"); while(rs.next()) out.println("<li>StudentID:"+rs.getInt("student_id")+", CourseID:"+rs.getInt("course_id")+"</li>"); out.println("</ul>"); }
    }
              // FORMS for enrollments
    private void showEnrollmentForms(PrintWriter out){
        out.println("<h3>Enroll Student</h3><form method='get'>StudentID:<input name='student_id'/><br/>CourseID:<input name='course_id'/><input type='hidden' name='entity' value='enrollment'/><input type='hidden' name='action' value='add'/><input type='submit' value='Enroll'/></form>");
        out.println("<h3>Delete Enrollment</h3><form method='get'>StudentID:<input name='student_id'/><br/>CourseID:<input name='course_id'/><input type='hidden' name='entity' value='enrollment'/><input type='hidden' name='action' value='delete'/><input type='submit' value='Delete'/></form>");
    }
}
