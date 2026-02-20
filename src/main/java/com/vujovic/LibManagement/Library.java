package com.vujovic.LibManagement;

import java.time.LocalDate;
import java.util.Objects;

public class Library {

    private String title;
    private String author;
    private int year;
    private String ISBN;// Osnovni ISBN se sastoji od 10 cifara (gdje na poslednjoj poziciji moze da stoji i X), a postoji i ISBN-13 ->
    // 13 cifara ukupno i drugacija validacija)

    public Library() {
    }

    public Library(String title, String author, int year, String ISBN) throws InvalidTitle, InvalidAuthor, InvalidYear, InvalidISBN{
        setTitle(title);
        setAuthor(author);
        setYear(year);
        setISBN(ISBN);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws InvalidTitle{

        String regex = "^[A-Za-z0-9][A-Za-z0-9 ]+$";
        if (title!=null && title.matches(regex)){
            this.title = title;
        }
        else{
            throw new InvalidTitle(title);
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws InvalidAuthor{

        String regex = "^([A-Z][a-z]+|[A-Z]\\.)+(\\s[A-Z][a-z]+)+(-[A-Z][a-z]+)?$";
        if (author!=null && author.matches(regex)) {
            this.author = author;
        } else {
            throw new InvalidAuthor();
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws InvalidYear{

        if (year<= LocalDate.now().getYear() && year!=0) {
            this.year = year;
        } else {
            throw new InvalidYear(year);
        }
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) throws InvalidISBN{
        int sum = 0;
        int digit;
        if (ISBN.length() == 10 && ISBN.matches("^\\d{10}$")) {
            int pom=1;
            for (int i = 9; i >= 0; i--) {
                digit = ISBN.charAt(i) - '0';
                sum += digit * (pom++);
            }
            if (sum % 11 == 0)
                this.ISBN = ISBN;
            else
                throw new InvalidISBN();
        }

        else if (ISBN.length()==10 && ISBN.matches("^\\d{9}X$")){
            int pom=1;
            for (char c: ISBN.toCharArray()) {
                if (Character.isDigit(c)){
                    digit=c-'0';
                    sum+=digit*(pom++);
                }
            }
            if (sum%11==10)
                this.ISBN=ISBN;
            else
                throw new InvalidISBN();
        }
        else
            throw new InvalidISBN();
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