package com.Assignment.InventoryManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, columnDefinition = "int Default 1")
    private int quantity;

    @Column(nullable = false, columnDefinition = "double Default 1")
    private double price;

    @Column(nullable = false)
    private int soldCount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.Available;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    public enum Status {
        Available, NotAvailable,
    }

    public enum Category {
        Clothing, Electronics, Furniture,
    }

}
