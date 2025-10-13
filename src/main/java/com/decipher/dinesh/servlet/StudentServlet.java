package com.decipher.dinesh.servlet;

import com.decipher.dinesh.util.DBUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        if (action == null) action = "main"; // Treat null as main page

        try {
            switch (action) {
                case "add" -> showAddForm(out);
                case "update" -> showUpdateForm(out);
                case "delete" -> showDeleteForm(out);
                case "view" -> showAllStudents(out); // ViewAllStudents
                default -> showAllStudents(out);
            }

            // Only show action forms if we don't want to view all students
            if (!"view".equals(action)) {
                showActionForms(out);
            }

        } catch (SQLException e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "add" -> addStudent(request, response);
                case "update" -> updateStudent(request, response);
                case "delete" -> deleteStudent(request, response);
                case "view" -> response.sendRedirect("StudentServlet?action=view"); // redirect to list
                default -> response.sendRedirect("StudentServlet");
            }
        } catch (Exception e) {
            response.getWriter().println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

    // here we perfrom CRUD  operations in showAllStudents ,addStudent,updateStudent,deleteStudent
    private void showAllStudents(PrintWriter out) throws SQLException {
        try (Connection conn = DBUtils.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM students")) {

            out.println("<h2>Students List</h2><ul>");
            while (rs.next()) {
                out.println("<li>ID:" + rs.getInt("id") + ", Name:" + rs.getString("name") +
                        ", Age:" + rs.getInt("age") + ", Grade:" + rs.getString("grade") + "</li>");
            }
            out.println("</ul>");
            out.println("<p><a href='index_multiple.html'>Back to Main Page</a></p>");
        }
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String grade = request.getParameter("grade");

        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, grade);
            ps.executeUpdate();
        }
        response.sendRedirect("StudentServlet");
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String grade = request.getParameter("grade");

        String sql = "UPDATE students SET name=?, age=?, grade=? WHERE id=?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, grade);
            ps.setInt(4, id);
            ps.executeUpdate();
        }
        response.sendRedirect("StudentServlet");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        response.sendRedirect("StudentServlet");
    }

    // now we add FORMS for all
    private void showAddForm(PrintWriter out) {
        out.println("<h3>Add Student</h3>");
        out.println("<form method='post'><input type='hidden' name='action' value='add'/>" +
                "Name:<input name='name'/><br/>Age:<input name='age'/><br/>Grade:<input name='grade'/>" +
                "<input type='submit' value='Add'/></form>");
    }

    private void showUpdateForm(PrintWriter out) {
        out.println("<h3>Update Student</h3>");
        out.println("<form method='post'><input type='hidden' name='action' value='update'/>" +
                "ID:<input name='id'/><br/>Name:<input name='name'/><br/>Age:<input name='age'/><br/>" +
                "Grade:<input name='grade'/><input type='submit' value='Update'/></form>");
    }

    private void showDeleteForm(PrintWriter out) {
        out.println("<h3>Delete Student</h3>");
        out.println("<form method='post'><input type='hidden' name='action' value='delete'/>" +
                "ID:<input name='id'/><input type='submit' value='Delete'/></form>");
    }

    private void showActionForms(PrintWriter out) {
        showAddForm(out);
        showUpdateForm(out);
        showDeleteForm(out);
    }
}
