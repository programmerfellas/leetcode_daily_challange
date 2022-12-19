package Q_232_ImplementQueueUsingStacks;

import java.util.LinkedList;

public class ImplementQueueUsingStacks {

    LinkedList<Integer> list;
    public ImplementQueueUsingStacks() {
        list = new LinkedList<>();
    }

    public void push(int x) {
        list.addLast(x);
    }

    public int pop() {
        int temp = list.getFirst();
        list.removeFirst();
        return temp;
    }

    public int peek() {
        return list.getFirst();
    }

    public boolean empty() {
        return list.isEmpty();
    }
}
