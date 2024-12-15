import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.RideInterface;

public abstract class Ride<V> implements RideInterface<V> { 
    
    private String rideName;
    private boolean isOpen;
    private Employee rideOperator;
    private Queue<V> visitorQueue; 
    private List<V> rideHistory;  

    
    public Ride(String rideName, boolean isOpen, Employee rideOperator) {
        this.rideName = rideName;
        this.isOpen = isOpen;
        this.rideOperator = rideOperator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
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
            System.out.println(visitor); // 使用toString()方法打印访客的详细信息
        }
    }

    @Override
    public void runOneCycle() {
        if (!visitorQueue.isEmpty()) {
            V currentVisitor = visitorQueue.poll();
            rideHistory.add(currentVisitor);
            System.out.println(currentVisitor + " is now riding " + rideName);
        }
    }

    @Override
    public void addVisitorToHistory(V visitor) {
        rideHistory.add(visitor);
    }

    @Override
    public boolean checkVisitorFromHistory(V visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride History: " + rideHistory);
    }
}