package interviews.obj.demo2;

import java.math.BigDecimal;
import java.util.ArrayList;

import interviews.obj.demo2.util.ProductConstants;
import interviews.obj.demo2.util.ProductFreeTaxTypeUtil;
import interviews.obj.demo2.util.ProductUtil;

/**
 * 商品数据逻辑接口实现类
 */
public class ProductService implements IProductService {

	private final ProductDAO productDAO = new ProductDAO();

	/**
	 * 读取免税商品类型
	 *
	 * @param strXmlFilePath 免税商品类型配置xml文件路径
	 * @return 免税商品类型集合
	 */
	public ArrayList<String> readFreeTypeList(String strXmlFilePath){
		return productDAO.readFreeTypeList(strXmlFilePath);
	}

	/**
	 * 计算xml文件中各商品总价、总税额
	 *
	 * @param strXmlFilePath 保存商品的xml文件路径
	 * @return 购物车表单
	 */
	public ProductResultForm calcProductPrice(String strXmlFilePath){
		ArrayList<ProductForm> listProductForm = this.readProductList(strXmlFilePath);
		listProductForm = this.calcEachPriceAndTax(listProductForm);
		ProductResultForm resultForm = this.calcTotalPriceAndTax(listProductForm);

		return resultForm;
	}

	/**
	 * 读取商品信息
	 *
	 * @param strXmlFilePath 保存商品的xml文件路径
	 * @return 商品信息集合
	 */
	public ArrayList<ProductForm> readProductList(String strXmlFilePath){
		return productDAO.readProductList(strXmlFilePath);
	}

	/**
	 * 计算集合中每个商品的价格、税额，并将其保存到集合中
	 *
	 * @param listProductForm 商品信息集合
	 * @return 商品信息集合
	 */
	public ArrayList<ProductForm> calcEachPriceAndTax(ArrayList<ProductForm> listProductForm){
		if(listProductForm == null || listProductForm.size() == 0){
			return listProductForm;
		}
		BigDecimal bdRate;
		BigDecimal bdItemPrice;
		BigDecimal bdItemTax;
		ProductForm formCalc;
		ArrayList<String> listFreeTaxProType = ProductFreeTaxTypeUtil.listFreeTaxProType;
		// 计算每个商品的税率，总价，总税额
		for(int i=0; i<listProductForm.size(); i++){
			formCalc = listProductForm.get(i);
			bdRate = BigDecimal.ZERO;
			if(!listFreeTaxProType.contains(formCalc.getType())){
				bdRate = bdRate.add(ProductConstants.RateBasic);
			}
			if(formCalc.getImported()){
				bdRate = bdRate.add(ProductConstants.RateImport);
			}
			bdItemPrice = formCalc.getUnitPrice().multiply(new BigDecimal(formCalc.getCount()));
			formCalc.setItemPrice(bdItemPrice);

			bdItemTax = ProductUtil.roundTax(bdItemPrice.multiply(bdRate));
			formCalc.setItemTax(bdItemTax);
		}
		return listProductForm;
	}

	/**
	 * 计算集合中各商品总价、总税额
	 * @param listProductForm 商品信息集合
	 * @return 购物车表单
	 */
	public ProductResultForm calcTotalPriceAndTax(ArrayList<ProductForm> listProductForm){
		ProductResultForm resultForm = new ProductResultForm();
		if(listProductForm == null || listProductForm.size() == 0){
			return resultForm;
		}
		BigDecimal bdTotalPrice = BigDecimal.ZERO;
		BigDecimal bdTotalTax = BigDecimal.ZERO;
		ProductForm formCalc;
		// 计算购物车总价，总税额
		for(int i=0; i<listProductForm.size(); i++){
			formCalc = listProductForm.get(i);
			bdTotalPrice = bdTotalPrice.add(formCalc.getItemPrice());
			bdTotalTax = bdTotalTax.add(formCalc.getItemTax());
		}
		// 将总税额加入到总价中
		bdTotalPrice = bdTotalPrice.add(bdTotalTax);
		resultForm.setBdTotalPrice(bdTotalPrice);
		resultForm.setBdTotalTax(bdTotalTax);
		return resultForm;
	}
}
