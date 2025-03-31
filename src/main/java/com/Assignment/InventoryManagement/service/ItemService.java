package com.Assignment.InventoryManagement.service;

import com.Assignment.InventoryManagement.model.Item;

import java.util.List;

public interface ItemService {
    public Item addItem(Item item);
    public List<Item> getAllItems();
    public Item getItemById(int id);
    public Item updateItemQuantity(int id, int quantity);
    public List<Item> getItemByName(String name);
    public Item sellItem(int id);
    public Item deleteItem(int id);
    public List<Item> getItemsByCategory(Item.Category category);
    public List<Item> getItemsByStatus(Item.Status status);
    public List<Item> getItemsByPriceRange(double min, double max);
    public List<Item> getItemsBySoldCount();
    public List<Item> getLowCountItems();
}
