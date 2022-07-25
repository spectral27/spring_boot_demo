package individual.webkafkabrokerconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RecordListener {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@KafkaListener(topics = "defaultTopic", groupId = "individual")
	public void recordListener(String message) throws JsonMappingException, JsonProcessingException {
		Record record = objectMapper.readValue(message, Record.class);
		System.out.println(record.getId());
		System.out.println(record.getContent());
	}

}
