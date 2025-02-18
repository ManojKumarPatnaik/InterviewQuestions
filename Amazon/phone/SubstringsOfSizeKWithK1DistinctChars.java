package phone;

import java.util.*;

public class SubstringsOfSizeKWithK1DistinctChars {

    public static List<String> subStrOfSizeK(String input, int k) {
        List<String> result = new ArrayList<>();
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char currentChar = input.charAt(windowEnd);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            if (windowEnd >= k - 1) {
                if (map.size() == k - 1)
                    result.add(input.substring(windowStart, windowEnd + 1));
                removeChar(map, input.charAt(windowStart));
                windowStart++;
            }
        }
        return result;
    }

    private static void removeChar(Map<Character, Integer> map, char temp) {
        if (map.get(temp) == 1)
            map.remove(temp);
        else
            map.put(temp, map.get(temp) - 1);
    }

    public static void main(String[] args) {
        System.out.println(subStrOfSizeK("awaglk", 4));
        System.out.println(subStrOfSizeK("democracy", 5));
        System.out.println(subStrOfSizeK("wawaglknagagwunagkwkwagl", 4));
    }
}
