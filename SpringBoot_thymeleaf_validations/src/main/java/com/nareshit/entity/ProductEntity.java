package com.nareshit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Integer id;
   @NotBlank(message="name should not be empty")
   @Size(min=2, max=15, message="name should have only 3 to 15 characters") 
   private String name;
   @NotNull(message="price should not be empty")
   @Positive(message="price must be positive")
   private Double price;
   @NotNull(message="Quantity should not be empty")
   @Positive(message="Quantity must be positive")
   private Integer Quantity;
   
}
