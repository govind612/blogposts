package com.blog.Servlet;

import com.blog.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/adminDashboard")
public class AdminDashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null && "Admin".equals(user.getRole())) {
                request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
                return;
            }
        }
        response.sendRedirect("login.jsp");
    }
}
