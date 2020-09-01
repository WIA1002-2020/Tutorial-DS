/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial03;

/**
 *
 * @author muham
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Question 1 a
        int[] arr = {23, 35, 453, 43, 22, 3435, 235};
        int length = arr.length;
        int min = SmallestElement(arr, 0, length);
        System.out.println(min);
        System.out.println("");
        
        //Question 1 b
        int[] arr1 = {12, 23, 44, 53};
        int sum = SumOfElements(arr1, arr1.length);
        System.out.println(sum);
        System.out.println("");

        //Question 1 c
        System.out.println(GreatestCommonDivisor(124, 348));
        System.out.println("");
        
        //Question 1 d
        System.out.println(convertDecToBin(39));
        System.out.println("");
        
        //Question 1 e
        System.out.println(SumOfCubes(6));
        System.out.println("");
        
        //Question 2
        System.out.println(Acker(3, 4));
        System.out.println(Acker(2, 5));
        System.out.println("");

        //Question 3
        writeLine('@', 3);
        writeBlock('^', 3, 2);
        System.out.println("\n");

        //Question 4
        String s = "saya makan nasi lemak masak keli merah";
        try {
            if (s.length() > 12) {
                throw new NewStringException();
            }
        } catch (NewStringException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int SmallestElement(int[] array, int n, int length) {
        int min;
        if (n >= array.length - 2) {
            if (array[n] < array[n + 1]) {
                return array[n];
            } else {
                return array[n + 1];
            }
        }
        min = SmallestElement(array, n + 1, length);
        if (array[n] < min) {
            return array[n];
        } else {
            return min;
        }
    }

    public static int SumOfElements(int[] arr, int N) {
        if (N <= 0) {
            return 0;
        }
        return (SumOfElements(arr, N - 1) + arr[N - 1]);
    }

    public static int GreatestCommonDivisor(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return GreatestCommonDivisor(num2, num1 % num2);
    }

    public static int convertDecToBin(int dec) {
        if (dec == 0) {
            return 0;
        } else {
            return (dec % 2 + 10 * convertDecToBin(dec / 2));
        }
    }

    public static int SumOfCubes(int n) {
        int cube = n * n * n;
        if (n <= 1) {
            return cube;
        }
        return cube + SumOfCubes(n - 1);
    }

    public static int Acker(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (n == 0) {
            return Acker(m - 1, 1);
        } else {
            return Acker(m - 1, Acker(m, n - 1));
        }
    }

    public static void writeLine(char c, int n) {
        if (n == 0) {
            System.out.println();
            return;
        }
        writeLine(c, n - 1);
        System.out.print(c);
    }

    public static void writeBlock(char c, int m, int n) {
        if (n == 0) {
            return;
        }
        writeLine(c, m);
        writeBlock(c, m, n - 1);
    }
}
