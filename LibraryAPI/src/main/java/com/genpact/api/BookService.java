package com.genpact.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	public List<Book> getAllBooks() {
		return (List<Book>) bookRepo.findAll();
	}
	
	public Optional<Book> getBookById(String id) {
		return bookRepo.findById(id);
	}
	
	public void addBook(Book book) {
		bookRepo.save(book);
	}
	
	public void updateBook(Book book,String id) {
		bookRepo.save(book);
	}
	
	public void deleteBook(String id) {
		bookRepo.deleteById(id);
	}

}
