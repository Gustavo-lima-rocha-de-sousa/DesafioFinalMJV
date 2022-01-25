package mjv.spring.web.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan
@ComponentScan
@EnableJpaRepositories
@EnableTransactionManagement
public class EasyJobSpringWebMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyJobSpringWebMvcApplication.class, args);
	}

}
