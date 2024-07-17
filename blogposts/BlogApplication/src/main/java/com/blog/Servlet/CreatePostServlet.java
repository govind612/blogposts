package com.blog.Servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.DAO.BlogPostDAO;
import com.blog.DAOImp.BlogPostDAOImp;
import com.blog.DAOImp.UserDAOImp;
import com.blog.model.BlogPost;
import com.blog.model.User;

@WebServlet("/createPost")
public class CreatePostServlet extends HttpServlet {
    private BlogPostDAO blogPostDAO;

    @Override
    public void init() {
        blogPostDAO = new BlogPostDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("createPost.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        HttpSession session=request.getSession();
//        UserDAOImp userDAOImp = new UserDAOImp();
		//        request.getSession().getAttribute("user");
//        User user=(User) request.getAttribute("user");
//        int userId=user.getId();
//        List<User> user=userDAOImp.getAllUsers();
//        Integer userId=user.iterator().next().getId();
        Integer userId = (Integer) session.getAttribute("userId");
        
        
        BlogPost post = new BlogPost();
        post.setTitle(title);
        post.setContent(content);
        post.setCreatedAt(new Date());
        post.setUpdatedAt(new Date());
        post.setUserId(userId);
        System.out.println(post);
//        System.out.println(user);
        blogPostDAO.addPost(post);
        response.sendRedirect("adminDashboard");
    }
}