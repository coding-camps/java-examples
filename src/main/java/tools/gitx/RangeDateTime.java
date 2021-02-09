package tools.gitx;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class RangeDateTime {


    // magic numbers
    private static final int MINUTE_AN_HOUR = 60;
    private static final int SECOND_A_MINUTE = 60;
    private static final int DAYS_A_WEEK = 7;
    public static final String formatTimePart = "%02d:%02d:%02d";
    public static final String formatDateTimePart = "%sT%s";
    public static final String cmdDateTimeRegex = "\\$\\{DATETIME\\}";
    public static final String formatDatePart = "%04d-%02d-%02d";

    //    "GIT_COMMITTER_DATE=\"${DATETIME}\" git commit --reset-author --amend --date=\"${DATETIME}\"";
    private static String template = "GIT_COMMITTER_DATE=\"${DATETIME}\" git commit -m \"\" --date=\"${DATETIME}\"";

    // tools
    private Random random = new Random(System.currentTimeMillis());

    // date from
    private LocalDate date1 = LocalDate.now(TimeZone.getTimeZone("GMT+8").toZoneId());
    private LocalDate date2 = date1;
    // time scope by hour
    private LocalTime time1 = LocalTime.now(TimeZone.getTimeZone("GMT+8").toZoneId());
    private LocalTime time2 = time1;
    private int[] forbidHours = new int[]{};


    // Date part
    public RangeDateTime setDateFrom(int year, int month, int day) {
        this.date1 = LocalDate.of(year, month, day);
        return this;
    }

    public RangeDateTime setDateTo(int year, int month, int day) {
        this.date2 = LocalDate.of(year, month, day);
        return this;
    }

    // Time part
    public RangeDateTime setHour(int hour1, int hour2) {
        this.time1 = LocalTime.of(hour1, LocalTime.now().getMinute(), random.nextInt(SECOND_A_MINUTE));
        this.time2 = LocalTime.of(hour2, LocalTime.now().getMinute(), random.nextInt(SECOND_A_MINUTE));
        if (time1.isAfter(time2)) {
            LocalTime temp = time1;
            time1 = time2;
            time2 = temp;
        }
        return this;
    }

    public RangeDateTime setForbidHours(int... forbidHours) {
        this.forbidHours = forbidHours;
        return this;
    }

    public static void main(String[] args) {
        RangeDateTime rangeDateTime = new RangeDateTime();
        rangeDateTime.setDateFrom(2020, 9, 18).setDateTo(2020, 9, 30).setHour(10, 20);
        rangeDateTime.setForbidHours(11, 12, 13);
        Map<String, List<String>> map = rangeDateTime.generateCommand();
        map.entrySet().stream().forEach(entry -> {
            String date = entry.getKey();
            List<String> cmds = entry.getValue();
            System.out.println(String.format("%s -> %d", date, cmds.size()));
            cmds.stream().forEach(System.out::println);
        });
    }

    public Map<String, List<String>> generateCommand() {
        if (date1.isAfter(date2)) {
            LocalDate temp = date1;
            date1 = date2;
            date2 = temp;
        }
        // result <date, command<date,time>>
        Map<String, List<String>> dateCmdMap = new TreeMap<>();

        generateDatePart(dateCmdMap);
        return dateCmdMap;
    }

    private void generateDatePart(Map<String, List<String>> dateCmdMap) {
        // generate date part
        int weekDayCnt = 0;
        // choose one of Mon to Fri
        int weekDayChoose = random.nextInt(5) + 1;
        // choose one of Sat or Sun
        int weekEndChoose = random.nextInt(2) + 6;
        for (LocalDate date = date1; date.isBefore(date2) || date.isEqual(date2); date = date.plusDays(1)) {
            weekDayCnt++;
            if (date.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
                weekDayCnt %= DAYS_A_WEEK;
                weekDayChoose = random.nextInt(5) + 1;
                weekEndChoose = random.nextInt(2) + 6;
            }
            // escape free days
            if (DayOfWeek.of(weekDayChoose).equals(date.getDayOfWeek()) || DayOfWeek.of(weekEndChoose).equals(date.getDayOfWeek())) {
                continue;
            }

            String dateStr = String.format(formatDatePart, date.getYear(), date.getMonth().getValue(), date.getDayOfMonth());

            // prepare for time part
            List<String> cmdList = dateCmdMap.get(dateStr);
            if (Objects.isNull(cmdList)) {
                cmdList = new LinkedList<>();
                dateCmdMap.put(dateStr, cmdList);
            }

            generalTimePart(dateStr, cmdList);
        }
    }

    private void generalTimePart(String datePartStr, List<String> cmdList) {
        // generate time part
        for (LocalTime time = time1;
             time.isBefore(time2);
             time = time.plusMinutes(random.nextInt(MINUTE_AN_HOUR) + MINUTE_AN_HOUR / 6)
                     .plusSeconds(random.nextInt(SECOND_A_MINUTE))
        ) {
            // escape from forbidden hours
            if (escapeHours(time)) {
                continue;
            }
            // generate time part
            String timeStr = String.format(formatTimePart, time.getHour(), time.getMinute(), time.getSecond());

            // combine command
            combineCmd(datePartStr, cmdList, timeStr);
        }
    }

    private void combineCmd(String datePartStr, List<String> cmdList, String timeStr) {
        String dateTimeStr = String.format(formatDateTimePart, datePartStr, timeStr);
        String command = template.replaceAll(cmdDateTimeRegex, dateTimeStr);
        cmdList.add(command);
    }

    private boolean escapeHours(LocalTime time) {
        final int finalHour = time.getHour();
        boolean isForbidHour = Arrays.stream(this.forbidHours).anyMatch(h -> h == finalHour);
        if (isForbidHour) {
            return true;
        }
        return false;
    }

}
