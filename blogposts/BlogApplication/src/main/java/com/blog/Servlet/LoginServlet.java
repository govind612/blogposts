package com.blog.Servlet;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.mindrot.jbcrypt.BCrypt;
//
//import com.blog.DAO.UserDAO;
//import com.blog.DAOImp.UserDAOImp;
//import com.blog.model.User;
//
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//    private UserDAO userDAO;
//
//    @Override
//    public void init() {
//        userDAO = new UserDAOImp();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("login.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        User user = userDAO.getUserByEmail(email);
//
//        if (user != null && BCrypt.checkpw(password, user.getPasswordHash())) {
//            HttpSession session = request.getSession();
//            			request.setAttribute("user", user);
//            System.out.println(user.toString());
//            
//            if ("Admin".equals(user.getRole())) {
//                response.sendRedirect("adminDashboard");
//            } else {
//                response.sendRedirect("viewerDashboard");
//            }
//        } else {
//            response.sendRedirect("login.jsp?error=invalid_credentials");
//        }
//    }
//}package com.blogapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.blog.DAO.UserDAO;
import com.blog.DAOImp.UserDAOImp;
import com.blog.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userDAO.getUserByEmail(email);

        if (user != null && BCrypt.checkpw(password, user.getPasswordHash())) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            if ("Admin".equals(user.getRole())) {
                response.sendRedirect("adminDashboard");
            } else {
                response.sendRedirect("viewerDashboard");
            }
        } else {
            response.sendRedirect("login.jsp?error=invalid_credentials");
        }
    }
}