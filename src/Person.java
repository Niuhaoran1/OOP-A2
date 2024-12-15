package src;

public class Person {
    // 实例变量
    private String name;
    private int age;
    private String email;
 
    // 默认构造函数
    public Person() {
    }
 
    // 带参数的构造函数
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
 
    // Getter和Setter方法
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
}

