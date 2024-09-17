package com.hexaware.Book.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.Book.Entity.Book;
import com.hexaware.Book.Service.BookService;



@RestController
@RequestMapping("/api/admin")
public class BookController {

    @Autowired
    BookService bookSer;

    @PostMapping("/addBooktoLibrary")
    public Book addNewBook(@RequestBody Book book) {
        return bookSer.addBook(book);
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookSer.getBooks();
    }

    @DeleteMapping("/removeBookbyId/{isbn}")
    public Book deleteBook(@PathVariable("isbn") long isbn) {
        return bookSer.delete(isbn);
    }

    @PutMapping("/updateBookbyId/{isbn}/{name}")
    public String updateBook(@PathVariable("isbn") long isbn, @PathVariable("name") String name) {
        return bookSer.updatebook(isbn, name);
    }

    @GetMapping("/findByISBN/{isbn}")
    public String findByISBN(@PathVariable("isbn") long isbn) {
        return bookSer.findbyISBN(isbn);
    }
    
}
