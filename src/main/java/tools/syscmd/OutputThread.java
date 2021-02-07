package tools.syscmd;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class OutputThread extends Thread {

    private InputStream consoleInput = null;
    private String[] msg = null;

    public OutputThread(InputStream consoleInput, String... msg) {
        this.consoleInput = consoleInput;
        if (Objects.nonNull(msg) && msg.length != 0) {
            this.msg = msg;
        }
    }

    public static void createAndStart(InputStream in, String... tags) {
        new OutputThread(in, tags).start();
    }

    @Override
    public void run() {
        Scanner consoleScanner = new Scanner(this.consoleInput);

        String consoleLine = null;

        while (consoleScanner.hasNext()) {
            consoleLine = consoleScanner.nextLine();
            if (Objects.nonNull(this.msg)) {
                System.out.printf("%s:\t%s%n", msg[0], consoleLine);
            } else {
                System.out.println(consoleLine);
            }
        }

    }
}

