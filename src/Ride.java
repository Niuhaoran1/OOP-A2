package src;

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
}