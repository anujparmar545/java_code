package first;

// Java program to print n-th number in Recaman's
// sequence
import java.io.*;

class Recamann_Sequence {

    // Prints first n terms of Recaman sequence
    static void recaman(int n) {
        // Create an array to store terms
        int arr[] = new int[n];

        // First term of the sequence is always 0
        arr[0] = 0;
        System.out.print(arr[0] + " ,");

        // Fill remaining terms using recursive
        // formula.
        for (int i = 1; i < n; i++) {
            int curr = arr[i - 1] - i;
            int j;
            for (j = 0; j < i; j++) {
                // If arr[i-1] - i is negative or
                // already exists.
                if ((arr[j] == curr) || curr < 0) {
                    curr = arr[i - 1] + i;
                    break;
                }
            }

            arr[i] = curr;
            System.out.print(arr[i] + ", ");

        }
    }

    // Driver code
    public static void main(String[] args) {
        int n = 17;
        int prev = 0;
        recaman(n);

    }
}
// 0 ,1, 3, 6, 2, 7, 13, 20, 12, 21, 11, 22, 10, 23, 9, 24, 8,
