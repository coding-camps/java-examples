package lang.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetConnector {
    public static void main(String[] args) throws IOException {
        String baiduUrlStr = "https://www.baidu.com/";

        URL baiduUrl = new URL(baiduUrlStr);

        URLConnection urlConn = baiduUrl.openConnection();

        InputStream ins = urlConn.getInputStream();

        InputStreamReader insr = new InputStreamReader(ins);

        BufferedReader br = new BufferedReader(insr);

        String line = "";

//        StringBuilder sb = new StringBuilder();

        while((line = br.readLine())!=null) {
//            sb.append(line, 0, line.length());
//            sb.append("\n");
            System.out.println(line);
        }

        br.close();
        insr.close();
        ins.close();

//        System.out.println(sb.toString());



    }
}
