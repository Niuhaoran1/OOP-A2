package src;
 
import java.util.ArrayList;
import java.util.List;

public class AssignmentTwo {
    public void partThree() {
        // 创建员工对象，作为游乐设施的操作员，这里示例数据可根据实际替换
        Employee operator = new Employee("John Doe", 30, "johndoe@example.com", "12345", "Operations");
        // 创建一个新的Ride对象，这里假设游乐设施名称为"Roller Coaster"，初始状态为开放（true）
        Ride<Visitor> rollerCoasterRide = new Ride<Visitor>("Roller Coaster", true, operator, 0) {};
        
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

   public void partFourA() {
        // 创建员工对象，作为游乐设施的操作员
        Employee operator = new Employee("John Doe", 30, "johndoe@example.com", "12345", "Operations");
        // 创建一个新的Ride对象，这里假设游乐设施名称为"Roller Coaster"，初始状态为开放（true）
        Ride<Visitor> rollerCoasterRide = new Ride<Visitor>("Roller Coaster", true, operator, 0) {};

        // 创建一些访客对象并添加到历史记录中（模拟乘坐过该游乐设施）
        List<Visitor> visitors = new ArrayList<>();
        visitors.add(new Visitor("Alice", 25, "alice@example.com", "Member", "2024-12-10"));
        visitors.add(new Visitor("Bob", 28, "bob@example.com", "Non-Member", "2024-12-11"));
        visitors.add(new Visitor("Charlie", 32, "charlie@example.com", "Member", "2024-12-12"));
        visitors.add(new Visitor("David", 20, "david@example.com", "Non-Member", "2024-12-13"));
        visitors.add(new Visitor("Eve", 27, "eve@example.com", "Member", "2024-12-14"));

        // 为游乐历史至少增加5名参观者
        for (Visitor visitor : visitors) {
            rollerCoasterRide.addVisitorToHistory(visitor);
        }

        // 检查访客是否在集合中，这里以第一个访客为例
        Visitor checkVisitor = visitors.get(0);
        rollerCoasterRide.checkVisitorFromHistory(checkVisitor);

        // 打印集合中访客的数量
        rollerCoasterRide.numberOfVisitors();

        // 打印集合中的所有访客
        rollerCoasterRide.printRideHistory();
    }

    
    public void partFourB() {
        // 创建员工对象，作为游乐设施的操作员
        Employee operator = new Employee("John Doe", 30, "johndoe@example.com", "12345", "Operations");
        // 创建一个新的Ride对象，这里假设游乐设施名称为"Roller Coaster"，初始状态为开放（true）
        Ride<Visitor> rollerCoasterRide = new Ride<Visitor>("Roller Coaster", true, operator, 0) {
        };

        // 创建一些访客对象并添加到历史记录中（模拟乘坐过该游乐设施）
        List<Visitor> visitors = new ArrayList<>();
        visitors.add(new Visitor("Alice", 25, "alice@example.com", "Member", "2024-12-10"));
        visitors.add(new Visitor("Bob", 28, "bob@example.com", "Non-Member", "2024-12-11"));
        visitors.add(new Visitor("Charlie", 32, "charlie@example.com", "Member", "2024-12-12"));
        visitors.add(new Visitor("David", 20, "david@example.com", "Non-Member", "2024-12-13"));
        visitors.add(new Visitor("Eve", 27, "eve@example.com", "Member", "2024-12-14"));

        // 为游乐历史至少增加5名参观者
        for (Visitor visitor : visitors) {
            rollerCoasterRide.addVisitorToHistory(visitor);
        }

        // 打印集合中的所有访客
        rollerCoasterRide.printRideHistory();

        // 创建比较器对象
        VisitorComparator comparator = new VisitorComparator();
        // 对藏品（乘坐历史集合）进行排序
        rollerCoasterRide.sortRideHistory(comparator);

        // 再次打印集合中的所有访客，以表明该集合已排序
        rollerCoasterRide.printRideHistory();
    }

    public void partFive() {
        // 创建员工对象，作为游乐设施的操作员
        Employee operator = new Employee("John Doe", 30, "johndoe@example.com", "12345", "Operations");
        // 创建一个新的Ride对象，这里假设游乐设施名称为"Roller Coaster"，一次循环最多容纳3名游客，初始状态为开放（true）
        Ride<Visitor> rollerCoasterRide = new Ride<Visitor>("Roller Coaster", true, operator, 3) {
            // 这里如果Ride类有抽象方法需要具体实现，可以在这里添加具体逻辑，当前代码示例中无额外抽象方法需要实现，所以留空
        };

        // 创建一些访客对象并添加到队列中
        List<Visitor> visitors = new ArrayList<>();
        visitors.add(new Visitor("Alice", 25, "alice@example.com", "Member", "2024-12-10"));
        visitors.add(new Visitor("Bob", 28, "bob@example.com", "Non-Member", "2024-12-11"));
        visitors.add(new Visitor("Charlie", 32, "charlie@example.com", "Member", "2024-12-12"));
        visitors.add(new Visitor("David", 20, "david@example.com", "Non-Member", "2024-12-13"));
        visitors.add(new Visitor("Eve", 27, "eve@example.com", "Member", "2024-12-14"));
        visitors.add(new Visitor("Frank", 35, "frank@example.com", "Member", "2024-12-15"));
        visitors.add(new Visitor("Grace", 22, "grace@example.com", "Non-Member", "2024-12-16"));
        visitors.add(new Visitor("Henry", 29, "henry@example.com", "Member", "2024-12-17"));
        visitors.add(new Visitor("Ivy", 30, "ivy@example.com", "Non-Member", "2024-12-18"));
        visitors.add(new Visitor("Jack", 24, "jack@example.com", "Member", "2024-12-19"));

        // 向队列中至少添加10名访客
        for (Visitor visitor : visitors) {
            rollerCoasterRide.addVisitorToQueue(visitor);
        }

        // 打印队列中的所有访客
        rollerCoasterRide.printQueue();

        // 运行一个周期
        rollerCoasterRide.runOneCycle();

        // 在一个周期运行后，打印队列中的所有访客
        rollerCoasterRide.printQueue();

        // 打印集合中的所有访客
        rollerCoasterRide.printRideHistory();
    }

    public void partSix(){
    }
    public void partSeven(){
    }

}