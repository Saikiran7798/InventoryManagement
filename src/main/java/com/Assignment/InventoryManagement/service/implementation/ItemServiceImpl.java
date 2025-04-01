package com.Assignment.InventoryManagement.service.implementation;

import com.Assignment.InventoryManagement.ExceptionHandler.CustomExceptions;
import com.Assignment.InventoryManagement.model.Item;
import com.Assignment.InventoryManagement.repo.ItemRepository;
import com.Assignment.InventoryManagement.service.ItemService;
import org.springframework.transaction.annotation.Transactional;  // ✅ Correct
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        try {
            return itemRepository.save(item);
        } catch (Exception e) {
            throw new CustomExceptions.ItemMissingFieldException("Error while adding new item, Error:" + e);
        }
    }

    @Override
    public List<Item> getAllItems() {
        if (!itemRepository.findAll().isEmpty()) {
            return itemRepository.findAll();
        } else {
            throw new CustomExceptions.ItemNotFoundException("Items Table is Empty");
        }
    }


    @Override
    public Item getItemById(long id) {
        return itemRepository.findById(id).orElseThrow(() -> new CustomExceptions.ItemNotFoundException("Item Not Found with ID " + id));
    }

    @Override
    public Item updateItemQuantity(long id, int quantity) {
        Item itemToUpdate = itemRepository.findById(id).orElseThrow(() -> new CustomExceptions.ItemNotFoundException("Item Not Found with ID" + id));
        itemToUpdate.setQuantity(quantity);
        if (itemToUpdate.getQuantity() > 0) {
            itemToUpdate.setStatus(Item.Status.Available);
        }
        if (itemToUpdate.getQuantity() == 0) {
            itemToUpdate.setStatus(Item.Status.NotAvailable);
        }
        try {
            return itemRepository.save(itemToUpdate);
        } catch (Exception e) {
            throw new CustomExceptions.ItemMissingFieldException("Error while adding new item " + e);
        }
    }

    @Override
    public List<Item> getItemByName(String name) {
        if (!itemRepository.findItemByName(name).isEmpty()) {
            return itemRepository.findItemByName(name);
        } else {
            throw new CustomExceptions.ItemNotFoundException("Item Not Found with Name " + name);
        }
    }

    @Override
    public Item sellItem(long id) {
        Item itemToSell = itemRepository.findById(id).orElseThrow(() -> new CustomExceptions.ItemNotFoundException("Item Not Found with ID" + id));
        if (itemToSell.getQuantity() == 0) {
            throw new CustomExceptions.ItemNotAvailableException("Item is not available");
        } else {
            itemToSell.setQuantity(itemToSell.getQuantity() - 1);
            if (itemToSell.getQuantity() == 0) {
                itemToSell.setStatus(Item.Status.NotAvailable);
            }
            itemRepository.save(itemToSell);
            return itemToSell;
        }
    }

    @Override
    public Item deleteItem(long id) {
        Item itemToDelete = itemRepository.findById(id).orElseThrow(() -> new CustomExceptions.ItemNotFoundException("Item Not Found with ID" + id));
        itemRepository.delete(itemToDelete);
        return itemToDelete;
    }

    @Override
    public List<Item> getItemsByCategory(Item.Category category) {
        if (!itemRepository.findItemByCategory(category).isEmpty()) {
            return itemRepository.findItemByCategory(category);
        } else {
            throw new CustomExceptions.ItemNotFoundException("Item Not Found with Category " + category);
        }
    }

    @Override
    public List<Item> getItemsByStatus(Item.Status status) {
        if (!itemRepository.findItemByStatus(status).isEmpty()) {
            return itemRepository.findItemByStatus(status);
        } else {
            throw new CustomExceptions.ItemNotFoundException("Item Not Found with Status " + status);
        }
    }

    @Override
    public List<Item> getItemsByPriceRange(double min, double max) {
        if (!itemRepository.findItemByPriceRange(min, max).isEmpty()) {
            return itemRepository.findItemByPriceRange(min, max);
        } else {
            throw new CustomExceptions.ItemNotFoundException("Items Not Found with Price Range $" + min + " to $" + max);
        }
    }

    @Override
    public List<Item> getItemsBySoldCount() {
        if (!itemRepository.sortBySoldCount().isEmpty()) {
            return itemRepository.sortBySoldCount();
        } else {
            throw new CustomExceptions.ItemNotFoundException("Item Not Found with Sold Count");
        }
    }

    @Override
    public List<Item> getLowCountItems() {
        if (itemRepository.findByLowQuantity().isEmpty()) {
            throw new CustomExceptions.EmptyLowCountException("There are no Items whose Quantity is Less that '10'");
        } else {
            return itemRepository.findByLowQuantity();
        }
    }

    @Override
    public List<Item> addBulkItems(List<Item> items) {
        for (Item item : items) {
            try {
                itemRepository.save(item);
            } catch (Exception e) {
                throw new CustomExceptions.ItemMissingFieldException("Error while adding a item in the list of items, Rolling Back whole Items");
            }
        }
        return items;
    }

    @Override
    public List<Item> deleteBulkItems(List<Long> id) {
        List<Item> items = new ArrayList<>();
        for (Long itemId : id) {
            Item itemToDelete = itemRepository.findById(itemId).orElseThrow(() -> new CustomExceptions.ItemNotFoundException("Item Not Found with ID " + itemId + "Rolling Back all deletes"));
            itemRepository.delete(itemToDelete);
            items.add(itemToDelete);
        }
        return items;
    }
}
