package com.java.nov_25.lambda;

interface Hello{
    String say(String name);
}
public class LambdaSingleParameter {
    public static void main(String[] args) {

        Hello h=(name)->{
            return "Hello "+name;
        };
        System.out.println(h.say("Tommy"));

    }
}
