package com.Assignment.InventoryManagement.service.implementation;

import com.Assignment.InventoryManagement.ExceptionHandler.CustomExceptions;
import com.Assignment.InventoryManagement.model.Item;
import com.Assignment.InventoryManagement.repo.ItemRepository;
import com.Assignment.InventoryManagement.service.ItemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(@Autowired ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item addItem(Item item) {
        try{
            return itemRepository.save(item);
        }catch (Exception e){
            throw new IllegalArgumentException("Error while adding new item", e);
        }
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(int id) {
        return itemRepository.findById(id).orElseThrow(() -> new CustomExceptions.ItemNotFoundException("Item Not Found with ID" + id));
    }

    @Override
    public Item updateItemQuantity(int id, int quantity) {
        Item itemToUpdate = itemRepository.findById(id).orElseThrow(() -> new CustomExceptions.ItemNotFoundException("Item Not Found with ID" + id));
        itemToUpdate.setQuantity(quantity);
        try{
            return itemRepository.save(itemToUpdate);
        }catch (Exception e){
            throw new IllegalArgumentException("Error while adding new item", e);
        }
    }

    @Override
    public List<Item> getItemByName(String name) {
        if(itemRepository.findItemByName(name) != null){
            return itemRepository.findItemByName(name);
        } else {
            throw new CustomExceptions.ItemNotFoundException("Item Not Found with Name " + name);
        }
    }

    @Override
    public Item sellItem(int id) {
        Item itemToSell = itemRepository.findById(id).orElseThrow(() -> new CustomExceptions.ItemNotFoundException("Item Not Found with ID" + id));
        if(itemToSell.getQuantity() == 0){
            throw  new CustomExceptions.ItemNotAvailableException("Item is not available");
        }
        else{
            itemToSell.setQuantity(itemToSell.getQuantity() - 1);
            if(itemToSell.getQuantity() == 0){
                itemToSell.setStatus(Item.Status.NotAvailable);
            }
            itemRepository.save(itemToSell);
            return itemToSell;
        }
    }

    @Override
    public Item deleteItem(int id) {
        Item itemToDelete = itemRepository.findById(id).orElseThrow(() -> new CustomExceptions.ItemNotFoundException("Item Not Found with ID" + id));
        itemRepository.delete(itemToDelete);
        return itemToDelete;
    }

    @Override
    public List<Item> getItemsByCategory(Item.Category category) {
        if (itemRepository.findItemByCategory(category) != null){
            return itemRepository.findItemByCategory(category);
        } else {
            throw new CustomExceptions.ItemNotFoundException("Item Not Found with Category " + category);
        }
    }

    @Override
    public List<Item> getItemsByStatus(Item.Status status) {
        if (itemRepository.findItemByStatus(status) != null){
            return itemRepository.findItemByStatus(status);
        }else {
            throw new CustomExceptions.ItemNotFoundException("Item Not Found with Status " + status);
        }
    }

    @Override
    public List<Item> getItemsByPriceRange(double min, double max) {
        if (itemRepository.findItemByPriceRange(min, max) != null){
            return itemRepository.findItemByPriceRange(min, max);
        }else {
            throw new CustomExceptions.ItemNotFoundException("Item Not Found with Price Range $" + min + " to $" + max);
        }
    }

    @Override
    public List<Item> getItemsBySoldCount() {
        if (itemRepository.sortBySoldCount() == null){
            throw new CustomExceptions.ItemNotFoundException("Item Not Found with Sold Count");
        } else {
            return itemRepository.sortBySoldCount();
        }
    }

    @Override
    public List<Item> getLowCountItems() {
        if (itemRepository.findByLowQuantity() == null){
            throw new CustomExceptions.EmptyLowCountException("There are no Items with Low Quantity");
        }
        else {
            return itemRepository.findByLowQuantity();
        }
    }
}
