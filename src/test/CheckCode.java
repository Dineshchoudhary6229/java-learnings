package com.decipher.dinesh;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckCode {
    public static void main(String[] args) {
        int a= 10;
        int b = a++ + ++a;
        System.out.println(b);
    }
}
