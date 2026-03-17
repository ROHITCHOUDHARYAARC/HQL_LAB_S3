//Name : ROHIT CHOUDHARY
// REG NO.: 2400031478
package com.example.ProductDemo_S8;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//METHODS ARE FIRST DEFINED IN REPOSITORY CLAASS
public interface ProductRepository extends JpaRepository<Product,Integer> {
	// a. findByCategory(String category) 
	
		List <Product> findByCategory(String category);
			
			
	//b. findByPriceBetween(double min, double max)
		 
		List <Product>findByPriceBetween(double min, double max);
		

//		a. Sorting products by price 
		// IN DBMS : SELECT* FROM Product ORDER BY Price ASC/DESC
		@Query("select p from Product p order by p.price ASC")
		List<Product> getByPrice();
		
		
//		  b. Fetching products above a price value 
		// IN DBMS : SELECT* FROM Product WHERE Price > userValue
		@Query("select p from Product p where p.price>:price")
		//@PAram is differnt with @requestPAramnett , RequestPAramter is used in controller class to request the parameter
		List<Product> getAbovePrice(@Param("price") float price);
		
//		  c. Fetching products by category
		//DBMS: SELECT * FROM Product WHERE category=usercategory 
		@Query("select p from Product p where p.category=:category")//"   p.category=:category  THIS ARE NAMED PARAMETER"
		List<Product>  getByCategory(@Param("category")String category);

		
		
}
