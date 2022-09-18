package individual.rabbitmqamqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitmqAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqAmqpApplication.class, args);
	}

}
