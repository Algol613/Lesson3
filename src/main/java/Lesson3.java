import java.util.Arrays;
import java.util.stream.IntStream;

    public class Lesson3 {

        public static void main(String[] args) {

            int[] array1 = {1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0};
            printArray1("1. Before:\t", array1);
            change(array1);
            printArray1("1. After:\t", array1);

            System.out.println("**********");


            int[] array2 = new int[100];
            fillIn(array2);
            printArray1("2. Filled with cycle:\t", array2);

            System.out.println("**********");


            int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            printArray1("3. Before:\t", array3);
            doubling(array3);
            printArray1("3. After:\t", array3);

            System.out.println("**********");


            int side = 10;
            int[][] array4 = new int[side][side];
            crossFill(array4);
            printArray2("4. Result fill diagonals", array4);


            int[] returnArrayFromMethod = returnArray(10, 999);
            printArray1("5. Array from method", returnArrayFromMethod);

            printArray1("6. Find min & max in array\t", array3);
            System.out.println("6. Minimum: " + findMin(array3));
            System.out.println("6. Maximum: " + findMax(array3));

            int[] balance = {15, 7, 10, 11, 1};
            System.out.print("6. Is the " + Arrays.toString(balance) + " balanced? ");
            System.out.println(checkBalance(balance));
        }


        public static void printArray1(String msg, int[] inputArray) {
            System.out.print(msg + ": ");
            for (int j : inputArray) {
                System.out.print(j + " ");
            }
            System.out.println();
        }


        public static void printArray2(String msg, int[][] inputArray) {
            System.out.println(msg);
            for (int[] ints : inputArray) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        }

        public static void change(int[] array) {
            for (int i = 0; i < array.length; i++)
                if (array[i] == 1) {
                    array[i] = 0;
                } else {
                    array[i] = 1;
                }

        }

        public static void fillIn(int[] array) {
            for (int i = 0; i < array.length; i++)
                array[i] = i + 1;
        }

        public static void doubling(int[] array) {
            for (int i = 0; i < array.length; i++)
                if (array[i] < 6)
                    array[i] *= 2;
        }

        public static void crossFill(int[][] arr) {
            IntStream.range(0, arr.length).forEach(i -> {
                arr[i][i] = 1;
                arr[i][arr.length - 1 - i] = 1;
            });
        }

        public static int[] returnArray(int len, int initValue) {
            int[] tempArray = new int[len];
            Arrays.fill(tempArray, initValue);

            return tempArray;
        }

        private static int findMin(int[] array) {
            int min = array[0];
            for (int j : array) {
                if (j < min) {
                    min = j;
                }
            }
            return min;
        }

        public static int findMax(int[] array) {
            int max = array[0];
            for (int j : array)
                if (j > max) {
                    max = j;
                }
            return max;
        }

        private static boolean checkBalance(int[] array) {
            int right = 0, left = 0;
            for (int i = 0; i < array.length - 1; i++) {
                left += array[i];
                for (int j = i + 1; j < array.length; j++)
                    right += array[j];
                if (left == right) return true;
                right = 0;
            }
            return false;
        }
    }



