package com.ing.store.domain.entity;

import com.ing.store.domain.enums.ProductType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.relational.core.mapping.Column;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    Integer id;

    Double price;

    String description;

    ProductType type;

    Integer quantity;
}
