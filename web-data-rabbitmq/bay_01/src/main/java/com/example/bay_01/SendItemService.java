package com.example.bay_01;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SendItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public String sendItem(String id) {
		Item item = itemRepository.findById(id).get();
		itemRepository.deleteById(id);
		rabbitTemplate.convertAndSend("queue_1_2", item);
		return "Item with id " + item.getId() + " sent to Bay 2.";
	}

}
