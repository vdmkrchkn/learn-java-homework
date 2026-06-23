package ru.aston.hometask2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/studentBooks.json");
        List<Student> students = new ArrayList<>();
        try {
            students = objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Book::getPages))
                .distinct()
                .filter(book -> book.getPublishYear() > 2000)
                .limit(3)
                .map(Book::getPublishYear)
                .findAny()
                .ifPresentOrElse(System.out::println, () -> System.out.println("нет информации о книге"));
    }
}
