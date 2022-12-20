package Q_2260_MinimumConsecutiveCardsPickUp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MinimumConsecutiveCardsPickUp {

    public static void main(String[] args) {
        int[] cards = {3,4,2,3,4,7};
        System.out.println(minimumCardPickup2(cards));
    }

    public static int minimumCardPickup(int[] cards) {
        LinkedList<Integer> list = new LinkedList<>();
        int minCardPick = Integer.MAX_VALUE;
        for(int i = 0; i < cards.length; i++) {
            if(list.contains(cards[i])) {
                int lastIndex = list.indexOf(cards[i]);
                minCardPick = Math.min( (i - lastIndex) + 1, minCardPick);
            }
            list.add(cards[i]);
        }
        return minCardPick == Integer.MAX_VALUE ? -1 : minCardPick;
    }

    public static int minimumCardPickup2(int[] cards) {
        Map<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < cards.length; i++) {
            if(map.containsKey(cards[i]))
                min = Math.min(i - map.get(cards[i]) + 1,min); // Check if the difference in indices is smaller than minimum
            map.put(cards[i],i); // Update the last found index of the card
        }
        return min == Integer.MAX_VALUE ? -1 : min; // Repetition found or not
    }
}
