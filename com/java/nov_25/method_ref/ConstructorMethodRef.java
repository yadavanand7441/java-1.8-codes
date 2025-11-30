package com.java.nov_25.method_ref;

interface Something{
    Message getMessage(String msg);
}
class Message
{
    Message(String msg)
    {
        System.out.println(msg);
    }
}
public class ConstructorMethodRef {
    public static void main(String[] args) {

        Something m1=Message::new;
        m1.getMessage("Hello, How are you?");
    }
}
