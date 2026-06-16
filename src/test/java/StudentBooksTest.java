import org.junit.jupiter.api.Test;
import ru.aston.hometask2.Book;
import ru.aston.hometask2.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StudentBooksTest {
    private Optional<Integer> getStudentBookPublishYear(List<Student> list) {
        return list.stream()
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
                    new Book("Java 2 Том 1 Основы", List.of("Хорстманн", "Корнелл"), 816, 2010))));

        assertEquals(2010, getStudentBookPublishYear(students).orElse(null));
    }
}
