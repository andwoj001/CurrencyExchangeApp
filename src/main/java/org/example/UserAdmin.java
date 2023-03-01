package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.example.UsersList.usersList;

public class UserAdmin extends User{

    static Scanner scan = new Scanner(System.in);

    //UserAdmin user = new UserAdmin("Admin", 111222, "Admin123");

    public static int userIndex;

    public UserAdmin(String userName, int userNumber, String userPassword) {
        super(userName, userNumber, userPassword);
    }

    public static void displayAdminPanelMenu() {
        int selection = 001;

        do {

            boolean isCatch;
            do {
                try {
                    isCatch = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("*** Admin panel ***");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdrawal");
                    System.out.println("3. Check account balance");
                    System.out.println("4. Check account balance history");
                    System.out.println("5. Currency exchange");
                    System.out.println("6. Add new user");
                    System.out.println("7. Remove user");
                    System.out.println("0. Cancel to previous menu");

                    selection = scan.nextInt();
                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);

            switch (selection) {
                case 1:
                    Menu.depositMenu();
                    break;
                case 2:
                    Menu.withdrawalMenu();
                    break;
                case 3:
                    Menu.checkAccountBalanceMenu();
                    break;
                case 4:
                    Menu.checkAccountBalanceHistoryMenu();
                    break;
                case 5:
                    Menu.currencyToBeExchangeMenu();
                    break;
                case 6:
                    addNewUser();
                    break;

                case 7:
                    removeUser();

                    break;

                case 0:
                    Menu.clientNumber = 0;
                    Menu.clientPassword = "0";
                    Menu.mainMenu();
                    break;
            }
        } while (selection < 0 || selection > 7);
    }

    public static void addNewUser() {
        userIndex = userIndex + 1;

        String userName;
        int userNumber;
        String userPassword;

            boolean isCatch;
            do {
                try {
                    isCatch = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Enter user name: ");
                    userName = scan.next();
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Enter user number: ");
                    userNumber = scan.nextInt();
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Enter user password: ");
                    userPassword = scan.next();

                    UserAdmin newUser = new UserAdmin(userName, userNumber, userPassword);
                    System.out.println("New user created");
                    usersList.add(newUser);
                    System.out.println("User " + userIndex + " added to the list.");

                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);
            displayAdminPanelMenu();
    }

    public static void removeUser() {
        userIndex = userIndex + 1;

        int userNumber;

        boolean isCatch;
        do {
            try {
                isCatch = false;
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Enter user number which will you want to delete: ");
                userNumber = scan.nextInt();
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                int finalUserNumber = userNumber;
                System.out.println(UsersList.usersList.get(0).userName);
                UsersList.usersList.removeIf(newUser -> newUser.userNumber == finalUserNumber);
                System.out.println("User" + userNumber + "was deleted");
                displayAdminPanelMenu();
            } catch (InputMismatchException e) {
                isCatch = true;
                scan.nextLine();
            }
        } while (isCatch == true);

    }



}
