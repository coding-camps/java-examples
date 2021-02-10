package interviews.obj.demo1;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TaxBasic implements Tax {
    private BigDecimal rate = new BigDecimal("0.1");
    private Set<String> freeTypes = new HashSet<String>();

    {
        // in common, we set the values from database or a configuration file.
        freeTypes.add("book");
        freeTypes.add("food");
        freeTypes.add("medical");
    }

    @Override
    public BigDecimal calTax(ProdctItem p) {
        BigDecimal tax = new BigDecimal("0");
        if (!freeTypes.contains(p.getType())) {
            tax = p.getCount().multiply(p.getUnitPrice()).multiply(this.rate);
        }
        return tax;
    }

}
