package jukeboxremotecontrol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for RestTemplate.
 * RestTemplate is used to make HTTP requests to external APIs.
 */
@Configuration
public class RestTemplateConfig {

    /**
     * Creates a bean for RestTemplate to be used across the application.
     * 
     * @return A new instance of RestTemplate.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
