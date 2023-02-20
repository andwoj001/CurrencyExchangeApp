package org.example;

import java.io.IOException;

import static org.example.Menu.user1;

public class Main {
    public static void main(String[] args){

        if (Excel.checkFileExistence()) {
            Excel.readFromFileIfExists();
        } else {
            try {
                Excel.createNewFileIfNotExists();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(user1.PLN);
        System.out.println(user1.USD);
        System.out.println(user1.EUR);
        System.out.println(user1.CZK);
        System.out.println(user1.NOK);
        System.out.println(user1.DKK);

        Menu.mainMenu();

    }

}
