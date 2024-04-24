package com.example.springbrrowbook.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Entity
@Table(name = "borrow")
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String borrowedCode;
    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getBorrowedCode() {
        return borrowedCode;
    }

    public void setBorrowedCode(String borrowedCode) {
        this.borrowedCode = borrowedCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
