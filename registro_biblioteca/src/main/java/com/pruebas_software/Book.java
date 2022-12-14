package com.pruebas_software;

import java.util.ArrayList;
import java.util.Date;
import com.pruebas_software.Location;
import com.pruebas_software.State;

public class Book {

    private String title;
    private ArrayList<String> authors;
    private Date editionDate;
    private int pages;
    private String publisher;
    private String genre;
    private String isbn;
    private Location location;
    private State state;
    private String description;

    // Builder

    public Book(String title, String author, Date editionDate, int pages, String publisher, String genre, String isbn, Location location, State state, String description){
        this.title = title;
        this.authors.add(author);
        this.editionDate = editionDate;
        this.pages = pages;
        this.publisher = publisher;
        this.genre = genre;
        this.isbn = isbn;
        this.location = location;
        this.state = state;
        this.description = description;
    }

    public Book(String title, ArrayList<String> authors, Date editionDate, int pages, String publisher, String genre, String isbn, Location location, State state, String description){
        this.title = title;
        this.authors = authors;
        this.editionDate = editionDate;
        this.pages = pages;
        this.publisher = publisher;
        this.genre = genre;
        this.isbn = isbn;
        this.location = location;
        this.state = state;
        this.description = description;
    }

    // Getters

    public String getTitle(){ return this.title; }

    public ArrayList<String> getAuthors(){ return this.authors; }

    public Date getEditionDate(){ return this.editionDate; }

    public int getPages(){ return this.pages; }

    public String getPublisher(){ return this.publisher; }

    public String getGenre(){ return this.genre; }

    public String getISBN(){ return this.isbn; }

    public Location geLocation(){ return this.location; }

    public State getState(){ return this.state; }

    public String getDescription(){ return this.description; }

    // Setters

    public void setTitle( String title){ this.title = title; }

    public void setAuthors(ArrayList<String> authors) { this.authors = authors; }

    public void setEditionDate(Date editionDate) { this.editionDate = editionDate; }

    public void setPages(int pages) { this.pages = pages; }

    public void setPublisher(String publisher) { this.publisher = publisher; }

    public void setGenre(String genre) { this.genre = genre; }

    public void setIsbn(String isbn) { this.isbn = isbn; }

    public void setLocation(Location location) { this.location = location; }

    public void setState(State state) { this.state = state; }

    public void setDescription(String description) { this.description = description; }

    // Methods

    public void addAuthor(String author){ this.authors.add(author); }

    public void addAuthors(ArrayList<String> authors){ this.authors.addAll(authors); }
}
