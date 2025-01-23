import java.util.ArrayList;

public class WeatherPatternsAdjacencyList {
    public static int longestWarmingTrendAdjacencyList(int[] temperatures) {
        int len = temperatures.length;

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < i; j++) {
                if (temperatures[i] > temperatures[j]) {
                    list.add(j);
                }
            }
            adjacencyList.add(list);
        }

        // longestTo[i] is the length of the longest valid sequence that ends at index i
        // The solution to the problem is the largest value in longestTo
        int[] longestTo = new int[len];
        int longest = 1;
        for (int i = 0; i < len; i++) {
            longestTo[i] = longestPathToAdjacencyList(i, adjacencyList, longestTo);
            longest = Integer.max(longest, longestTo[i]);
        }
        return longest;
    }

    public static int longestPathToAdjacencyList(int endIdx, ArrayList<ArrayList<Integer>> adjacencyList, int[] longestTo) {
        int longest = 0;
        for (int idx : adjacencyList.get(endIdx)) {
            longest = Integer.max(longest, longestTo[idx]);
        }
        return longest + 1;
    }
}
