package com.java.optional;

import java.util.Optional;



public class UsersOptional {

    private int id;
    private String name;
    private String address;

    public UsersOptional(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public String getName(String name)
    {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }


    @Override
    public String toString() {
        return "UsersOptional{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {

        UsersOptional usersOptional = new UsersOptional(123, "Anand", "Patna");

        Optional<UsersOptional> users = Optional.ofNullable(usersOptional);
        System.out.println(users);

        users.ifPresent(s-> System.out.println("Users: "+s.getId()+" :"+s.getName()+" :"+s.getAddress()));

        //use of map
        System.out.println(users.map(s->Optional.of(s.getName())));
        //users


    }
}
