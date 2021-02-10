package interviews.obj.demo2;

import java.math.BigDecimal;

/**
 * 商品信息表单类
 */
public class ProductForm {
	/** 商品名称 */
	private String name;
	/** 商品数量 */
	private int count;
	/** 商品单价 */
	private BigDecimal unitPrice;
	/** 商品类型 */
	private String type;
	/** 是否进口 */
	private boolean imported;
	/** 商品价格 */
	private BigDecimal itemPrice;
	/** 商品税额 */
	private BigDecimal itemTax;

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean getImported() {
		return imported;
	}
	public void setImported(boolean imported) {
		this.imported = imported;
	}
	public BigDecimal getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
	public BigDecimal getItemTax() {
		return itemTax;
	}
	public void setItemTax(BigDecimal itemTax) {
		this.itemTax = itemTax;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void reset(){
		this.name = "";
		this.count = 0;
		this.unitPrice = BigDecimal.ZERO;
		this.type = "";
		this.imported = false;
		this.itemPrice = BigDecimal.ZERO;
		this.itemTax = BigDecimal.ZERO;
	}

	@Override
	public String toString(){
		String strForm = "";
		strForm += "ProductForm=[\r\n";
		strForm += "this.name=" +this.name + "\r\n";
		strForm += "this.count=" +this.count + "\r\n";
		strForm += "this.unitPrice=" +this.unitPrice.toString() + "\r\n";
		strForm += "this.type=" +this.type + "\r\n";
		strForm += "this.imported=" +this.imported + "\r\n";
		strForm += "this.itemPrice=" +this.itemPrice.toString() + "\r\n";
		strForm += "this.itemTax=" +this.itemTax.toString() + "\r\n";
		strForm += "]";

		return strForm;
	}
}
