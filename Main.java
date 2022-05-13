
/******************************************************************
Author: GOnzalo Santizo

Main file for floyd warshall implementation
******************************************************************/
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {

            System.out.println("\n\nWelcome where do you want to go?");
            System.out.println("1. Go to a new city (Enter origen and destination)");
            System.out.println("2. Show center of graph");
            System.out.println("3. Modify map (graph)");
            System.out.println("4. Exit\n\n");

            opcion = scan.nextInt();

            if (opcion == 1) {
                // Ask for origen and destination
            } else if (opcion == 2) {
                // Show center of graph
            } else if (opcion == 3) {
                // Modify current graph
            } else if (opcion == 4) {
                // Exit
            }
        }
    }
}