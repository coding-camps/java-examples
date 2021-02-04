package tools.dip;

import javax.imageio.ImageIO;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.util.Date;

public class ImageConverter {


    public static void main(String[] args) throws Exception  {
        String resPath = "src/main/resources/tools/dip/";
        String res = resPath + "syz.jpeg";
        String dest = resPath + "syz-gray.jpeg";
        ImageConverter.rgb2Gray(res, dest);
        System.out.println(new Date(new File(dest).lastModified()));
    }

    public static void rgb2Gray(String picSrc, String picDes) throws Exception {
        File fileSrc = new File(picSrc);
        System.out.println(fileSrc.getAbsoluteFile());
        if (!fileSrc.exists()) {
            throw new IllegalAccessException("Source image file " + picSrc + " is not exists.");
        }
        File fileDes = new File(picDes);
        System.out.println(fileDes.getAbsoluteFile());

        BufferedImage imgSrc = ImageIO.read(fileSrc);

        int width = imgSrc.getWidth();
        int height = imgSrc.getHeight();

        BufferedImage imgDes = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        ColorConvertOp opGray = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        opGray.filter(imgSrc, imgDes);

        ImageIO.write(imgDes, "jpg", fileDes);
    }
}
