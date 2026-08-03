package ProgramSoloUpInGit;

import java.util.Arrays;

public class PartitionArray {

    // ==========================
    // Algorithm 1 : Recursive Partition
    // ==========================
    static void partitionRecursive(int[] a, int k, int left, int right) {

        if (left >= right)
            return;

        while (left < right && a[left] <= k)
            left++;

        while (left < right && a[right] > k)
            right--;

        if (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }

        partitionRecursive(a, k, left, right);
    }

    // ==========================
    // Algorithm 2 : Iterative Partition
    // ==========================
    static void partitionIterative(int[] a, int k) {

        int left = 0;
        int right = a.length - 1;

        while (left < right) {

            while (left < right && a[left] <= k)
                left++;

            while (left < right && a[right] > k)
                right--;

            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
    }

    // ==========================
    // Algorithm 3 : Sorting-Based
    // ==========================
    static void partitionBySorting(int[] a, int k) {
        Arrays.sort(a);
    }

    // ==========================
    // Main
    // ==========================
    public static void main(String[] args) {

        int[] data = {12, 4, 7, 15, 3, 10, 8};
        int k = 8;

        int[] arr1 = data.clone();
        partitionRecursive(arr1, k, 0, arr1.length - 1);
        System.out.println("Recursive : " + Arrays.toString(arr1));

        int[] arr2 = data.clone();
        partitionIterative(arr2, k);
        System.out.println("Iterative : " + Arrays.toString(arr2));

        int[] arr3 = data.clone();
        partitionBySorting(arr3, k);
        System.out.println("Sorting   : " + Arrays.toString(arr3));
    }
}