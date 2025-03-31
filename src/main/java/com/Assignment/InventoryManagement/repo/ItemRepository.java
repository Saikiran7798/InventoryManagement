package com.Assignment.InventoryManagement.repo;

import com.Assignment.InventoryManagement.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
