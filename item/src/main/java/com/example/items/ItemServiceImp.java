package com.example.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService {

    private ItemRepository itemrepository;

    @Autowired
    public ItemServiceImp(ItemRepository itemrepository){
        this.itemrepository = itemrepository;
        itemrepository.save(new Item("Headphone", 0.1));
        itemrepository.save(new Item("Laptop", 1.0));
    }

    @Override
    public List<Item> getAllItems() {
        return itemrepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemrepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Item createItem(Item item) {
        return itemrepository.save(item);
    }

    @Override
    public Item updateItem(Long id, Item item) {
        Item exsistItem = getItemById(id);
        exsistItem.setPrice(item.getPrice());
        return itemrepository.save(exsistItem);
    }

    @Override
    public void deleteItem(Long id) {

    }
}
