package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
public class AdminApp {

	public static void main(String[] args) {
		SpringApplication.run(AdminApp.class, args);
	}
}