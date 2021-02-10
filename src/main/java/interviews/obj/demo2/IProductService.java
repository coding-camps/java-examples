package interviews.obj.demo2;

import java.util.ArrayList;

/**
 * 商品数据逻辑接口类
 */
public interface IProductService {

	/**
	 * 读取免税商品类型
	 *
	 * @param strXmlFilePath 免税商品类型配置xml文件路径
	 * @return 免税商品类型集合
	 */
	public ArrayList<String> readFreeTypeList(String strXmlFilePath);

	/**
	 * 计算xml文件中各商品总价、总税额
	 *
	 * @param strXmlFilePath 保存商品的xml文件路径
	 * @return 购物车表单
	 */
	public ProductResultForm calcProductPrice(String strXmlFilePath);

	/**
	 * 读取商品信息
	 *
	 * @param strXmlFilePath 保存商品的xml文件路径
	 * @return 商品信息集合
	 */
	public ArrayList<ProductForm> readProductList(String strXmlFilePath);

	/**
	 * 计算集合中每个商品的价格、税额，并将其保存到集合中
	 *
	 * @param listProductForm 商品信息集合
	 * @return 商品信息集合
	 */
	public ArrayList<ProductForm> calcEachPriceAndTax(ArrayList<ProductForm> listProductForm);

	/**
	 * 计算集合中各商品总价、总税额
	 * @param listProductForm 商品信息集合
	 * @return 购物车表单
	 */
	public ProductResultForm calcTotalPriceAndTax(ArrayList<ProductForm> listProductForm);
}
