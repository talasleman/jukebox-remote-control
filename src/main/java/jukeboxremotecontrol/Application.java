package jukeboxremotecontrol;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main application class for Spring Boot application.
 * Contains the main method which starts the application.
 */
@SpringBootApplication
@RestController
public class Application {
     /**
     * The entry point of the Spring Boot application.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
