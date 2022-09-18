package individual.rabbitmqamqp;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MessageListener {
	
	private static final Logger log = LoggerFactory.getLogger(MessageListener.class);
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@RabbitListener(queues = "routingKey")
	public void receiver(Message message) throws IOException {
		Item itemReceived = objectMapper.readValue(message.getBody(), Item.class);
		
		log.info("Message: {}", itemReceived);
	}

}
