package com.imedia24.store;

import com.imedia24.store.product.Product;
import com.imedia24.store.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}


	/*@Component
	public class StartupRunner implements CommandLineRunner {

		@Autowired
		private ProductService productService;

		@Override
		public void run(String... args) throws Exception {
			Product fakeProduct = productService.generateFakeProduct();
			// Save fakeProduct to your database or use it as needed
		}
	}*/
}
