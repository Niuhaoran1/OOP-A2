package src;
public class Employee extends Person {
    // 实例变量
    private String employeeId;
    private String department;
 
    // 默认构造函数
    public Employee() {
        super(); // 调用父类的默认构造函数
    }
 
    // 带参数的构造函数
    public Employee(String name, int age, String email, String employeeId, String department) {
        super(name, age, email); // 调用父类的带参数构造函数
        this.employeeId = employeeId;
        this.department = department;
    }
 
    // Getter和Setter方法
    public String getEmployeeId() {
        return employeeId;
    }
 
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
 
    public String getDepartment() {
        return department;
    }
 
    public void setDepartment(String department) {
        this.department = department;
    }
}

