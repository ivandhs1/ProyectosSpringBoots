package com.products.inits.rest;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.inits.dao.ProductsDAO;
import com.products.inits.entitys.Product;



@RestController
@RequestMapping("/Products")
public class ProductsREST {
	
	@Autowired
	private ProductsDAO productDAO;
	
	@GetMapping("Hello")
	//@RequestMapping(value="hello",method=RequestMethod.Get)
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("product1")
	public ResponseEntity<Product> getProduct(){
		Product product = new Product();
		product.setId(1L);
		product.setName("Product 1");
		return ResponseEntity.ok(product);
	}
	
	@GetMapping("products")
	public ResponseEntity<List<Product>> getProducts(){
		List<Product> products = productDAO.findAll();
		return ResponseEntity.ok(products);
		
	}
	
	@GetMapping("{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId){
		Optional<Product> optionalProduct = productDAO.findById(productId);
		
		if(optionalProduct.isPresent()) {
			return ResponseEntity.ok(optionalProduct.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product newProduct = productDAO.save(product);
		return ResponseEntity.ok(newProduct);
	}
	
	@PutMapping
	public ResponseEntity<Product> updateProductById(@RequestBody Product product){
		Optional<Product> optionalProduct = productDAO.findById(product.getId());
		
		if(optionalProduct.isPresent()) {
			Product updateProduct = optionalProduct.get();
			updateProduct.setName(product.getName());
			productDAO.save(updateProduct);
			return ResponseEntity.ok(updateProduct);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{productId}")
	public ResponseEntity<Void> deleteProductById(@PathVariable("productId") Long productId){
		productDAO.deleteById(productId);
		return ResponseEntity.ok(null);
	}
	
	

	
}
