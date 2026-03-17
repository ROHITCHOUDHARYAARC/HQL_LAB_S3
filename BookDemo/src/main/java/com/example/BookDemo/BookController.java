package com.example.BookDemo;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/book")
public class BookController {
	
	@Autowired 
	BookService bs;
	@PostMapping ("/insert")
	public void addBook(@RequestBody Book b) 
	{
		bs.addBook(b);
		//System.out.println("");
	}
	@GetMapping ("/get")
	public List<Book> getBooks()
	{
		return bs.getBooks();
		
	}
	
	@GetMapping("/get/{id}")
	
//	public Book getOneBook(@PathVariable int id ) {
//		return bs.getOneBook(id);
//	}
	
	@PutMapping ("/update/{bno}")
	public void updateBook(@PathVariable int bno,@RequestBody Book b)
	{
		
		
	}
	
	@DeleteMapping ("/delete/{bno}")
	public void deleteBook(@PathVariable int bno)
	{
		bs.deleteBook(bno);
	}
}
