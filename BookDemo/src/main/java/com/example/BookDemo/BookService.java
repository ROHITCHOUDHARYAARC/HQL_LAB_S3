package com.example.BookDemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookService {

	@Autowired
	BookRepository br;
	public void addBook (Book b) 
	{
		br.save(b);
	}
	
	public List<Book> getBooks()
	{
		
		return br.findAll();
	}
	
	public Book bookID (int id) {
		return br.findById(id).orElse(null);
	}
	
	public void deleteBook(int bno)
	{
		br.deleteById(bno);
	}

	
}
