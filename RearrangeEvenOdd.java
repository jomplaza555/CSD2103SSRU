package ProgramSoloUpInGit;

import java.util.Arrays;

public class RearrangeEvenOdd {

    // =========================
    // Algorithm 1 : Recursive Two-Pointer
    // =========================
    static void rearrangeRecursive(int[] a, int left, int right) {

        if (left >= right)
            return;

        while (left < right && a[left] % 2 == 0)
            left++;

        while (left < right && a[right] % 2 != 0)
            right--;

        if (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            rearrangeRecursive(a, left + 1, right - 1);
        }
    }

    // =========================
    // Algorithm 2 : Iterative Two-Pointer
    // =========================
    static void rearrangeTwoPointer(int[] a) {

        int left = 0;
        int right = a.length - 1;

        while (left < right) {

            while (left < right && a[left] % 2 == 0)
                left++;

            while (left < right && a[right] % 2 != 0)
                right--;

            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;

                left++;
                right--;
            }
        }
    }

    // =========================
    // Algorithm 3 : Extra Array
    // =========================
    static int[] rearrangeExtraArray(int[] a) {

        int[] result = new int[a.length];
        int index = 0;

        // เก็บจำนวนคู่ก่อน
        for (int num : a) {
            if (num % 2 == 0)
                result[index++] = num;
        }

        // เก็บจำนวนคี่ทีหลัง
        for (int num : a) {
            if (num % 2 != 0)
                result[index++] = num;
        }

        return result;
    }

    // =========================
    // Main
    // =========================
    public static void main(String[] args) {

        int[] data = {7, 2, 9, 4, 1, 6, 3, 8};

        // Recursive
        int[] arr1 = data.clone();
        rearrangeRecursive(arr1, 0, arr1.length - 1);
        System.out.println("Recursive : " + Arrays.toString(arr1));

        // Iterative
        int[] arr2 = data.clone();
        rearrangeTwoPointer(arr2);
        System.out.println("Iterative : " + Arrays.toString(arr2));

        // Extra Array
        int[] arr3 = rearrangeExtraArray(data);
        System.out.println("Extra Array: " + Arrays.toString(arr3));
    }
}