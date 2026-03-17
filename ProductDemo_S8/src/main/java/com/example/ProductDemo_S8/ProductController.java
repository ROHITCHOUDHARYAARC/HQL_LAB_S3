//Name : ROHIT CHOUDHARY
// REG NO.: 2400031478
package com.example.ProductDemo_S8;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping ("/products")
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	//a. 	product/category//category
	@GetMapping("/category/{category}")
	public List <Product>  getProduct(@PathVariable String category)
	{
		return ps.findByCategory(category);
	}
	
	
	// /product/filter?min=&max=
	@GetMapping("/filter")
	public void getProductsByRange(@RequestParam float min, @RequestParam float max) 
	{
		
	}
}