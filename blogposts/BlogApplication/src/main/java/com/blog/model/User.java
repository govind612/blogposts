package com.blog.model;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String email;
    private String passwordHash;
    private String role;

    // Constructor
    public User(String name, String email, String passwordHash, String role) {
//        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public User() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//	public User getUserByEmail(String email2) {
//		// TODO Auto-generated method stub
//		return null;
//		}
//
//	public List<User> getAllUsers() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", passwordHash=" + passwordHash + ", role="
				+ role + "]";
	}

//	public void addUser(User newUser) {
//		// TODO Auto-generated method stub
//		
//	}

    // Additional methods for business logic can be added here

}
