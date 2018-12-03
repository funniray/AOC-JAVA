package funniray.kdray.pro.advent.solutions;

import funniray.kdray.pro.advent.AbstractDay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day2 extends AbstractDay {
    @Override
    public String SolveOne(String[] input) {
        int contains2 = 0;
        int contains3 = 0;

        for (String s : input) {
            boolean contained2 = false;
            boolean contained3 = false;
            Map<Character, Integer> usage = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (usage.containsKey(c))
                    usage.replace(c, usage.get(c) + 1);
                else
                    usage.put(c, 1);
            }
            for (Map.Entry<Character, Integer> entry : usage.entrySet()) {
                if (entry.getValue() == 2 && !contained2) {
                    contained2 = true;
                    contains2++;
                } else if (entry.getValue() == 3 && !contained3) {
                    contained3 = true;
                    contains3++;
                }
            }
        }

        return String.format("%.0f strings had 2 letters and %.0f strings had 3 letters. checksum is %.0f", (float) contains2, (float) contains3, (float) contains2 * contains3);
    }

    @Override
    public String SolveTwo(String[] input) {
        for (String s : input) {
            for (String t : input) {
                if (t.equals(s))
                    continue;
                Set<Integer> diffs = new HashSet<>();
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != t.charAt(i)) {
                        diffs.add(i);
                    }
                }
                if (diffs.size() == 1) {
                    return s.substring(0, (int) diffs.toArray()[0]) + s.substring((int) diffs.toArray()[0] + 1);
                }
            }
        }
        return null;
    }
}