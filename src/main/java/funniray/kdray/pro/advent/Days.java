package funniray.kdray.pro.advent;

import funniray.kdray.pro.advent.solutions.Day1;
import funniray.kdray.pro.advent.solutions.Day2;

public enum Days {
    ONE(Day1.class, 1),
    TWO(Day2.class, 2);

    public Class<? extends AbstractDay> clazz;
    public int num;

    Days(Class<? extends AbstractDay> clazz, int num) {
        this.clazz = clazz;
        this.num = num;
    }
}
