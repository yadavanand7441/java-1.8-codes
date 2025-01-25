package com.java;

import java.util.Scanner;

public class TestClass {
    public static void printPermutations(String str, String perm) {
        // Base case: Agar string khatam ho gayi, permutation ko print karo
        if (str.length() == 0) {
            System.out.println(perm);
            return;
        }
        // Recursively find the permutations
        for (int i = 0; i < str.length(); i++) {
            // Current character ko choose karte hain aur usse remove karte hain
            char ch = str.charAt(i);
            String remainingStr = str.substring(0, i) + str.substring(i + 1);

            // Recursive call
            printPermutations(remainingStr, perm + ch);
        }
    }
    public static void main(String []args)
    {
        String str = "ABC";
        printPermutations(str, "");
    }

}
