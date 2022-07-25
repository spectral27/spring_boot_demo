package com.example.bay_02;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ListenerService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@RabbitListener(queues = "queue_1_2")
	public void receiveItemFromBay1(Message message) {
		try {
			Item item = objectMapper.readValue(message.getBody(), Item.class);
			itemRepository.save(item);
			System.out.println("Item with id " + item.getId() + " saved in Bay 2.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
