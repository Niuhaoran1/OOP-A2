
// 更新后的Ride类，实现RideInterface接口
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Ride implements RideInterface {
    // 实例变量
    private String rideName;
    private boolean isOpen;
    private Employee rideOperator;
    private Queue<Visitor> visitorQueue;
    private List<Visitor> rideHistory;

    // 构造函数
    public Ride(String rideName, boolean isOpen, Employee rideOperator) {
        this.rideName = rideName;
        this.isOpen = isOpen;
        this.rideOperator = rideOperator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Getter和Setter方法（省略了部分，以保持简洁）
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
    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.offer(visitor);
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        visitorQueue.remove(visitor);
    }

    @Override
    public void printQueue() {
        System.out.println("Queue: " + visitorQueue);
    }

    @Override
    public void runOneCycle() {
        // 实现游乐设施运行一个循环的逻辑
        // 例如，可以从队列中取出一个访客并添加到历史记录中（这里只是示例）
        if (!visitorQueue.isEmpty()) {
            Visitor currentVisitor = visitorQueue.poll();
            rideHistory.add(currentVisitor);
            System.out.println(currentVisitor + " is now riding " + rideName);
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
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

    // 注意：由于Ride类现在是抽象的，它不能被直接实例化。
    // 您需要创建一个继承自Ride的具体子类来实例化对象（如果需要的话）。
}

// Employee类（假设已存在，或者您需要创建它）
// public class Employee {
//     // Employee类的属性和方法
// }

