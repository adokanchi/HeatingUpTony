import java.util.ArrayList;

public class WeatherPatternsBruteForce {
    public static int longestWarmingTrend(int[] temperatures, int index, ArrayList<Integer> list) {
        if (index >= temperatures.length) return list.size();
        int val1 = longestWarmingTrend(temperatures, index + 1, list);
        boolean addNextValue = list.size() == 0 || temperatures[index] > list.get(list.size() - 1);
        if (addNextValue) {
            list.add(temperatures[index]);
            int val2 = longestWarmingTrend(temperatures, index + 1, list);
            list.remove(list.size() - 1);
            return Integer.max(val1, val2);
        }
        return val1;
    }

    public static int longestWarmingTrend(int[] temperatures) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        return longestWarmingTrend(temperatures, 0, list);
    }
}
