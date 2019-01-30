package com.mishima.bookstore.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_line")
public class CartLine implements Serializable {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @OneToOne
    private Book book;

    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "book_count")
    private int bookCount;

    private double total;

    @Column(name = "buying_price")
    private double buyingPrice;

    @Column(name = "is_available")
    private boolean isAvailable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
        calculateCartLineTotalPrice();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    private void calculateCartLineTotalPrice() {
        this.total = this.getBuyingPrice() * this.getBookCount();
    }
}
