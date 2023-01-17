package com.ducktem.ducktemapi.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ToString
// @Getter
public class Product {

    private int id;
    @NotNull(message = "name 속성 null일 수 없다 ;;")
    private String name;
    private int price;

    // public Product(int id, String name, int price) {
    //     this.id = id;
    //     this.name = name;
    //     this.price = price;
    // }


    // public int getId() {
    //     return id;
    // }


    // public String getName() {
    //     return name;
    // }


    // public int getPrice() {
    //     return price;
    // }


    // public void setId(int id) {
    //     this.id = id;
    // }


    // public void setName(String name) {
    //     this.name = name;
    // }


    // public void setPrice(int price) {
    //     this.price = price;
    // }


    // @Override
    // public String toString() {
    //     return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    // }

}

