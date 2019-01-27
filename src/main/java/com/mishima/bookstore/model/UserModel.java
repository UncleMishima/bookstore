package com.mishima.bookstore.model;

import java.io.Serializable;
import java.util.List;

public class UserModel implements Serializable {
    private static final long serialVersionUID = -5522551799644603411L;

    private int id;
    private String fullName;
    private String email;
    private String role;
    private Cart cart;
    //private List<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

//    public List<Book> getBooks() {
//        return books;
//    }

//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }
}
