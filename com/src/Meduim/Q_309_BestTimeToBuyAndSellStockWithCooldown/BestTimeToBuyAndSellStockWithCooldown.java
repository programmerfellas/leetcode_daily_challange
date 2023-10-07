package Meduim.Q_309_BestTimeToBuyAndSellStockWithCooldown;

public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        return find(0, n, false, prices,ans);
    }


    public static int find(int i, int n, boolean flag, int[] prices, int ans) {
        if(i >= n) return 0;

        if(!flag) {
            int buy = (0 - prices[i]) + find(i + 1, n, true, prices,ans);
            int notBuy = 0 + find(i + 1, n, false, prices,ans);
            ans = Math.max(buy, notBuy);
        } else {
            int sell = (prices[i]) + find(i + 2, n, false, prices,ans);
            int notSell = find(i + 1, n, true, prices,ans);
            ans = Math.max(sell, notSell);
        }
        return ans;
    }

    public static int maxProfit2(int[] prices) {
        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;

        for (int price : prices) {
            int preSold = sold;

            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(reset, preSold);
        }

        return Math.max(sold, reset);

    }
}
