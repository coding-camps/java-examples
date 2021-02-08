package tools.zip;

import interviews.obj.demo2.util.StringUtils;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ZipUtil2 {


    public static void unzip(String password, String srcFilePath, String destFilePath) throws IOException {
        // 为避免与JDK自带的类 java.util.zip.ZipFile 冲突，所以使用全名
        net.lingala.zip4j.ZipFile zFile = new net.lingala.zip4j.ZipFile(srcFilePath);
        zFile.setCharset(StandardCharsets.UTF_8);
        List<FileHeader> headers = zFile.getFileHeaders();
        //判断文件名是否有乱码，有乱码，将编码格式设置成GBK
        if (isRandomCode(headers)) {
            zFile.close();
            zFile = new net.lingala.zip4j.ZipFile(srcFilePath);
            zFile.setCharset(Charset.forName("GBK"));
        }
        if (!zFile.isValidZipFile()) {
            throw new ZipException("压缩文件不合法,可能被损坏.");
        }
        //加密zip，且输入的密码不为空，直接进行解密。
        if (zFile.isEncrypted() && !StringUtils.isEmpty(password)) {
            zFile.setPassword(password.toCharArray());
        }
        File destDir = new File(destFilePath);
        if (!destDir.getParentFile().exists()) {
            destDir.mkdir();
        }

        zFile.extractAll(destFilePath);
    }

    //待解压的文件名是否乱码
    private static boolean isRandomCode(List<FileHeader> fileHeaders) {
        for (int i = 0; i < fileHeaders.size(); i++) {
            FileHeader fileHeader = fileHeaders.get(i);
            boolean canEnCode = Charset.forName("GBK").newEncoder().canEncode(fileHeader.getFileName());
            //canEnCode为true，表示不是乱码。false.表示乱码。是乱码则需要重新设置编码格式
            if (!canEnCode) {
                return true;
            }
        }
        return false;
    }

}
