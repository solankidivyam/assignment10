import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;
import java.util.Collections;
import java.lang.*;


// Java program for implement deletion in Heaps
public class deletionHeap {

    // To heapify a subtree rooted with node i which is
    // an index in arr[].Nn is size of heap
    static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    static void buildHeap(int arr[], int n)
    {
        // Index of last non-leaf node
        int startIdx = (n / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }


    // Function to delete the root from Heap
    static int deleteRoot(int arr[], int n)
        {
            // Get the last element
            int lastElement = arr[n - 1];

            // Replace root with first element
            arr[0] = lastElement;

        // Decrease size of heap by 1
        n = n - 1;

        // heapify the root node
        heapify(arr, n, 0);

        // return new size of Heap
        return n;
    }

    /* A utility function to print array of size N */
    static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver Code
    public static void main(String args[])
    {
//        int arr[] = { 10, 5, 3, 2, 4 };

        int[] val = new int[10];
        for (int i = 0; i < val.length; i++) {
            val[i] = new Random().nextInt(10000);

        }

        int n = val.length;
        //Building the heap

        Arrays.sort(val);

//        for (int i = 0; i < val.length; i++) {
//            val[i] = val[i] * (-1);
//        }
//
//        Arrays.sort(val);
//
//        for (int i = 0; i < val.length; i++) {
//            val[i] = val[i] * (-1);
//        }

        buildHeap(val, n);
        printArray(val, n);

        long startTime = System.nanoTime();

//        for(int i=0;i<val.length;i++) {
//            n = deleteRoot(val, n);
//        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Time in Microseconds : " + totalTime / 1000);

//        printArray(val, n);
    }
}
