package coms.java.lambda.main;

import coms.java.lambda.interfc.SamosaInterface;

public class SamosaMain
{
    public static void main(String[] args) {

        SamosaInterface s= (price)->{
            return price;
        };
        int samosaPrice = s.samosa(14);
        System.out.println("samosaPrice :"+samosaPrice);


        SamosaInterface q= (quantity)->{
            return quantity;
        };
        int quantity = q.samosa(2);
        System.out.println("Quantity: "+quantity);

        SamosaInterface name= (samosaName)->{
           return samosaName;
        };
        int samosa = name.samosa(1);
        System.out.println(samosa);
    }
}
