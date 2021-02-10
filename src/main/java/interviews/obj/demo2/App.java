package interviews.obj.demo2;

import interviews.obj.demo2.util.ProductFreeTaxTypeUtil;

import java.net.URL;

/**
 * 主程序
 */
public class App {


    /**
     * 程序入口
     *
     * @param args
     */
    public static void main(String[] args) {
        ProductFreeTaxTypeUtil.init();
        calculateResult();
    }

    /**
     * 展示各购物车的总税额和总价
     */
    public static void calculateResult() {
        IProductService productService = new ProductService();
        String strFilePath;
        ProductResultForm resultForm;


        URL fileUrl = Thread.currentThread().getContextClassLoader().getResource("interviews/obj/demo1/case1.xml");
        strFilePath = fileUrl.getPath();
        strFilePath = strFilePath.replace("case1.xml", "");

        String[] strXmlFile = new String[]{"case1.xml", "case2.xml", "case3.xml"};
        for (String strXmlFilePath : strXmlFile) {
            resultForm = new ProductResultForm();
            resultForm = productService.calcProductPrice(strFilePath + strXmlFilePath);
            System.out.println(strXmlFilePath + ":");
            System.out.println("total:" + resultForm.getBdTotalPrice().toString());
            System.out.println("taxes:" + resultForm.getBdTotalTax().toString());
            System.out.println("");
        }
    }
}
