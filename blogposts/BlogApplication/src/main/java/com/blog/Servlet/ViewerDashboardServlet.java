package com.blog.Servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.DAO.BlogPostDAO;
import com.blog.DAOImp.BlogPostDAOImp;
import com.blog.model.BlogPost;

@WebServlet("/viewerDashboard")
public class ViewerDashboardServlet extends HttpServlet {
    private BlogPostDAO blogPostDAO;

    @Override
    public void init() {
        blogPostDAO = new BlogPostDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        String sort = request.getParameter("sort") != null ? request.getParameter("sort") : "created_at";

        List<BlogPost> posts = blogPostDAO.getAllPosts(recordsPerPage, (page - 1) * recordsPerPage, sort);
        int totalRecords = blogPostDAO.getTotalPosts();
        int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);

        request.setAttribute("posts", posts);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("sort", sort);

        request.getRequestDispatcher("viewerDashboard.jsp").forward(request, response);
    }
}
