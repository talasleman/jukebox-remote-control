package jukeboxremotecontrol;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    String hello() {
        return "Hello my name is Tala";
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
