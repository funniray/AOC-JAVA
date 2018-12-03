package funniray.kdray.pro.advent;

import java.io.*;
import java.util.Date;

public class Main {

    private static long time;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IOException {
        for (Days dayV : Days.values()) {
            File data = new File("data/day" + dayV.num + ".dat");
            if (!data.exists()) {
                System.out.println("Data doesn't exist for day " + dayV.name().toLowerCase() + " please put the data in " + data.getAbsolutePath());
                continue;
            }
            InputStream is = new FileInputStream(data);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();

            while (line != null) {
                sb.append(line).append("\n");
                line = buf.readLine();
            }

            String fileAsString = sb.toString();

            AbstractDay day = dayV.clazz.newInstance();
            System.out.println("Starting to solve day " + dayV.name().toLowerCase());
            startTimer();
            System.out.println(day.SolveOne(fileAsString.split("\n")));
            printTimer("Took %sms to solve part one");
            startTimer();
            System.out.println(day.SolveTwo(fileAsString.split("\n")));
            printTimer("Took %sms to solve part two");
            System.out.println("");
        }
    }

    public static void startTimer() {
        time = new Date().getTime();
    }

    public static void printTimer(String format) {
        System.out.println(String.format(format, new Date().getTime() - time + ""));
    }
}
