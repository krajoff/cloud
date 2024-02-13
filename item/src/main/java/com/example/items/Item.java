package com.example.items;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="items")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    public Item(String name, Double price) {
        this.name = name;
        this.price = price;
    }

}
