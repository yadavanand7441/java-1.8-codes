package com.java.nov_25.stream_api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        List<Product> productList = new ArrayList<>();

        productList.add(new Product(1,"Apple",120));
        productList.add(new Product(2,"Mobile",12000));
        productList.add(new Product(3,"TV",21200));
        productList.add(new Product(4,"Rice",1200));
        productList.add(new Product(5,"Laptop",51205));

        System.out.println("=====Find product with given id=====");
        productList.stream().filter(p->p.id== 1).forEach(System.out::println);
        //not null safe
        Product product = productList.stream().filter(p -> p.id == 3).findFirst().get();
        System.out.println(product);
        //null safe
        Optional<Product> first = productList.stream().filter(p -> p.getId() == 21).findFirst();
        System.out.println(first);

        System.out.println("======All id's >2=====");
        productList.stream().filter(p->p.id>2).map(m->m.id).forEach(System.out::println);
        // another way
        System.out.println("============All Id's==============");
        productList.stream().map(Product::getId).forEach(System.out::println);

        System.out.println("=======By name=========");
        productList.stream().filter(p->p.name=="Apple").forEach(System.out::println);

        System.out.println("=====all name only=======");
        productList.stream().map(Product::getName).forEach(System.out::println);

        System.out.println("=========All sorted id==========");
        productList.stream().map(Product::getId).sorted().forEach(System.out::println);

        System.out.println("=========all sorted name==========");
        productList.stream().map(Product::getName).sorted().forEach(System.out::println);

        System.out.println("======all record sorted by id======");
        productList.stream().sorted((p1,p2)->Integer.compare(p1.getId(),p2.getId())).forEach(System.out::println);
        System.out.println("======another way=======");
        //another way
        productList.stream().sorted(Comparator.comparing(Product::getId)).forEach(System.out::println);

        System.out.println("=========all record sorted by name==========");
        productList.stream().sorted(Comparator.comparing(Product::getName)).forEach(System.out::println);

        System.out.println("=========all record which price is >150 Rs.==========");
        productList.stream().filter(price->price.getPrice()>150).forEach(System.out::println);

        System.out.println("======highest price product=====");
        Product highestProduct = productList.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).skip(0).findFirst().orElse(null);
        System.out.println(highestProduct);

        System.out.println("======2nd highest price product=====");
        Product secondHighestProduct = productList.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).skip(1).findFirst().orElse(null);
        System.out.println(secondHighestProduct);


        System.out.println("======3rd highest price product=====");
        Product thirdHighestPrice = productList.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).skip(2).findFirst().orElse(null);
        System.out.println(thirdHighestPrice);

        System.out.println("======3rd lowest price product=====");
        Product thirdLastPrice = productList.stream().sorted(Comparator.comparing(Product::getPrice)).skip(0).findFirst().orElse(null);
        System.out.println(thirdLastPrice);

    }
}
