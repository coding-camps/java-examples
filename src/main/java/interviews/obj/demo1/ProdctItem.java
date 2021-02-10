package interviews.obj.demo1;

import java.math.BigDecimal;

public class ProdctItem {
    private String name;
    private BigDecimal count;
    private BigDecimal unitPrice;
    private String type;
    private String origon;
    private BigDecimal taxes;
    private BigDecimal total;

    public ProdctItem(Element e) {
        this.name = e.getName();
        this.count = new BigDecimal(e.getCount());
        this.unitPrice = new BigDecimal(e.getUnitPrice());
        this.type = e.getType();
        this.origon = e.getOrigon();
        this.taxes = TaxCalculator.getTotalTax(this);
        this.total = this.count.multiply(this.unitPrice).add(this.taxes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigon() {
        return origon;
    }

    public void setOrigon(String origon) {
        this.origon = origon;
    }

    public BigDecimal getTaxes() {
        return taxes;
    }

    public void setTaxes(BigDecimal taxes) {
        this.taxes = taxes;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
