package com.blog.Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.DAO.BlogPostDAO;
import com.blog.DAOImp.BlogPostDAOImp;
import com.blog.model.BlogPost;

@WebServlet("/updatePost")
public class UpdatePostServlet extends HttpServlet {
    private BlogPostDAO blogPostDAO;

    @Override
    public void init() {
        blogPostDAO = new BlogPostDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BlogPost post = blogPostDAO.getPost(id);
        request.setAttribute("post", post);
        request.getRequestDispatcher("updatePost.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BlogPost post = blogPostDAO.getPost(id);
        post.setTitle(title);
        post.setContent(content);
        post.setUpdatedAt(new Date());

        blogPostDAO.updatePost(post);
        response.sendRedirect("adminDashboard");
    }
}