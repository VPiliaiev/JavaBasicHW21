package com.gmail.valeriipiliaiev;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int errorCount = 0;

        while (errorCount < 3) {
            try {
                System.out.print("Enter login: ");
                String login = scanner.nextLine();

                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                System.out.print("Confirm password: ");
                String confirmPassword = scanner.nextLine();

                User user = new User(login, password, confirmPassword);

                System.out.println("User created successfully!");
                break;
            } catch (WrongLoginException | WrongPasswordException e) {
                errorCount++;
                System.out.println("Error: " + e.getMessage());

                if (errorCount == 3) {
                    System.out.println("Maximum number of attempts reached. Exiting program.");
                    break;
                }
            }
        }

        System.out.println("Thank you for using our service.");
    }
}
