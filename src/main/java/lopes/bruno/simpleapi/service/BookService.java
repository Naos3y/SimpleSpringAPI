package lopes.bruno.simpleapi.service;

import lopes.bruno.simpleapi.dto.BookDTO;
import lopes.bruno.simpleapi.exception.BookNotFoundException;
import lopes.bruno.simpleapi.model.Book;
import lopes.bruno.simpleapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//A camada de serviço contém a lógica da aplicação onde podemos encapsular regras e manter o código do controlador mais limpo.

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book with id " + id + " Not Found."));
    }

    public Book createBook(BookDTO bookDTO) {
        Book book = new Book(null, bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getIsbn());
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, BookDTO bookDTO) {
        Book book = getBookById(id);
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
