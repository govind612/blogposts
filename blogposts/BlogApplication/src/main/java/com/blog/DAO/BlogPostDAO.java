package com.blog.DAO;

import com.blog.model.BlogPost;
import java.util.List;

public interface BlogPostDAO {
    void addPost(BlogPost post);
    BlogPost getPost(int postId);
    void updatePost(BlogPost post);
    void deletePost(int postId);
    List<BlogPost> getAllPosts(int recordsPerPage, int i, String sort);
	int getTotalPosts();
}
