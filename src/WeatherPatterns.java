import java.util.ArrayList;

/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author YOUR NAME HERE
 */

public class WeatherPatterns {


    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        /*
        ArrayList<Integer> temps = new ArrayList<Integer>();
        for (int temp : temperatures) {
            temps.add(temp);
        }


        int i = 1;
        while (i < temps.size()) {
            if (temps.get(i-1) >= temps.get(i)) {
                temps.remove(i-1);
            }
            else {
                i++;
            }
        }
        return temps.size();

         */

        ArrayList<Integer> temps = new ArrayList<Integer>();
        for (int temp : temperatures) {
            temps.add(temp);
        }


        int last = temps.get(0);
        int lowest = last;
        int i = 1;
        while (i < temps.size()) {
            int curr = temps.get(i);
            if (curr < lowest) {
                // TODO
                lowest = curr;
            }
            if (last >= curr) {
                temps.remove(i-1);
                i--;
            }

            i++;
        }



        return 0;
    }
}
