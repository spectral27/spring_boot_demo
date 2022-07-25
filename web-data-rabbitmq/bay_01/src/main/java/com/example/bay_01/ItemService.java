package com.example.bay_01;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> selectAllItems() {
		return itemRepository.findAll();
	}
	
	public Item insertItem(Item item) {
		item.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 16));
		item.setOrigin("Bay 1");
		return itemRepository.save(item);
	}

}
