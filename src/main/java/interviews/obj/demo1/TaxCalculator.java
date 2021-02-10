package interviews.obj.demo1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TaxCalculator {
    private static List<Tax> taxList = new ArrayList<Tax>();

    static {
        taxList.add(new TaxBasic());
        taxList.add(new TaxImported());
    }

    public static BigDecimal getTotalTax(ProdctItem p) {
        BigDecimal totalTax = new BigDecimal("0");
        for (Tax tax : taxList) {
            totalTax = totalTax.add(tax.calTax(p));
        }
        return taxRound(totalTax);
    }

    private static BigDecimal taxRound(BigDecimal num) {
        BigDecimal result = null;
        int scale = 1;
        BigDecimal delta = num.subtract(num.setScale(scale, BigDecimal.ROUND_FLOOR));
        outer:
        switch (delta.compareTo(new BigDecimal("0"))) {
            case 0:
                result = num;
                break outer;
            case 1:
                inner:
                switch (delta.compareTo(new BigDecimal("0.05"))) {
                    case -1:
                        result = num.setScale(scale, BigDecimal.ROUND_FLOOR).add(new BigDecimal("0.05"));
                        break inner;
                    case 0:
                        result = num;
                        break inner;
                    case 1:
                        result = num.setScale(scale, BigDecimal.ROUND_CEILING);
                        break inner;
                }
                break outer;
        }
        return result;
    }
}

