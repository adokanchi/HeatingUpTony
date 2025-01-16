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
    public static int longestWarmingTrend(int[] temperatures) {
        return longestWarmingTrend(temperatures, 0);

//        int len = temperatures.length;
//        if (len == 1) return 1;
//        // seqLen[i] is the length of the longest valid sequence that ends at index i
//        // the solution to the problem is the largest value in seqLen
//        int[] seqLen = new int[len];
//        seqLen[0] = 1;
//        // longestSeq is the length of the longest sequence (aka the largest value in seqLen)
//        int longestSeq = 0;
//        for (int i = 1; i < len; i++) {
//            int longestSubseq = 0;
//            for (int j = 0; j < i; j++) {
//                if (temperatures[i] > temperatures[j] && seqLen[j] > longestSubseq) {
//                    longestSubseq = seqLen[j];
//                }
//            }
//            seqLen[i] = 1 + longestSubseq;
//            // Keep track of longestSeq while populating seqLen to avoid having to do a linear pass at the end
//            if (seqLen[i] > longestSeq) longestSeq = seqLen[i];
//        }
//        return longestSeq;
    }

    // Returns the longest sequence starting at index idx
    public static int longestWarmingTrend(int[] temperatures, int startIdx) {
        int len = temperatures.length;
        if (len == 1) return 1;

        int longestLen = 0;
        int lowest = 130; // highest value possible given problem constraints

        for (int idx = startIdx; idx < len; idx++) {
            int current = temperatures[idx];
            if (current < lowest) {
                lowest = current;
                int newLen = longestWarmingTrend(temperatures, idx);
                if (newLen > longestLen) longestLen = newLen;
            }
            else {
                // TODO
                // This is the part that I'm struggling to do in less than linear time.
            }
        }

        return longestLen;
    }
}