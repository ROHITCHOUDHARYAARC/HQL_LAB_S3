//NAME : ROHIT CHOUDHARY
//REG ID.: 2400031478 
package com.example.SkillExperiment6;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//WE GIVE THE REST CONTROLLER TO THE 
@RestController
//controller are use to response the user requests
public class LibraryController {
	// here /welcome is knows as the endpoints 
	// it runs over the tomcat server , server have the port numbers 
	
	// to runs this code in browser use this "localhost:8071/endpoints"
	@GetMapping("/welcome")
	public String show()
	{
		return "Welcome to SpringBoot by RKC";
	}
	
	@GetMapping("/count")
	public int totalbook()
	{
		return 3241;
	}
	
	@GetMapping("/price")
	public double bookprice()
	{
		return 26536.92;
	}
	
	@GetMapping("/books")
	public List<String> booktitle()
	{
		List<String> titles=new ArrayList<>();
		titles.add("Full Stack Dev");
		titles.add("Begginers Books");
		
		return titles;
	}
	
	
	
	String arr[]= {"React","JAva"};
	@GetMapping("/boook")
	public List<String> bookstitle()
	{
		return Arrays.asList(arr);
	}	
	
//	6. Create a method mapped to /books/{id} using @GetMapping and return book details using 
//			@PathVariable. it is used to retrieve the dynamic variables as user send some data from the address bar 
	// dynamic calue are written in {} under the endpoints
	// while browsing we dont use {} while passing the dynamic value 
	
	@GetMapping("/books/{id}") 
	public String bookDetails(@PathVariable int id)
	{
		return "Book Details are fetched:s " +  id;
	}
	
	
//	7. Create a method mapped to /search using @GetMapping that accepts a request parameter 
//	(title) and returns a confirmation message. 
	
	@GetMapping("/author/{name}")
	public String getAuthor(@PathVariable String name)
	{
		return "The Author name :"+ name;
	}
	
	
//	8. Create a method mapped to /author/{name} using @GetMapping that returns a formatted 
//	message with the author’s name. 
	
	// "("/author/{name}")" te {} this knows path variable
	//queryparameter 
	
	@GetMapping("/author")
	public String getAuthorQueryPArameter( @RequestParam int eno)
	{
		return "The author name :"+eno;
	}
	//it run like localhost:8071/author?eno=101 this its query paramter 
	
//	9. Create a method mapped to /addbook using @PostMapping that accepts a Book object 
//	from the request body and adds it to an in-memory list. 
	
	List<Book> booklist =new ArrayList<Book>();
	//
	
	@PostMapping ("/addbook")
	public String addBook( @RequestBody Book b)
	{
		booklist.add(b);
		return "Book " + b + " succesfully added";	
		
	}
//	10. Create a method mapped to /viewbooks using @GetMapping that returns all added Book 
//	objects. 
	@GetMapping("/viewbooks")
	public List<Book> displayBooks()
	{
		return booklist;
	}
	
	
}
