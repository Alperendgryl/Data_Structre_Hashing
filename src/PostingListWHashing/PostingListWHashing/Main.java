package pkg2102_project2_p2.pkg6;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner A = new Scanner(System.in);
        HashTable chash = new HashTable(10);
        chash.readFiles();

        while (true) {
            System.out.println("\n1) Display Hash Table.\n"
                    + "2) Search any word\n"
                    + "3) Learn Hash\n"
                    + "4) Quit");
            System.out.print("Select an option : ");
            int option = A.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\n-----HASH TABLE-----");
                    chash.Display_All();
                    break;
                case 2:
                    System.out.print("Enter the word that you want to search : ");
                    String searching = A.next();
                    chash.Which_File_Contains(searching);
                    break;
                case 3:
                    System.out.print("Enter the Data : ");
                    String x = A.next();
                    chash.learnHash(x);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}