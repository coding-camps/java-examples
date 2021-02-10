package interviews.obj.demo2.util;

import interviews.obj.demo2.IProductService;
import interviews.obj.demo2.ProductService;

import java.net.URL;
import java.util.ArrayList;

/**
 * 免税商品类别工具类
 */
public class ProductFreeTaxTypeUtil {

    public static ArrayList<String> listFreeTaxProType = new ArrayList<String>();

    /**
     * 初始化免税商品类型集合
     */
    public static void init() {
        IProductService productService = new ProductService();
        URL fileUrl = Thread.currentThread().getContextClassLoader().getResource("interviews/obj/demo2/freetaxtype.xml");
        String strFilePath = fileUrl.getPath();
        listFreeTaxProType = productService.readFreeTypeList(strFilePath);
    }
}
