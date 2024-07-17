package com.blog.model;

import java.util.Date;

public class BlogPost {

    private int id;
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private String imageUrl;
    private int userId;

    // Constructor
    public BlogPost( String title, String content, Date createdAt, Date updatedAt, String imageUrl, int userId) {
//        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.imageUrl = imageUrl;
        this.userId = userId;
    }

    public BlogPost() {
        // Default constructor
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BlogPost [id=" + id + ", title=" + title + ", content=" + content + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + ", imageUrl=" + imageUrl + ", userId=" + userId + "]";
    }

    // Additional methods for business logic can be added here

}
