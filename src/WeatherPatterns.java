
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

    public static int longestWarmingTrend(int[] temperatures) {
        int len = temperatures.length;
        int longest = 1;
        // longestTo[i] is the length of the longest valid sequence that ends at index i
        // The solution to the problem is the largest value in longestTo
        int[] longestTo = new int[len];
        longestTo[0] = 1;
        for (int i = 1; i < len; i++) {
            int nextTemp = temperatures[i];
            for (int j = 0; j < i; j++) {
                if (nextTemp > temperatures[j]) longestTo[i] = Integer.max(longestTo[i], longestTo[j]);
            }
            longestTo[i] += 1;
            longest = Math.max(longestTo[i], longest);
        }
        return longest;
    }
}