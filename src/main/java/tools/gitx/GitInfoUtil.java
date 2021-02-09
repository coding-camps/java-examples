package tools.gitx;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GitInfoUtil {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2023, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 12, 31);
        LocalTime[][] timeRange = {
                {LocalTime.of(9, 0, 0), LocalTime.of(11, 59, 59)},
                {LocalTime.of(13, 0, 0), LocalTime.of(16, 59, 59)},
                {LocalTime.of(19, 30, 0), LocalTime.of(21, 59, 59)},
        };
        List<String> cmdList = GitInfoUtil.generateGitCmdList(date1, date2, timeRange, 10);
        cmdList.forEach(System.out::println);
    }

    private static Random random = new Random(LocalTime.now().toNanoOfDay());

    private static String GitCmd1 = "GIT_COMMITTER_DATE=\"FLAG_DATE\" git commit -m \"OPR: MSG\" --date=\"FLAG_DATE\"";
    private static String GitCmd2 = "GIT_COMMITTER_DATE=\"FLAG_DATE\" git commit --amend --date=\"FLAG_DATE\"";

    public static List<String> generateGitCmdList(LocalDate date1, LocalDate date2, LocalTime[][] timeRange, int times) {
        List<String> list = new LinkedList();
        List<String> timeList = null;
        for (LocalDate date = date1; date.isBefore(date2) || date.isEqual(date2); date = date.plusDays(1)) {
            list.add(String.format("- [%s]", date.toString()));
            timeList = generateRandomTimeList(timeRange, times);
            for (String time : timeList) {
                list.add(GitCmd1.replace("FLAG_DATE", date.toString() + "T" + time));
            }
            list.add("-");
            timeList = generateRandomTimeList(timeRange, times);
            for (String time : timeList) {
                list.add(GitCmd2.replace("FLAG_DATE", date.toString() + "T" + time));
            }
        }
        return list;
    }


    public static List<String> generateRandomTimeList(LocalTime[][] timeRange, int times) {
        List<String> list = new LinkedList();
        int hour, min, sec;
        LocalTime time = null;

        for (int i = 0; i < times; i++) {
            check_loop:
            while (true) {
                hour = random.nextInt(24);
                min = random.nextInt(60);
                sec = random.nextInt(60);
                time = LocalTime.of(hour, min, sec);
                if (isValidDuration(timeRange, time)) {
                    break check_loop;
                }
            }
            // format: "hh:mm:ss"
            String s = time.format(DateTimeFormatter.ISO_TIME);
            list.add(s);
        }
        return list.stream().sorted().collect(Collectors.toList());
    }

    private static boolean isValidDuration(LocalTime[][] timeRange, LocalTime time) {
        boolean bool = Arrays.stream(timeRange)
                .map(range -> range[0].isBefore(time) && time.isBefore(range[1]))
                .anyMatch(b -> b);
        return bool;
    }

}
