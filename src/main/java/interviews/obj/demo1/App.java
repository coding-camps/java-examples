package interviews.obj.demo1;

import java.math.BigDecimal;

public class App {

    public static void cal(Element[] items) {
        ProdctItem pItem = null;
        BigDecimal total = new BigDecimal("0");
        BigDecimal taxes = new BigDecimal("0");
        for (int i = 0; i < items.length; i++) {
            pItem = new ProdctItem(items[i]);
            total = total.add(pItem.getTotal());
            taxes = taxes.add(pItem.getTaxes());
        }
        System.out.println(total.stripTrailingZeros() + ", " + taxes.stripTrailingZeros());
    }

    // for test
    public static void main(String[] args) {
        cal(getE1());
        cal(getE2());
        cal(getE3());
    }

    //test case 1
    private static Element[] getE1() {
        Element item1 = new Element();
        Element item2 = new Element();
        Element item3 = new Element();
        item1.set("book", "1", "12.49", "book", "domistic");
        item2.set("music CD", "1", "14.99", "av", "domistic");
        item3.set("chocolate bar", "1", "0.85", "food", "domistic");
        return new Element[]{item1, item2, item3};
    }

    //test case 2
    private static Element[] getE2() {
        Element item1 = new Element();
        Element item2 = new Element();
        item1.set("box of chocolates", "1", "10.00", "food", "imported");
        item2.set("bottle of perfume", "1", "47.50", "makeup", "imported");
        return new Element[]{item1, item2};
    }

    //test case 3
    private static Element[] getE3() {
        Element item1 = new Element();
        Element item2 = new Element();
        Element item3 = new Element();
        Element item4 = new Element();
        item1.set("bottle of perfume", "1", "27.99", "makeup", "imported");
        item2.set("bottle of perfume", "1", "18.99", "makeup", "domistic");
        item3.set("packet of headache pills", "1", "9.75", "medical", "domistic");
        item4.set("box of chocolates", "1", "11.25", "food", "imported");
        return new Element[]{item1, item2, item3, item4};
    }
}
