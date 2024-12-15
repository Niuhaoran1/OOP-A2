package src;

public class Person {
    private String name;
    private int age;
    private String email;
 
    public Person() {
    }
 
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
 
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

