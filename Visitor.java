import src.Person;
 
public class Visitor extends Person {
    // 实例变量
    private String membershipStatus;
    private String visitDate;
 
    // 默认构造函数
    public Visitor() {
        super(); // 调用父类的默认构造函数
    }
 
    // 带参数的构造函数
    public Visitor(String name, int age, String email, String membershipStatus, String visitDate) {
        super(name, age, email); // 调用父类的带参数构造函数
        this.membershipStatus = membershipStatus;
        this.visitDate = visitDate;
    }
 
    // Getter和Setter方法
    public String getMembershipStatus() {
        return membershipStatus;
    }
 
    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }
 
    public String getVisitDate() {
        return visitDate;
    }
 
    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }
    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", email='" + getEmail() + '\'' +
                ", membershipStatus='" + getMembershipStatus() + '\'' +
                ", visitDate='" + getVisitDate() + '\'' +
                '}';
    } 
    }
