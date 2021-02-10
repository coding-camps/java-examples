package interviews.obj.demo1;

public class Element {
    private String name;
    private String count;
    private String unitPrice;
    private String type;
    private String origon;
    private String taxes;
    private String total;

    public void set(String name, String count, String unitPrice, String type, String origon) {
        this.name = name;
        this.count = count;
        this.unitPrice = unitPrice;
        this.type = type;
        this.origon = origon;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.name).append("\t[ ");
        sb.append(this.count).append(" X ").append(this.unitPrice);
        sb.append("\t=>\t").append(this.type).append(", ");
        sb.append(this.origon).append(" ] ");
        sb.append(this.taxes).append(", ").append(this.total);
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
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

    public String getTaxes() {
        return taxes;
    }

    public void setTaxes(String taxes) {
        this.taxes = taxes;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
