package processor;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Matrixes {


    // Creating matrix


    public static double[][] creatingMatrix() {

        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int columns = scan.nextInt();
        double[][] matrix = new double[rows][columns];

        System.out.println("Enter matrix:");


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scan.nextDouble();
            }
        }

        return matrix;

    }

    // Check if matrices are the same size


    public static boolean matricesAreCompatible(double[][] A, double[][] B) {

        boolean compatible = false;

        if (A.length == B.length && A[0].length == B[0].length) {
            compatible = true;
        }
        return compatible;
    }

    // Adding matrices

    public static double[][] matricesAdding(double[][] A, double[][] B) {


        double[][] sumOfMatrices = new double[A.length][A[0].length];

        for (int i = 0; i < sumOfMatrices.length; i++) {
            for (int j = 0; j < sumOfMatrices[i].length; j++) {
                sumOfMatrices[i][j] = A[i][j] + B[i][j];

            }
        }
        return sumOfMatrices;
    }

    // Printing matrices in screen


    public static void printMatrix(double[][] matrix) {

       /* int[][] convertMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < convertMatrix.length; i++) {
            for (int j = 0; j < convertMatrix.length; j++) {
                convertMatrix[i][j] = (int) matrix[i][j];

            }
            
        }*/

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    // Scanning constant


    public static int scanningConstant() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter constant: > ");

        return scan.nextInt();

    }

    // Multiplying matrix by constant


    public static double[][] matrixMultipliedByConstant() {


        double[][] matrix = creatingMatrix();
        int number = scanningConstant();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                matrix[i][j] *= number;
            }
        }
        return matrix;
    }

    // Multiplying matrix by matrix


    public static double[][] multiplyMatrices(double[][] A, double[][] B) {

        double[][] temp = new double[A.length][B[0].length];


        if (A[0].length == B.length) {


            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B[0].length; j++) {
                    for (int k = 0; k < A[0].length; k++) {
                        temp[i][j] += A[i][k] * B[k][j];
                    }
                }
            }

        } else {
            System.out.println("Wrong matrices sizes");
        }
        return temp;
    }


    // Printing available options

    public static void printAvailableActions() {
        System.out.printf("1. Add matrices%c"
                + "2. Multiply matrix by a constant%c"
                + "3. Multiply matrices%c"
                + "4. Transpose matrix%c"
                + "0. Exit%c"
                + "> ", '\n', '\n', '\n', '\n', '\n');
    }


    // Transposing matrix by the main diagonal

    public static void mainTranspose() {

        System.out.println("Enter matrix size: > ");
        double[][] matrix = Matrixes.creatingMatrix();
        double[][] mainTransposeMatrix = new double[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                mainTransposeMatrix[j][i] = matrix[i][j];

            }
        }
        printMatrix(mainTransposeMatrix);
    }

    // Transposing matrix by the side diagonal

    public static void sideTranspose() {

        System.out.println("Enter matrix size: > ");
        double[][] matrix = Matrixes.creatingMatrix();
        double[][] sideTransposeMatrix = new double[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                sideTransposeMatrix[i][j] = matrix[matrix.length - 1 - j][matrix.length - 1 - i];

            }
        }
        printMatrix(sideTransposeMatrix);
    }

    // Transposing matrix by the vertical line

    public static void verticalTranspose() {

        System.out.println("Enter matrix size: > ");
        double[][] matrix = Matrixes.creatingMatrix();
        double[][] verticalTranspose = new double[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                verticalTranspose[i][j] = matrix[i][matrix.length - 1 - j];
            }
        }
        printMatrix(verticalTranspose);
    }

    // Transposing matrix by the horizontal line

    public static void horizontalTranspose() {

        System.out.println("Enter matrix size: > ");
        double[][] matrix = Matrixes.creatingMatrix();
        double[][] horizontalTranspose = new double[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                horizontalTranspose[i][j] = matrix[matrix.length - 1 - i][j];
            }
        }
        printMatrix(horizontalTranspose);
    }

    // Available actions

    public static int chooseAction(int action) {

        switch (action) {

            case 1:

                System.out.print("Enter first matrix size: > ");
                double[][] A = creatingMatrix();
                System.out.print("Enter second matrix size: > ");
                double[][] B = creatingMatrix();

                if (matricesAreCompatible(A, B)) {

                    System.out.println("The result is:");
                    printMatrix(matricesAdding(A, B));
                } else {
                    System.out.println("Wrong size of matrices");
                }
                break;

            case 2:

                System.out.print("Enter size of the matrix: > ");
                double[][] matrix = matrixMultipliedByConstant();
                System.out.println("The result is:");
                printMatrix(matrix);
                break;

            case 3:

                System.out.println("Enter size of first matrix: > ");
                double[][] D = creatingMatrix();
                System.out.println("Enter size of second matrix: > ");
                double[][] E = creatingMatrix();
                System.out.println("The result is:");
                double[][] multipliedMatrix = multiplyMatrices(D, E);
                printMatrix(multipliedMatrix);
                break;

            case 4:
                System.out.printf("1. Main diagonal%c"
                                + "2. Side diagonal%c"
                                + "3. Vertical line%c"
                                + "4. Horizontal line%c"
                                + "> ", '\n','\n','\n','\n');

                Scanner scan = new Scanner(System.in);
                int transpose = scan.nextInt();

                switch (transpose){

                    case 1:
                        mainTranspose();
                        break;
                    case 2:
                        sideTranspose();
                        break;
                    case 3:
                        verticalTranspose();
                        break;
                    case 4:
                        horizontalTranspose();
                        break;
                }


        }
        return action;
    }
}







