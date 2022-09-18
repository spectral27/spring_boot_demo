package individual.rabbitmqamqp;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Scheduled(fixedRate = 4000)
	public void publishMessage() {
		Item item = new Item();
		item.setId(UUID.randomUUID().toString().substring(0, 8));
		item.setValue(LocalDateTime.now().withNano(0).toString());
		
		rabbitTemplate.convertAndSend("routingKey", item);
	}

}
