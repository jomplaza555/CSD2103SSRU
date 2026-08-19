package StackPresent;

import java.time.LocalDateTime;

public class Box {

    // รหัสของกล่อง
    private String boxId;

    // ประเภทของกล่อง
    private String category;

    // เวลาที่กล่องเข้ามา
    private LocalDateTime arrivalTime;

    // ระดับความสำคัญของกล่อง
    private int priority;

    // Constructor
    public Box(String boxId, String category, int priority) {
        this.boxId = boxId;
        this.category = category;
        this.arrivalTime = LocalDateTime.now();
        this.priority = priority;
    }

    // ====================================
    // Getter
    // ====================================

    public String getBoxId() {
        return boxId;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public int getPriority() {
        return priority;
    }

    // แสดงข้อมูลของกล่อง
    @Override
    public String toString() {
        return "Box[ID=" + boxId
                + ", Category=" + category
                + ", Priority=" + priority
                + "]";
    }
}