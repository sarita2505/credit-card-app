package com.java.model;

public class Book {
    private int Id;
    private String bookName;
    private String authorName;
    private String publicationNmae;
    private int edition;

    public Book() {
    }

    public Book(int bookId, String bookName, String authorName, String publicationNmae, int edition) {
        this.Id = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publicationNmae = publicationNmae;
        this.edition = edition;
    }

    public int getBookId() {
        return Id;
    }

    public void setBookId(int bookId) {
        this.Id = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublicationNmae() {
        return publicationNmae;
    }

    public void setPublicationNmae(String publicationNmae) {
        this.publicationNmae = publicationNmae;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }
}
