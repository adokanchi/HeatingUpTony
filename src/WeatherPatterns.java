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
        if (len == 1) return 1;
        // longestTo[i] is the length of the longest valid sequence that ends at index i
        // the solution to the problem is the largest value in longestTo
        int[] longestTo = new int[len];
        longestTo[0] = 1;
        // longest is the length of the longest sequence (aka the largest value in longestTo)
        int longest = 0;
        for (int i = 1; i < len; i++) {
            int longestSubseq = 0;
            for (int j = 0; j < i; j++) {
                if (temperatures[i] > temperatures[j] && longestTo[j] > longestSubseq) {
                    longestSubseq = longestTo[j];
                }
            }
            longestTo[i] = 1 + longestSubseq;
            if (longestTo[i] > longest) longest = longestTo[i];
        }
        return longest;
    }
}