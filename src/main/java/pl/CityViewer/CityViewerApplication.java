package pl.CityViewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("pl.CityViewer")
@EnableJpaRepositories
@EntityScan
@EnableAutoConfiguration
public class CityViewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityViewerApplication.class, args);
	}
}
