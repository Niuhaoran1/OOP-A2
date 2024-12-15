public class Ride {
    // 实例变量
    private String rideName;
    private boolean isOpen;
    private Employee rideOperator;
 
    // 默认构造函数
    public Ride() {
    }
 
    // 带参数的构造函数
    public Ride(String rideName, boolean isOpen, Employee rideOperator) {
        this.rideName = rideName;
        this.isOpen = isOpen;
        this.rideOperator = rideOperator;
    }
 
    // Getter和Setter方法
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
 
    // 获取游乐设施操作员的方法
    public Employee getRideOperator() {
        return rideOperator;
    }
 
    // 分配员工操作游乐设施的方法
    public void assignRideOperator(Employee operator) {
        this.rideOperator = operator;
    }
}
    

