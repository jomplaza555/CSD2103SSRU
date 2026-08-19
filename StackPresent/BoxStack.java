package StackPresent;

import java.util.List;
import java.util.Stack;

public class BoxStack {

    // เก็บกล่องใน Stack
    private Stack<Box> boxes;

    // จำนวนกล่องสูงสุดที่ Stack เก็บได้
    private int capacity;

    // ตัวแปรนับจำนวนครั้งที่ตรวจสอบ Stack
    public static int stackCheckCount = 0;

    // Constructor
    public BoxStack(int capacity) {
        this.capacity = capacity;
        this.boxes = new Stack<>();
    }

    // ====================================
    // ตรวจสอบพื้นที่ว่างที่เหลือ
    // ====================================

    public int remainingSpace() {
        return capacity - boxes.size();
    }

    // ====================================
    // เพิ่มกล่องลง Stack
    // ====================================

    public boolean push(Box box) {

        if (boxes.size() >= capacity) {
            return false;
        }

        boxes.push(box);
        return true;
    }

    // ====================================
    // นำกล่องออกจาก Stack
    // ====================================

    public Box pop() {

        if (boxes.isEmpty()) {
            return null;
        }

        return boxes.pop();
    }

    // ====================================
    // ตรวจสอบจำนวนกล่อง
    // ====================================

    public int size() {
        return boxes.size();
    }


    // ====================================
    // Algorithm A: First Available Stack
    // ====================================

    public static BoxStack firstAvailable(
            List<BoxStack> stacks,
            BoxStack sourceStack) {

        // ตรวจสอบ Stack ตั้งแต่กองแรก
        for (BoxStack stack : stacks) {

            // นับจำนวนครั้งที่ตรวจสอบ Stack
            stackCheckCount++;

            // ต้องไม่ใช่ Stack ต้นทาง
            // และต้องมีพื้นที่ว่าง
            if (stack != sourceStack
                    && stack.remainingSpace() > 0) {

                // พบ Stack แรกที่มีพื้นที่ว่าง
                return stack;
            }
        }

        // ไม่มี Stack ที่สามารถใช้งานได้
        return null;
    }


    // ==========================================
    // Algorithm B: Best Fit Stack
    // ==========================================

    public static BoxStack bestFit(
            List<BoxStack> stacks,
            BoxStack sourceStack) {

        BoxStack bestStack = null;

        // กำหนดค่าเริ่มต้นให้มากที่สุด
        int minimumSpace = Integer.MAX_VALUE;

        // ตรวจสอบ Stack ทุกกอง
        for (BoxStack stack : stacks) {

            // นับจำนวนครั้งที่ตรวจสอบ Stack
            stackCheckCount++;

            // ไม่เลือก Stack ต้นทาง
            // และต้องมีพื้นที่ว่าง
            if (stack != sourceStack
                    && stack.remainingSpace() > 0) {

                // คำนวณพื้นที่ว่างหลังจากนำกล่องไปวาง
                int spaceAfterMove =
                        stack.remainingSpace() - 1;

                // ถ้าพื้นที่ที่เหลือน้อยกว่า
                // Stack ที่เลือกไว้ก่อนหน้า
                if (spaceAfterMove < minimumSpace) {

                    minimumSpace = spaceAfterMove;

                    bestStack = stack;
                }
            }
        }

        // คืน Stack ที่เหมาะสมที่สุด
        return bestStack;
    }
}