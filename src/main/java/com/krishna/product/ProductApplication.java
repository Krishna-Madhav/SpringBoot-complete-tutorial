package com.krishna.product;

import com.krishna.product.test_learning.MyApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {

        SpringApplication.run(ProductApplication.class, args);

        /*   //Old code

        ApplicationContext applicationContext = SpringApplication.run(ProductApplication.class, args);

		MyApp bean = applicationContext.getBean(MyApp.class);
		bean.run();
	*/

    }

}
