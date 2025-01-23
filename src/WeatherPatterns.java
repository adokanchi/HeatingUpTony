import java.util.ArrayList;

/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Tony Dokanchi
 */

public class WeatherPatterns {
    /**
     * Longest Warming Trend
     * @param temperatures list of temperature values
     * @return the longest run of days with increasing temperatures
     */

    private static int[] longestTo;


    public static int longestWarmingTrend(int[] temperatures) {
        int len = temperatures.length;


        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();


        for (int i = 0; i < len; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (temperatures[i] > temperatures[j]) {
                    adjacencyList.get(i).add(j);
                }
            }
        }

        // longestTo[i] is the length of the longest valid sequence that ends at index i
        // the solution to the problem is the largest value in longestTo
        longestTo = new int[len];
        // longest is the length of the longest sequence (aka the largest value in longestTo)
        int longest = 1;
        for (int i = 0; i < len; i++) {
            longestTo[i] = longestPathTo(i, adjacencyList);
            longest = Integer.max(longest, longestTo[i]);
        }
        return longest;
    }

    public static int longestPathTo(int endIdx, ArrayList<ArrayList<Integer>> adjacencyList) {
        if (endIdx == 0) return 1;

        int longest = 0;
        for (int i : adjacencyList.get(endIdx)) {
            longest = Integer.max(longest, longestTo[i]);
        }
        return longest + 1;
    }
}