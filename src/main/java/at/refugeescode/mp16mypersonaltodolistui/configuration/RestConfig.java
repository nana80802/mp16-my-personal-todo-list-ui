package at.refugeescode.mp16mypersonaltodolistui.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}