package Q_901_OnlineStockSpan;

import java.util.Arrays;
import java.util.Stack;

class StockSpanner {

    Stack<int[]> stack = new Stack<>();

    public int next(int price) {
        int ans = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            ans += stack.pop()[1];
        }

        stack.push(new int[] {price, ans});
        return ans;
    }
}

public class OnlineStockSpan {

    public static void main(String[] args) {
       int[][] stock = {{}, {100}, {80}, {60}, {70}, {60}, {75}, {85}};
       StockSpanner stockSpanner = new StockSpanner();
       int[] price = new int[stock.length];
       for (int i = 0; i < stock.length; i++) {
           for (int j = 0; j < stock[i].length; j++) {
               price[i] = stockSpanner.next(stock[i][j]);
           }
       }

       System.out.println(Arrays.toString(price));
    }

}
