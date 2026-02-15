package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- SMART CONTACT DIRECTORY ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Delete A Contact");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Type (Work/Personal): ");
                    String type = sc.nextLine().trim();

                    if(type.isEmpty() || sc.equals("Work") || sc.equals("Personal")){
                        type = "Personal";
                    };

                    db.addContact(name, phone, type);
                    break;
                case 2:
                    db.viewContacts();
                    break;
                case 3:
                    System.out.println("Enter contact ID: ");
                    int contactID = sc.nextInt();
                    db.deleteContact(contactID);
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
        sc.close();
    }
}