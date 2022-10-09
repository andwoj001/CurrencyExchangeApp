package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!" + "\n" + "Enter the integer number to be multiplied by itself:");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.println("The result of multiplying this integer number by itself is:" + "\n" + Multiplication.multiplication(number));
    }
}