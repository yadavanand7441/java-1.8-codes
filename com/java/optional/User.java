package com.java.optional;

import java.util.Optional;

class User {
    private int id;
    private String name;
    private Optional<String> address;  // Address is Optional

    public User(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = Optional.ofNullable(address);  // Wrap address in Optional
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public static void main(String[] args) {
        // Creating User with address
        User userWithAddress = new User(1, "John Doe", "123 Main St, Springfield");


        // Creating User without address
        User userWithoutAddress = new User(2, "Jane Doe", null);

        // Wrapping User objects in Optional
        Optional<User> optionalUserWithAddress = Optional.of(userWithAddress);
        Optional<User> optionalUserWithoutAddress = Optional.of(userWithoutAddress);


        System.out.println(optionalUserWithAddress);

        optionalUserWithAddress
                .ifPresent(user -> System.out.println("Id: "+user.getId()+" : "+user.getName() + " lives at " + user.getAddress().orElse("No address")));

        optionalUserWithoutAddress
                .ifPresent(user -> System.out.println(user.getName() + " lives at " + user.getAddress().orElse("No address")));
    }
}
