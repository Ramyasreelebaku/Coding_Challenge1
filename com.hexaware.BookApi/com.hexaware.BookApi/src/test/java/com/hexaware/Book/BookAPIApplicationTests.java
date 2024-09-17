package com.hexaware.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.Book.Dao.BookRepository;
import com.hexaware.Book.Entity.Book;

@SpringBootTest
class BookAPIApplicationTests {
	@Autowired BookRepository bookRep;

	@Test
	void addbook() {
		Book b= new Book();
		b.setTitle("java");
		b.setIsbn(1234);
		b.setAuthor("kathy");
		b.setPublicationYear(1979);
		bookRep.save(b);
	}
	
	@Test
	void deletebook() {
		bookRep.deleteById((long) 1234);
	}
	

	@Test
    void getAllBooks() {
        List<Book> actualBookList = (List<Book>) bookRep.findAll();
        int listSize = actualBookList.size();
        
        assertEquals(6, listSize);
    }
	
	@Test
	void getBookById() {
		Book actualBook = bookRep.findById((long) 127).orElse(null);
		
		
		Book expBook = new Book();
		expBook.setTitle("c");
		
		assertEquals(actualBook.getTitle(), expBook.getTitle(), "");
	}
	
	@Test
	void updateBook() {
		Book actualBook = bookRep.findById((long) 102).orElse(null);
		
		actualBook.setTitle("java");
		
		bookRep.save(actualBook);
		
		assertEquals(actualBook.getTitle(), "java", "");
	}

}
