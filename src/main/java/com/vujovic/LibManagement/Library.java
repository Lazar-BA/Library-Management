package com.vujovic.LibManagement;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Objects;

public class Library {

    @NotBlank
    @Size(min=2,max=100)
    @Pattern(regexp = "^[A-Za-z0-9\\s.,!?-]+$")
    private String title;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z\\s.-]+$")
    private String author;

    @Min(1)
    @Max(2026)//Ako zelimo da se validira prema trenutnoj godini,
    // moramo napisati custom validator -> LocalDate.now().getYear()
    private int year;

    @NotBlank
    @ValidISBN // za ovaj slucaj sam morao da kreiram custom validation
    private String ISBN;// Osnovni ISBN se sastoji od 10 cifara (gdje na poslednjoj poziciji moze da stoji i X), a postoji i ISBN-13 ->
    // 13 cifara ukupno i drugacija validacija -> ovdje nije obradjen!)

    public Library() {
    }

    public Library(String title, String author, int year, String ISBN){
        setTitle(title);
        setAuthor(author);
        setYear(year);
        setISBN(ISBN);
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return year == library.year && Objects.equals(title, library.title) && Objects.equals(author, library.author) && Objects.equals(ISBN, library.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, ISBN);
    }

}