package processor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        boolean exit = true;

        while (exit) {

            Matrixes.printAvailableActions();
            int n = Matrixes.chooseAction(scan.nextInt());
            if (n == 0) {
                exit = false;
            }
        }

    }
}







