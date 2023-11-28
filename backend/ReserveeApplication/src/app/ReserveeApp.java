package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"app", "app.config"}) 
public class ReserveeApp {

	public static void main(String[] args) {
		SpringApplication.run(ReserveeApp.class, args);
	}
}