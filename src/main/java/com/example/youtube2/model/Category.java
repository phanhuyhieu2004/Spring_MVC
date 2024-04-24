package com.example.youtube2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="category")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
