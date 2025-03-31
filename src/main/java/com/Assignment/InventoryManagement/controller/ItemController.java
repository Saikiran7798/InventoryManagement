package com.Assignment.InventoryManagement.controller;

import com.Assignment.InventoryManagement.model.Item;
import com.Assignment.InventoryManagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(@Autowired ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public List<Item> getItems() {
        return itemService.getAllItems();
    }

    @PostMapping("/addItem")
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @GetMapping("/id/{id}")
    public Item getItem(@PathVariable long id) {
        return itemService.getItemById(id);
    }

    @PatchMapping("/updateQuantity/{id}")
    public Item updateItemQuantity(@PathVariable long id, @RequestParam int quantity) {
        return itemService.updateItemQuantity(id, quantity);
    }

    @GetMapping("/name/{name}")
    public List<Item> getItemByName(@PathVariable String name) {
        return itemService.getItemByName(name);
    }

    @PutMapping("/sell/{id}")
    public Item sellItem(@PathVariable long id) {
        return itemService.sellItem(id);
    }

    @DeleteMapping("/delete/{id}")
    public Item deleteItem(@PathVariable long id) {
        return itemService.deleteItem(id);
    }

    @GetMapping("/category")
    public List<Item> getItemsByCategory(@RequestParam Item.Category category) {
        return itemService.getItemsByCategory(category);
    }

    @GetMapping("/status")
    public List<Item> getItemsByStatus(@RequestParam Item.Status status) {
        return itemService.getItemsByStatus(status);
    }

    @GetMapping("/priceRange")
    public List<Item> getItemsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return itemService.getItemsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/soldCount")
    public List<Item> getItemsBySoldCount() {
        return itemService.getItemsBySoldCount();
    }

    @GetMapping("/lowCount")
    public List<Item> getItemsByLowCount() {
        return itemService.getLowCountItems();
    }

    @PostMapping("/bulkAdd")
    public List<Item> addBulkItems(@RequestBody List<Item> items) {
        return itemService.addBulkItems(items);
    }

    @DeleteMapping("/bulkDelete")
    public List<Item> deleteBulkItems(@RequestBody List<Long> ids) {
        return itemService.deleteBulkItems(ids);
    }


}
