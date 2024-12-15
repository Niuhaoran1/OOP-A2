package src;

import java.util.Comparator;

// 实现Comparator接口用于比较Visitor对象，这里根据年龄和会员状态进行比较示例，可根据需求调整比较逻辑
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 先根据年龄比较
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
        if (ageComparison!= 0) {
            return ageComparison;
        }
        // 如果年龄相同，再根据会员状态比较（这里简单按照字母顺序比较字符串表示的会员状态）
        return v1.getMembershipStatus().compareTo(v2.getMembershipStatus());
    }
}
