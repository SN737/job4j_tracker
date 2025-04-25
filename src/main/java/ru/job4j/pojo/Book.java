package ru.job4j.pojo;

public class Book {
    private String name;
    private int qtyPages;

    public Book(String name, int qtyPages) {
        this.name = name;
        this.qtyPages = qtyPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtyPages() {
        return qtyPages;
    }

    public void setQtyPages(int qtyPages) {
        this.qtyPages = qtyPages;
    }
}
