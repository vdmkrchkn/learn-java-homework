import org.junit.jupiter.api.Test;
import ru.aston.hometask2.Book;
import ru.aston.hometask2.Student;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StudentBooksTest {
    private Optional<Integer> getStudentBookPublishYear(Collection<Student> students) {
        return students.stream()
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Book::getPages))
                .distinct()
                .filter(book -> book.getPublishYear() > 2000)
                .limit(3)
                .map(Book::getPublishYear)
                .findAny();
    }

    @Test
    void noStudentHasNoPublishedBook() {
        List<Student> students = new ArrayList<>();
        assertNull(getStudentBookPublishYear(students).orElse(null));
    }

    @Test
    void studentHasBookPublishedAt21stCentury() {
        List<Student> students = List.of(
            new Student("Иванов Иван Иванович", List.of(
                new Book("Java 2 Том 1 Основы", List.of("Хорстманн", "Корнелл"), 816, 2010),
                new Book("Приёмы ООП, паттерны проектирования", List.of("Гамма", "Хелм", "Джонсон", "Влиссидес"),
                        368, 2018),
                new Book("Конкурентность в C#", List.of("Клири"), 272, 2020))),
            new Student("Петров Петр Петрович", List.of(
                        new Book("Руслан и Людмила", List.of("Пушкин"), 100, 1820))));

        assertEquals(2020, getStudentBookPublishYear(students).orElse(null));
    }
}
