package com.java.stream.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Product {

    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {

        List<Product>productList=new ArrayList<>();
        productList.add(new Product(142,"Sabun",234));
        productList.add(new Product(121,"Koyla",352));
        productList.add(new Product(134,"Makhan",132));
        productList.add(new Product(23,"Puri",453));
        productList.add(new Product(12,"Sabji",221));
        productList.add(new Product(26,"Dal",653));

        System.out.println("=====id with condition======");
        productList.stream().filter(p -> p.id > 121).forEach(System.out::println);

        System.out.println("=====all ids only with condition=====");
        productList.stream().filter(p -> p.id > 121).map(c -> c.id).forEach(System.out::println);

        System.out.println("=====all ids only=====");
        productList.stream().map(Product::getId).forEach(System.out::println);
        System.out.println("========sorted id====");
        productList.stream().map(Product::getId).sorted().forEach(System.out::println);

        System.out.println("=====all record=====");
        productList.stream().collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("======all records order by based on id");
        productList.stream().sorted((p1,p2)->Integer.compare(p1.getId(), p2.getId())).forEach(System.out::println);
        System.out.println("=====only name sorted based on id");
        productList.stream().sorted((p1,p2)->Integer.compare(p1.getId(), p2.getId())).forEach(p->System.out.println(p.getName()));
        System.out.println("=====only name sorted based on price");
        productList.stream().sorted((p1,p2)->Float.compare(p1.getPrice(), p2.getPrice())).forEach(p->System.out.println(p.getName()));

        System.out.println("=====only name sorted based on name");
        productList.stream().sorted((p1,p2)->p1.getName().compareTo(p2.getName())).forEach(p->System.out.println(p.getName()));

        System.out.println("=====only price conditionally====");
        productList.stream().filter(p->p.getPrice()>300).map(p->p.getPrice()).forEach(System.out::println);

        System.out.println("=====only maximum price with all record======");
        productList.stream().max((p1,p2)->Float.compare(p1.getPrice(), p2.getPrice())).ifPresent(System.out::println);



    }
}
