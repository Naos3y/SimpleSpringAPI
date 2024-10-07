package lopes.bruno.simpleapi.repository;

import lopes.bruno.simpleapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
