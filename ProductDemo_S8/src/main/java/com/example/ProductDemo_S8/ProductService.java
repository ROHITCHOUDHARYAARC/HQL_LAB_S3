//Name : ROHIT CHOUDHARY
// REG NO.: 2400031478
package com.example.ProductDemo_S8;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.service.registry.ImportHttpServices;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository pr;
	
	
	List <Product> findByCategory(String category)
	{
		return pr. findByCategory( category);
	}

}
