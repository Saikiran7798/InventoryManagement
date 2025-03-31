package com.Assignment.InventoryManagement.repo;

import com.Assignment.InventoryManagement.model.Item;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    public List<Item> findItemByName(String name);
    public List<Item> findItemByCategory(Item.Category category);
    public List<Item> findItemByStatus(Item.Status status);

    @Query("select item from Item item where item.price>= : minPrice and item.price <= :maxPrice")
    public List<Item> findItemByPriceRange(double minPrice, double maxPrice);

    @Query("select item from Item item order by item.soldCount desc ")
    public List<Item> sortBySoldCount();

    @Query("select item from Item item where item.quantity <= 10 order by item.quantity")
    public List<Item> findByLowQuantity();
}
