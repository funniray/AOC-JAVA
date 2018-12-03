package funniray.kdray.pro.advent.solutions;

import funniray.kdray.pro.advent.AbstractDay;

import java.util.HashSet;
import java.util.Set;

public class Day1 extends AbstractDay {

    @Override
    public String SolveOne(String[] input) {
        int sum = 0;
        for (String s : input) {
            sum += Integer.parseInt(s);
        }
        return sum + "";
    }

    @Override
    public String SolveTwo(String[] input) {
        Set<Integer> seen = new HashSet<>();
        int sum = 0;
        int count = 0;

        while (true) {
            int num = Integer.parseInt(input[count % input.length]);
            sum += num;
            count++;
            if (!seen.add(sum))
                return sum + "";
        }
    }
}
