package MaxStack;

import java.util.*;

// 716. Max Stack
public class MaxStack {

    public static void main(String[] args) {
        String[] calls = {"MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"};
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList());
        list.add(Arrays.asList(5));
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(5));
        list.add(Arrays.asList());
        list.add(Arrays.asList());
        list.add(Arrays.asList());
        list.add(Arrays.asList());
        list.add(Arrays.asList());
        list.add(Arrays.asList());
        MaxStack maxStack = null;
        Integer result = 0;
        for (int i =0; i < calls.length;i++) {
            String in = calls[i];
            List<Integer> listDetails = list.get(i);
            switch (in) {
                case "MaxStack" :
                    maxStack = new MaxStack();
                    break;
                case "push" :
                    maxStack.push(listDetails.get(0));
                    break;
                case "top" :
                    result = maxStack.top();
                    break;
                case "popMax" :
                    result = maxStack.popMax();
                    break;
                case "peekMax" :
                    result = maxStack.peekMax();
                    break;
                case "pop" :
                    result = maxStack.pop();
                    break;
            }
            System.out.println(result);
        }
        System.out.println("Final result" + result);
    }


    private TreeSet<int[]> stack;
    private TreeSet<int[]> values; // maintain maximum value in array list
    private int cnt;

    public MaxStack() {
        Comparator<int[]> comp = (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        };
        stack = new TreeSet<>(comp);
        values = new TreeSet<>(comp);
        cnt = 0;
    }

    public void push(int x) {
        stack.add(new int[] { cnt, x });
        values.add(new int[] { x, cnt });
        cnt++;
    }

    public int pop() {
        int[] pair = stack.pollLast();
        values.remove(new int[] { pair[1], pair[0] });
        return pair[1];
    }

    public int top() {
        return stack.last()[1];
    }

    public int peekMax() {
        return values.last()[0];
    }

    public int popMax() {
        int[] pair = values.pollLast();
        stack.remove(new int[] { pair[1], pair[0] });
        return pair[0];
    }

}
