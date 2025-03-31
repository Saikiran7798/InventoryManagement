package com.Assignment.InventoryManagement.service;

import com.Assignment.InventoryManagement.model.Item;

import java.util.List;

public interface ItemService {
    public Item addItem(Item item);

    public List<Item> getAllItems();

    public Item getItemById(long id);

    public Item updateItemQuantity(long id, int quantity);

    public List<Item> getItemByName(String name);

    public Item sellItem(long id);

    public Item deleteItem(long id);

    public List<Item> getItemsByCategory(Item.Category category);

    public List<Item> getItemsByStatus(Item.Status status);

    public List<Item> getItemsByPriceRange(double min, double max);

    public List<Item> getItemsBySoldCount();

    public List<Item> getLowCountItems();

    public List<Item> addBulkItems(List<Item> items);

    public List<Item> deleteBulkItems(List<Long> id);
}
