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

@WebServlet("/EnrollmentServlet")
public class EnrollmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        if (action == null) action = "main";

        try {
            switch (action) {
                case "add" -> showAddForm(out);
                case "update" -> showUpdateForm(out);
                case "delete" -> showDeleteForm(out);
                case "view" -> showAllEnrollments(out);
                default -> showAllEnrollments(out);
            }

            if (!"view".equals(action)) showActionForms(out);

        } catch (SQLException e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "add" -> addEnrollment(request, response);
                case "update" -> updateEnrollment(request, response);
                case "delete" -> deleteEnrollment(request, response);
                case "view" -> response.sendRedirect("EnrollmentServlet?action=view");
                default -> response.sendRedirect("EnrollmentServlet");
            }
        } catch (Exception e) {
            response.getWriter().println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

    private void showAllEnrollments(PrintWriter out) throws SQLException {
        try (Connection conn = DBUtils.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(
                     "SELECT e.id, s.name AS student_name, c.name AS course_name " +
                             "FROM enrollments e " +
                             "JOIN students s ON e.student_id = s.id " +
                             "JOIN courses c ON e.course_id = c.id")) {

            out.println("<h2>Enrollments List</h2><ul>");
            while (rs.next()) {
                out.println("<li>ID:" + rs.getInt("id") +
                        ", Student:" + rs.getString("student_name") +
                        ", Course:" + rs.getString("course_name") + "</li>");
            }
            out.println("</ul>");
            out.println("<p><a href='index_multiple.html'>Back to Main Page</a></p>");
        }
    }

    private void addEnrollment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int studentId = Integer.parseInt(request.getParameter("student_id"));
        int courseId = Integer.parseInt(request.getParameter("course_id"));

        String sql = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.executeUpdate();
        }
        response.sendRedirect("EnrollmentServlet");
    }

    private void updateEnrollment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int studentId = Integer.parseInt(request.getParameter("student_id"));
        int courseId = Integer.parseInt(request.getParameter("course_id"));

        String sql = "UPDATE enrollments SET student_id=?, course_id=? WHERE id=?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.setInt(3, id);
            ps.executeUpdate();
        }
        response.sendRedirect("EnrollmentServlet");
    }

    private void deleteEnrollment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String sql = "DELETE FROM enrollments WHERE id=?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        response.sendRedirect("EnrollmentServlet");
    }

    private void showAddForm(PrintWriter out) {
        out.println("<h3>Add Enrollment</h3>");
        out.println("<form method='post'><input type='hidden' name='action' value='add'/>" +
                "Student ID:<input name='student_id'/><br/>Course ID:<input name='course_id'/>" +
                "<input type='submit' value='Add'/></form>");
    }

    private void showUpdateForm(PrintWriter out) {
        out.println("<h3>Update Enrollment</h3>");
        out.println("<form method='post'><input type='hidden' name='action' value='update'/>" +
                "ID:<input name='id'/><br/>Student ID:<input name='student_id'/><br/>Course ID:<input name='course_id'/>" +
                "<input type='submit' value='Update'/></form>");
    }

    private void showDeleteForm(PrintWriter out) {
        out.println("<h3>Delete Enrollment</h3>");
        out.println("<form method='post'><input type='hidden' name='action' value='delete'/>" +
                "ID:<input name='id'/><input type='submit' value='Delete'/></form>");
    }

    private void showActionForms(PrintWriter out) {
        showAddForm(out);
        showUpdateForm(out);
        showDeleteForm(out);
    }
}
