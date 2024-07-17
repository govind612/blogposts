package com.blog.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.blog.DAO.BlogPostDAO;
import com.blog.model.BlogPost;

public class BlogPostDAOImp implements BlogPostDAO {
    private String url = "jdbc:mysql://localhost:3306/blog_application";
    private String username = "root";
    private String password = "root";
    private Connection con;

    public BlogPostDAOImp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPost(BlogPost post) {
        String query = "INSERT INTO posts (title, content, created_at, updated_at, image_url, user_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getContent());
            stmt.setTimestamp(3, new Timestamp(post.getCreatedAt().getTime()));
            stmt.setTimestamp(4, new Timestamp(post.getUpdatedAt().getTime()));
            stmt.setString(5, post.getImageUrl());
            stmt.setInt(6, post.getUserId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BlogPost getPost(int postId) {
        String query = "SELECT * FROM posts WHERE id = ?";
        BlogPost post = null;
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, postId);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                post = extractPostFromResultSet(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public void updatePost(BlogPost post) {
        String query = "UPDATE posts SET title = ?, content = ?, updated_at = ?, image_url = ?, user_id = ? WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getContent());
            stmt.setTimestamp(3, new Timestamp(post.getUpdatedAt().getTime()));
            stmt.setString(4, post.getImageUrl());
            stmt.setInt(5, post.getUserId());
            stmt.setInt(6, post.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePost(int postId) {
        String query = "DELETE FROM posts WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, postId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public List<BlogPost> getAllPosts() {
//        String query = "SELECT * FROM posts";
//        List<BlogPost> posts = new ArrayList<>();
//        try (PreparedStatement stmt = con.prepareStatement(query)) {
//            ResultSet res = stmt.executeQuery();
//            while (res.next()) {
//                posts.add(extractPostFromResultSet(res));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return posts;
//    }
//
    private BlogPost extractPostFromResultSet(ResultSet res) throws SQLException {
        BlogPost post = new BlogPost();
        post.setId(res.getInt("id"));
        post.setTitle(res.getString("title"));
        post.setContent(res.getString("content"));
        post.setCreatedAt(res.getTimestamp("created_at"));
        post.setUpdatedAt(res.getTimestamp("updated_at"));
        post.setImageUrl(res.getString("image_url"));
        post.setUserId(res.getInt("user_id"));
        return post;
    }

	@Override
	public List<BlogPost> getAllPosts(int recordsPerPage, int i, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalPosts() {
//	    @Override
	   
	        String query = "SELECT * FROM posts";
	        List posts = new ArrayList();
	        try (PreparedStatement stmt = con.prepareStatement(query)) {
	            ResultSet res = stmt.executeQuery();
	            while (res.next()) {
	                posts.add(extractPostFromResultSet(res));
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        int a= posts.size();
	        return a;
	    }}
	  