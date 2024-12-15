package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Iterator;

public abstract class Ride<V> implements RideInterface<V> {

    private String rideName;
    private boolean isOpen;
    private Employee rideOperator;
    private Queue<V> visitorQueue;
    private List<V> rideHistory; // 用于存储乘坐过该游乐设施的游客集合
    private int maxRider; // 标识一个游乐设施在一次循环中能容纳多少游客，至少为1
    private int numOfCycles; // 标识游乐设施运行的次数，默认值为0，每次运行增加1

    public Ride(String rideName, boolean isOpen, Employee rideOperator, int maxRider) {
        this.rideName = rideName;
        this.isOpen = isOpen;
        this.rideOperator = rideOperator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }


    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Employee getRideOperator() {
        return rideOperator;
    }

    public void assignRideOperator(Employee operator) {
        this.rideOperator = operator;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    // 实现RideInterface接口的方法
    @Override
    public void addVisitorToQueue(V visitor) {
        visitorQueue.offer(visitor);
    }

    @Override
    public boolean removeVisitorFromQueue(V visitor) {
        return visitorQueue.remove(visitor);
    }

    @Override
    public void printQueue() {
        System.out.println("Queue:");
        for (V visitor : visitorQueue) {
            System.out.println(visitor);
        }
    }

    @Override
    public void runOneCycle() {
        if (rideOperator == null) {
            System.out.println("The ride cannot run because there is no operator assigned.");
            return;
        }
        if (visitorQueue.isEmpty()) {
            System.out.println("The ride cannot run because there are no visitors in the queue.");
            return;
        }
        int numToRemove = Math.min(visitorQueue.size(), maxRider);
        for (int i = 0; i < numToRemove; i++) {
            V currentVisitor = visitorQueue.poll();
            addVisitorToHistory(currentVisitor);
            System.out.println(currentVisitor + " is now riding " + rideName);
        }
        numOfCycles++;
        System.out.println("The ride has completed one cycle. The current number of cycles is: " + numOfCycles);
    }

    @Override
     public void addVisitorToHistory(V visitor) {
     rideHistory.add(visitor);
    System.out.println(visitor + " has been added to the ride history successfully.");
    }

    @Override
    public boolean checkVisitorFromHistory(V visitor) {
        boolean result = rideHistory.contains(visitor);
        if (result) {
            System.out.println(visitor + " is in the ride history.");
        } else {
            System.out.println(visitor + " is not in the ride history.");
        }
        return result;
    }

    @Override
    public int numberOfVisitors() {
        System.out.println("The number of visitors in the ride history is: " + rideHistory.size());
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride History:");
        Iterator<V> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            V visitor = iterator.next();
            System.out.println(visitor);
        }
    }

    public void sortRideHistory(Comparator<V> comparator) {
        Collections.sort((List<V>) rideHistory, comparator);
        System.out.println("The ride history has been sorted successfully.");
    }
    public void exportRideHistory(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Iterator<V> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                V visitor = iterator.next();
                writer.write(visitor.toString());
                writer.newLine();
            }
            System.out.println("The ride history has been successfully exported to the file: " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred while exporting the ride history: " + e.getMessage());
        }
    }
public void importRideHistory(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine())!= null) {
                try {
                    String[] parts = line.substring(line.indexOf('{') + 1, line.lastIndexOf('}')).split(", ");
                    String name = parts[0].split("=")[1].replace("'", "");
                    int age = Integer.parseInt(parts[1].split("=")[1]);
                    String email = parts[2].split("=")[1].replace("'", "");
                    String membershipStatus = parts[3].split("=")[1].replace("'", "");
                    String visitDate = parts[4].split("=")[1].replace("'", "");
                    @SuppressWarnings("unchecked")
                    V visitor = (V) new Visitor(name, age, email, membershipStatus, visitDate);
                    addVisitorToHistory(visitor);
                } catch (Exception e) {
                    System.err.println("An error occurred while parsing visitor data from file: " + e.getMessage());
                    // 继续尝试读取下一行数据，即使这行解析出错也不影响后续行的处理
                    continue;
                }
            }
            System.out.println("The ride history has been successfully imported from the file: " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
