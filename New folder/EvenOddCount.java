import java.util.Scanner;

public class EvenOddCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[10];
        int evenCount = 0;
        int oddCount = 0;

        // รับข้อมูล 10 จำนวน
        System.out.println("Enter 10 Integers.");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("No. " + (i + 1) + " : ");
            numbers[i] = sc.nextInt();
        }

        // นับเลขคู่และเลขคี่
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // แสดงผล
        System.out.println("\nOutput");
        System.out.println("Even count = " + evenCount);
        System.out.println("Odd count = " + oddCount);

        sc.close();
    }
}