package interviews.obj.demo2;

import java.math.BigDecimal;

/**
 * 购物车表单类
 */
public class ProductResultForm {

	public ProductResultForm(){
		this.bdTotalPrice = BigDecimal.ZERO;
		this.bdTotalTax = BigDecimal.ZERO;
	}

	/** 商品总价 */
	private BigDecimal bdTotalPrice;
	/** 商品税额 */
	private BigDecimal bdTotalTax;

	public BigDecimal getBdTotalPrice() {
		return bdTotalPrice;
	}
	public void setBdTotalPrice(BigDecimal bdTotalPrice) {
		this.bdTotalPrice = bdTotalPrice;
	}
	public BigDecimal getBdTotalTax() {
		return bdTotalTax;
	}
	public void setBdTotalTax(BigDecimal bdTotalTax) {
		this.bdTotalTax = bdTotalTax;
	}

	@Override
	public String toString(){
		String strForm = "";
		strForm += "ProductResultForm=[\r\n";
		strForm += "this.bdTotalPrice=" +this.bdTotalPrice.toString() + "\r\n";
		strForm += "this.bdTotalTax=" +this.bdTotalTax.toString() + "\r\n";
		strForm += "]";

		return strForm;
	}
}
