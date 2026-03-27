package com.java.march_26.streamapi;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Comparator;
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
	
	public static void main(String[] args)
	{
		List<Product> productList = new ArrayList<>();

        productList.add(new Product(1,"Apple",120));
		productList.add(new Product(3,"TV",21200));
        productList.add(new Product(2,"Mobile",12000));
        productList.add(new Product(6,"Fan", 1500));
        productList.add(new Product(4,"Rice",1200));
        productList.add(new Product(5,"Laptop",51205));
		
		System.out.println("=====Find product with given id=====");
		productList.stream().filter(p->p.getId()==3).forEach(System.out::println);
		System.out.println("=====Find product with given id=====not null safe");
		Product productWithIdNotNullSafe = productList.stream().filter(p->p.getId()==2).findFirst().get();
		System.out.println(productWithIdNotNullSafe);
		System.out.println("=====Find product with given id===== null safe");
		Optional<Product>productWithIdNullSafe = productList.stream().filter(p->p.getId()==4).findFirst();
		System.out.println(productWithIdNullSafe);
		System.out.println("======All id's >2=====");
		productList.stream().filter(p->p.getId()>2).map(Product::getId).forEach(System.out::println);
		System.out.println("============All Id's==============");
		productList.stream().map(Product::getId).forEach(System.out::println);
		System.out.println("=======By name=========");
		productList.stream().filter(p->p.getName()=="Fan").forEach(System.out::println);
		System.out.println("=======By name=========not null safe");
		Product productByNameNotNullSafe = productList.stream().filter(p->p.getName()=="Rice").findFirst().get();
		System.out.println(productByNameNotNullSafe);
		System.out.println("=======By name=========null safe");
		Optional<Product>productByNameNullSafe = productList.stream().filter(p->p.getName()=="Laptop").findFirst();
		System.out.println(productByNameNullSafe);
		System.out.println("=====all name only=======");
		productList.stream().map(Product::getName).forEach(System.out::println);
		System.out.println("=========All sorted id==========");
		productList.stream().map(Product::getId).sorted().forEach(System.out::println);
		System.out.println("======all record sorted by id======");
		productList.stream().sorted(Comparator.comparing(Product::getId)).forEach(System.out::println);
		System.out.println("=========all sorted name==========");
		productList.stream().map(Product::getName).sorted().forEach(System.out::println);
		System.out.println("=========all record sorted by name==========");
		productList.stream().sorted(Comparator.comparing(Product::getName)).forEach(System.out::println);
		System.out.println("=========all record which price is >? Rs.==========");
		productList.stream().filter(p->p.getId()>3).forEach(System.out::println);
		System.out.println("======highest product price=====");
		Product  productWithHighestPrice = productList.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).skip(0).findFirst().orElse(null);
		System.out.println(productWithHighestPrice);
		System.out.println("======2nd highest product price=====");
		Product productWith2ndHighestPrice = productList.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).skip(1).findFirst().orElse(null);
		System.out.println(productWith2ndHighestPrice);
		System.out.println("======3rd lowest product price=====");
		Product thirdLowestPriceProduct =productList.stream().sorted(Comparator.comparing(Product::getPrice)).skip(2).findFirst().orElse(null);
		System.out.println(thirdLowestPriceProduct);
		System.out.println("========fetch all records sorted by name and then price==========");
		productList.stream().sorted(Comparator.comparing(Product::getName).thenComparing(Product::getPrice)).forEach(System.out::println);
		System.out.println("========product with longest name record==========");
		Product logetsNameProduct= productList.stream().max(Comparator.comparing(p->p.getName().length())).orElse(null);
		System.out.println(logetsNameProduct);
		System.out.println("========sum of all product price==========");
		double sumOfPrice = productList.stream().mapToDouble(Product::getPrice).sum();
		System.out.println(sumOfPrice);
		System.out.println("========average price ==========");
		Double averagePrice =productList.stream().collect(Collectors.averagingDouble(Product::getPrice));
		System.out.println(averagePrice);
		System.out.println("========count price  > ?==========");
		Long countPriceGreater = productList.stream().filter(e->e.getPrice()>1500).count();
		System.out.println(countPriceGreater);
		System.out.println("========fetch 3 highest price product==========");
		Product productWith3rdHighestPrice = productList.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).skip(2).findFirst().orElse(null);
		System.out.print(productWith3rdHighestPrice);
		System.out.println("========convert price list to sorted unique list==========");
		productList.stream().map(Product::getPrice).sorted().distinct().forEach(System.out::println);
		System.out.println("=====print all soretdId=====");
		productList.stream().map(Product::getId).sorted().distinct().forEach(System.out::println);
		
		
		
		
		
		
	}
}
