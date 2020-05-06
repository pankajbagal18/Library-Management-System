/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devpanks.datamodels;

/**
 *
 * @author pankaj
 */
public class Book {
    int bookId;
    String BookName;
    String author;
    String isbn;
    int availablCopies;
    int totalCopies;

    public Book(int bookId, String BookName, String author, String isbn, int availablCopies, int totalCopies) {
        this.bookId = bookId;
        this.BookName = BookName;
        this.author = author;
        this.isbn = isbn;
        this.availablCopies = availablCopies;
        this.totalCopies = totalCopies;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAvailablCopies() {
        return availablCopies;
    }

    public void setAvailablCopies(int availablCopies) {
        this.availablCopies = availablCopies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", BookName=" + BookName + ", author=" + author + ", isbn=" + isbn + ", availablCopies=" + availablCopies + ", totalCopies=" + totalCopies + '}';
    }
}
