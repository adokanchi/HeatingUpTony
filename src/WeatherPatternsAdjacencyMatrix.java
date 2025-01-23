public class WeatherPatternsAdjacencyMatrix {
    public static int longestWarmingTrendAdjacencyMatrix(int[] temperatures) {
        int len = temperatures.length;

        boolean[][] adjacencyMatrix = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (temperatures[i] > temperatures[j]) {
                    adjacencyMatrix[j][i] = true;
                }
            }
        }

        // longestTo[i] is the length of the longest valid sequence that ends at index i
        // The solution to the problem is the largest value in longestTo
        int[] longestTo = new int[len];
        int longest = 1;
        for (int i = 0; i < len; i++) {
            longestTo[i] = longestPathToAdjacencyMatrix(i, adjacencyMatrix, longestTo);
            longest = Integer.max(longest, longestTo[i]);
        }
        return longest;
    }

    public static int longestPathToAdjacencyMatrix(int endIdx, boolean[][] adjacencyMatrix, int[] longestTo) {
        int longest = 0;
        for (int i = 0; i < endIdx; i++) {
            if (adjacencyMatrix[i][endIdx]) longest = Integer.max(longest, longestTo[i]);
        }
        return longest + 1;
    }
}
