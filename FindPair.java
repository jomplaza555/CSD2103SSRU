package ProgramSoloUpInGit;

import java.util.Arrays;

public class FindPair {

    // Algorithm 1 : Brute Force
    static boolean findPairBruteForce(int[] a, int k) {

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {

                if (a[i] + a[j] == k) {
                    System.out.println("Pair found: " + a[i] + " and " + a[j]);
                    return true;
                }
            }
        }

        return false;
    }

    // Algorithm 2 : Recursive Two-Pointer
    static boolean findPairRecursive(int[] a, int k, int left, int right) {

        if (left >= right)
            return false;

        int sum = a[left] + a[right];

        if (sum == k) {
            System.out.println("Pair found: " + a[left] + " and " + a[right]);
            return true;
        }

        if (sum < k)
            return findPairRecursive(a, k, left + 1, right);

        return findPairRecursive(a, k, left, right - 1);
    }

    // Algorithm 3 : Binary Search
    static boolean findPairBinarySearch(int[] a, int k) {

        for (int i = 0; i < a.length; i++) {

            int target = k - a[i];

            int index = Arrays.binarySearch(a, i + 1, a.length, target);

            if (index >= 0) {
                System.out.println("Pair found: " + a[i] + " and " + a[index]);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] a = {2,4,7,11,15,20};

        int k = 18;

        findPairBruteForce(a,k);

        findPairRecursive(a,k,0,a.length-1);

        findPairBinarySearch(a,k);

    }

}