package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
    Book book1 = new Book("Clean Code", 464);
    Book book2 = new Book("Designing Data-Intensive Apps", 640);
    Book book3 = new Book("Learning Java", 500);
    Book book4 = new Book("Think Java", 440);

    Book[] books = new Book[4];
    books[0] = book1;
    books[1] = book2;
    books[2] = book3;
    books[3] = book4;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName());
                }
            swap(0, 3, books);

        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(book1)) {
                System.out.println(books[i].getName());
            }
        }

    }

    public static void swap(int a, int b, Book[] array) {
        Book temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}