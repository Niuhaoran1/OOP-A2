package src;

@SuppressWarnings("hiding")
public interface RideInterface<Visitor> {
    void addVisitorToQueue(Visitor visitor);
    boolean removeVisitorFromQueue(Visitor visitor);
    void printQueue();
    void runOneCycle();
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();
}
