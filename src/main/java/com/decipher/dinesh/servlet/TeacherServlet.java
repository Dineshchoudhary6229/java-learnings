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

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {

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
                case "view" -> showAllTeachers(out);
                default -> showAllTeachers(out);
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
                case "add" -> addTeacher(request, response);
                case "update" -> updateTeacher(request, response);
                case "delete" -> deleteTeacher(request, response);
                case "view" -> response.sendRedirect("TeacherServlet?action=view");
                default -> response.sendRedirect("TeacherServlet");
            }
        } catch (Exception e) {
            response.getWriter().println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

    private void showAllTeachers(PrintWriter out) throws SQLException {
        try (Connection conn = DBUtils.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM teachers")) {

            out.println("<h2>Teachers List</h2><ul>");
            while (rs.next()) {
                out.println("<li>ID:" + rs.getInt("id") + ", Name:" + rs.getString("name") +
                        ", Subject:" + rs.getString("subject") + "</li>");
            }
            out.println("</ul>");
            out.println("<p><a href='index_multiple.html'>Back to Main Page</a></p>");
        }
    }

    private void addTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String subject = request.getParameter("subject");

        String sql = "INSERT INTO teachers (name, subject) VALUES (?, ?)";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, subject);
            ps.executeUpdate();
        }
        response.sendRedirect("TeacherServlet");
    }

    private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String subject = request.getParameter("subject");

        String sql = "UPDATE teachers SET name=?, subject=? WHERE id=?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, subject);
            ps.setInt(3, id);
            ps.executeUpdate();
        }
        response.sendRedirect("TeacherServlet");
    }

    private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String sql = "DELETE FROM teachers WHERE id=?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        response.sendRedirect("TeacherServlet");
    }

    private void showAddForm(PrintWriter out) {
        out.println("<h3>Add Teacher</h3>");
        out.println("<form method='post'><input type='hidden' name='action' value='add'/>" +
                "Name:<input name='name'/><br/>Subject:<input name='subject'/>" +
                "<input type='submit' value='Add'/></form>");
    }

    private void showUpdateForm(PrintWriter out) {
        out.println("<h3>Update Teacher</h3>");
        out.println("<form method='post'><input type='hidden' name='action' value='update'/>" +
                "ID:<input name='id'/><br/>Name:<input name='name'/><br/>Subject:<input name='subject'/>" +
                "<input type='submit' value='Update'/></form>");
    }

    private void showDeleteForm(PrintWriter out) {
        out.println("<h3>Delete Teacher</h3>");
        out.println("<form method='post'><input type='hidden' name='action' value='delete'/>" +
                "ID:<input name='id'/><input type='submit' value='Delete'/></form>");
    }

    private void showActionForms(PrintWriter out) {
        showAddForm(out);
        showUpdateForm(out);
        showDeleteForm(out);
    }
}
