package com.genpact.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/book/{id}")
	public Optional<Book> getBookById(@PathVariable String id) {
		return bookService.getBookById(id);
	}
	
	@PostMapping("/addBook")
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}
	
	@PutMapping("/updateBook/{id}")
	public void updateBook(@RequestBody Book book,@PathVariable String id) {
		bookService.updateBook(book, id);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public void deleteBook(@PathVariable String id) {
		bookService.deleteBook(id);
	}
	
	@RequestMapping(value="/retrieveAndaddBooks", method= {RequestMethod.GET,RequestMethod.POST})
	public List<Book> retrieveAndaddBooks(@RequestBody Book book) {
		bookService.addBook(book);
		return getAllBooks();
	}
	
	@RequestMapping(value="/retrieveAndupdateBooks", method= {RequestMethod.GET,RequestMethod.POST})
	public List<Book> retrieveAndupdateBooks(@RequestBody Book book) {
		bookService.updateBook(book, book.getId());
		return getAllBooks();
	}
	
	@RequestMapping(value="/retrieveAnddeleteBook", method= {RequestMethod.GET,RequestMethod.POST})
	public List<Book> retrieveAnddeleteBook(@RequestParam String id) {
		bookService.deleteBook(id);
		return getAllBooks();
	}

}
