package tools.syscmd;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SysCmder {

    public static void main(String[] args) {
        String cmdStr = "ls -al";
        SysCmder.runCommand(cmdStr);
    }

    public static void runCommand(String cmdStr) {
        //TODO use running config

        List<String> cmd = new ArrayList<>();
        Arrays.stream(cmdStr.split("\\s")).forEach(word -> {
            cmd.add(word);
        });

        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        processBuilder.redirectErrorStream(true);
        Process p = null;
        try {
            p = processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream in = p.getInputStream();
        OutputThread.createAndStart(in);
    }
}
