package lang.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class PicDownloader {
    public static void main(String[] args) throws IOException {
        String apacheLogoUrlStr = "https://www.apache.org/img/support-apache.jpg";
        URL apacheLogoUrl = new URL(apacheLogoUrlStr);
        URLConnection apacheLogoConn = apacheLogoUrl.openConnection();
        InputStream apacheLogoIns = apacheLogoConn.getInputStream();

        String fileName = "apache-logo.jpg";
        String realPath = PicDownloader.class.getResource("/").getPath();
        int idx1 = realPath.lastIndexOf("classes/".replaceAll("/", File.separator));
        realPath = realPath.substring(0, idx1) + "resources/net/".replaceAll("/", File.separator);
        new File(realPath).mkdirs();
        File targetFile = new File(realPath + fileName);
        System.out.println(targetFile);
        if (targetFile.exists()) {
            targetFile.delete();
        }

        FileOutputStream fos = new FileOutputStream(targetFile);
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = apacheLogoIns.read(buffer, 0, buffer.length)) != -1) {
            fos.write(buffer, 0, length);
        }

        fos.flush();
        fos.close();
        apacheLogoIns.close();
    }
}
