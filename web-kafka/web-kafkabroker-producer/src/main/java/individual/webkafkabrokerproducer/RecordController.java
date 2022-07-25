package individual.webkafkabrokerproducer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RecordController {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@PostMapping("/sendrecord")
	public void sendRecord(@RequestBody Record record) throws JsonProcessingException {
		record.setId(UUID.randomUUID().toString().substring(0, 8));
		String json = objectMapper.writeValueAsString(record);
		kafkaTemplate.send("defaultTopic", json);
	}

}
