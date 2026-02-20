package com.vujovic.LibManagement;

public class LibExceptions extends Exception {
    public LibExceptions(String message) {
        super(message);
    }
}

class InvalidTitle extends LibExceptions {
    public InvalidTitle(String title){
        super("THIS"+" "+title+" "+"IS INVALID BOOK TITLE!");
    }
}

class InvalidAuthor extends LibExceptions {
    public InvalidAuthor(){
        super("THIS CANT BE A NAME OF THE AUTHOR!");
    }
}

class InvalidYear extends LibExceptions {
    public InvalidYear(int year){
        super("THIS"+" "+year+" "+"IS INVALID YEAR!");
    }
}

class InvalidISBN extends LibExceptions {
    public InvalidISBN(){
        super("INVALID ISBN OF THE BOOK!");
    }
}