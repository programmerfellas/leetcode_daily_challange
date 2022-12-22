package Q_841_KeysAndRooms;

import java.util.*;

public class KeysAndRooms {

    public static void main(String[] args) {

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];

        for(Integer nei : rooms.get(0)) {
            queue.offer(nei);
        }

        visited[0] = true;

        while (!queue.isEmpty()) {
            int x = queue.peek();
            if(!visited[x]) {
                for(Integer nei : rooms.get(x)) {
                    if (!visited[nei]) {
                        queue.offer(nei);
                    }
                }

                visited[x] = true;
            }
            queue.poll();
        }

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }


    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        //At the beginning, we have a todo list "stack" of keys to use.
        //'seen' represents at some point we have entered this room.
        while (!stack.isEmpty()) { // While we have keys...
            int node = stack.pop(); // Get the next key 'node'
            for (int nei: rooms.get(node)) // For every key in room # 'node'...
                if (!seen[nei]) { // ...that hasn't been used yet
                    seen[nei] = true; // mark that we've entered the room
                    stack.push(nei); // add the key to the todo list
                }
        }

        for (boolean v: seen)  // if any room hasn't been visited, return false
            if (!v) return false;
        return true;
    }

    public boolean canVisitAllRooms3ß(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            for (Integer nextRoom : rooms.get(removed)) {
                if (!visited.contains(nextRoom)) {
                    queue.add(nextRoom);
                    visited.add(nextRoom);
                }
            }
        }
        return visited.size() == rooms.size();
    }

}
