package ru.rutmiit.lsm.entities;


public class AddBook {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private short quantity;
    private Boolean isAvail;

    public AddBook() {

    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }


    public Boolean getAvail() {
        return isAvail;
    }

    public void setAvail(Boolean avail) {
        isAvail = avail;
    }
}
