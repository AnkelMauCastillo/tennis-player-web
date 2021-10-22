package mx.edu.uacm.progweb.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TennisPlayerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerWebApplication.class, args);
	}

}
