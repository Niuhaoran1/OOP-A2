package src;
 
import java.util.ArrayList;
import java.util.List;

public class AssignmentTwo {
    public void partThree() {
        // 创建员工对象，作为游乐设施的操作员，这里示例数据可根据实际替换
        Employee operator = new Employee("John Doe", 30, "johndoe@example.com", "12345", "Operations");
        // 创建一个新的Ride对象，这里假设游乐设施名称为"Roller Coaster"，初始状态为开放（true）
        Ride<Visitor> rollerCoasterRide = new Ride<Visitor>("Roller Coaster", true, operator) {
            // 这里如果Ride类有抽象方法需要具体实现，可以在这里添加具体逻辑，当前代码示例中无额外抽象方法需要实现，所以留空
        };
        
        // 创建一些访客对象并添加到队列中
        List<Visitor> visitors = new ArrayList<>();
        visitors.add(new Visitor("Alice", 25, "alice@example.com", "Member", "2024-12-10"));
        visitors.add(new Visitor("Bob", 28, "bob@example.com", "Non-Member", "2024-12-11"));
        visitors.add(new Visitor("Charlie", 32, "charlie@example.com", "Member", "2024-12-12"));
        visitors.add(new Visitor("David", 20, "david@example.com", "Non-Member", "2024-12-13"));
        visitors.add(new Visitor("Eve", 27, "eve@example.com", "Member", "2024-12-14"));
        
        // 向队列中添加至少5名访客
        for (Visitor visitor : visitors) {
            rollerCoasterRide.addVisitorToQueue(visitor);
        }
        
        // 将一位访客从队列中移除
        Visitor visitorToRemove = visitors.get(0);
        rollerCoasterRide.removeVisitorFromQueue(visitorToRemove);
        
        // 打印队列中的所有访客
        rollerCoasterRide.printQueue();
    }

    public void partFourA(){
    }
    public void partFourB(){
    }
    public void partFive(){
    }
    public void partSix(){
    }
    public void partSeven(){
    }
}