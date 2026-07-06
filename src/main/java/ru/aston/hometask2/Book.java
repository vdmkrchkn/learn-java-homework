package ru.aston.hometask2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Book {
    private final String name;
    private final List<String> authors;
    private final int pages;
    private final int publishYear;

    public Book(@JsonProperty("name") String name,
                @JsonProperty("authors") List<String> authors,
                @JsonProperty("pages") int pages,
                @JsonProperty("year") int publishYear) {
        this.name = name;
        this.authors = authors;
        this.pages = pages;
        this.publishYear = publishYear;
    }

    public String getName() {
        return name;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int getPages() {
        return pages;
    }

    public int getPublishYear() {
        return publishYear;
    }

    @Override
    public String toString() {
        return name + ";"
                + authors.stream().reduce((author, authorNext) -> author
                + "," + authorNext).orElse("")
                + ";" + pages + ";" + publishYear;
    }
}
