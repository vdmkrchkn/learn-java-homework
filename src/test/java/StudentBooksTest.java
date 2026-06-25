import org.junit.jupiter.api.Test;
import ru.aston.hometask2.Book;
import ru.aston.hometask2.MainApp;
import ru.aston.hometask2.Student;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentBooksTest {
    @Test
    void when_noFileProvided_then_throwFileNotFoundException() {
        assertThrows(FileNotFoundException.class, () -> MainApp.readFile(""));
    }

    @Test
    void when_emptyCollection_then_returnNull() {
        Collection<Student> students = new ArrayList<>();
        Integer year = MainApp.getStudentBookPublishYear(students).orElse(null);
        assertNull(year);
    }

    @Test
    void when_fileProvided_then_returnNonEmptyCollection() throws IOException {
        String fileName = "src/main/resources/studentBooks.json";
        Collection<Student> students = MainApp.readFile(fileName);
        Integer year = MainApp.getStudentBookPublishYear(students).orElse(null);
        assertEquals(2020, year);
    }

    @Test
    void when_manyStudentsWithBooks_then_returnPublishYear() {
        Collection<Student> students = List.of(
                new Student("Иванов Иван Иванович", List.of(
                        new Book("Java 2 Том 1 Основы", List.of("Хорстманн", "Корнелл"), 816, 2010),
                        new Book("Приёмы ООП, паттерны проектирования", List.of("Гамма", "Хелм", "Джонсон", "Влиссидес"),
                                368, 2018),
                        new Book("Конкурентность в C#", List.of("Клири"), 272, 2020))),
                new Student("Петров Петр Петрович", List.of(
                        new Book("Руслан и Людмила", List.of("Пушкин"), 100, 1820))));
        Integer year = MainApp.getStudentBookPublishYear(students).orElse(null);
        assertEquals(2020, year);
    }
}
