package com.java.nov_25.lambda;

interface sayHello {
    String sayHello();
}
interface Dog{
    String eat();
}

public class LambdaNoParameter {
    public static void main(String[] args) {
        sayHello s = () -> {
            return "i have something to sya";
        };
        System.out.println(s.sayHello());

        // dog
        Dog d= ()->{
            return "Dog want some food to eat !";
        };
        System.out.println(d.eat());

    }
}
