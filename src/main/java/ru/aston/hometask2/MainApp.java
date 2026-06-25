package ru.aston.hometask2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MainApp {
    public static Collection<Student> readFile(String filename) throws IOException {
        File file = new File(filename);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (FileNotFoundException fe) {
            throw new FileNotFoundException("json файл не найден");
        } catch (IOException e) {
            throw new IOException("Ошибка чтения json файла");
        }
    }

    public static Optional<Integer> getStudentBookPublishYear(Collection<Student> students) {
        return students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Book::getPages))
                .distinct()
                .filter(book -> book.getPublishYear() > 2000)
                .limit(3)
                .map(Book::getPublishYear)
                .findAny();
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                Collection<Student> students = MainApp.readFile(args[0]);
                getStudentBookPublishYear(students)
                        .ifPresentOrElse(System.out::println, () -> System.out.println("нет информации о книге"));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
