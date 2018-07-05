package ash.boot.mvcexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ash.boot.mvcexample.models.Person;
import ash.boot.mvcexample.services.PersonRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
	@Bean
	public CommandLineRunner demo(PersonRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Person("Jack", "Bauer"));
			repository.save(new Person("Chloe", "O'Brian"));
			repository.save(new Person("Kim", "Bauer"));
			repository.save(new Person("David", "Palmer"));
			repository.save(new Person("Michelle", "Dessler"));

			
			// fetch all customers
			log.info("Populated DB with 5 Person's");
		};
	}
}
