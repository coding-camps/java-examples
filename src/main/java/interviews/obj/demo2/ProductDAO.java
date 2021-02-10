package interviews.obj.demo2;

import interviews.obj.demo2.util.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 商品数据交互类
 *
 * @author daxiang
 * @since 2014-07-17
 */
public class ProductDAO {

    /**
     * 读取免税商品类型
     *
     * @param strXmlFilePath 免税商品类型配置xml文件路径
     * @return 免税商品类型集合
     */
    public ArrayList<String> readFreeTypeList(String strXmlFilePath) {
        ArrayList<String> listFreeTypeList = new ArrayList<String>();
        if (StringUtils.isBlank(strXmlFilePath)) {
            return listFreeTypeList;
        }
        try {
            File f = new File(strXmlFilePath);
            SAXReader reader = new SAXReader();
            Document doc = reader.read(f);
            Element eleRoot = doc.getRootElement();
            Element eleName;
            List listNodes = eleRoot.elements("name");
            for (Iterator i = listNodes.iterator(); i.hasNext(); ) {
                eleName = (Element) i.next();
                listFreeTypeList.add(eleName.getData().toString());
            }
        } catch (DocumentException ex) {
            System.err.println("系统找不到指定的文件:" + strXmlFilePath);
            return new ArrayList<String>();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<String>();
        }
        return listFreeTypeList;
    }

    /**
     * 读取商品信息
     *
     * @param strXmlFilePath 保存商品的xml文件路径
     * @return 商品信息集合
     */
    public ArrayList<ProductForm> readProductList(String strXmlFilePath) {
        ArrayList<ProductForm> listProductForm = new ArrayList<ProductForm>();
        if (StringUtils.isBlank(strXmlFilePath)) {
            return listProductForm;
        }
        try {
            File f = new File(strXmlFilePath);
            SAXReader reader = new SAXReader();
            Document doc = reader.read(f);
            Element rootTestCase = doc.getRootElement();
            Element items;
            Element item;
            ProductForm form = new ProductForm();
            // 获取items节点
            for (Iterator i = rootTestCase.elementIterator("items"); i.hasNext(); ) {
                items = (Element) i.next();
                // 获取item节点即每个商品信息，将其转化为form
                for (Iterator j = items.elementIterator("item"); j.hasNext(); ) {
                    item = (Element) j.next();
                    form = new ProductForm();
                    form.setName(item.attributeValue("name"));
                    form.setCount(Integer.valueOf(item.attributeValue("count")));
                    form.setUnitPrice(new BigDecimal(item.attributeValue("unitPrice")));
                    form.setType(item.attributeValue("type"));
                    form.setImported("true".equals(item.attributeValue("imported")) ? true : false);
                    form.setItemPrice(new BigDecimal("0.00"));
                    form.setItemTax(new BigDecimal("0.00"));
                    listProductForm.add(form);
                }
            }
        } catch (DocumentException ex) {
            System.err.println("系统找不到指定的文件:" + strXmlFilePath);
            return new ArrayList<ProductForm>();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<ProductForm>();
        }
        return listProductForm;
    }
}
