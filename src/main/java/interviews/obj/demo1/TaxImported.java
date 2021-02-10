package interviews.obj.demo1;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TaxImported implements Tax {
    private BigDecimal rate = new BigDecimal("0.05");
    private Set<String> taxOrigons = new HashSet<String>();
    {
        // in common, we set the values from database or a configuration file.
        taxOrigons.add("imported");
    }

    @Override
    public BigDecimal calTax(ProdctItem p) {
        BigDecimal tax = new BigDecimal("0");
        if (taxOrigons.contains(p.getOrigon())) {
            tax = p.getCount().multiply(p.getUnitPrice()).multiply(this.rate);
        }
        return tax;
    }
}

