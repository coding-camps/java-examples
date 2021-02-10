package interviews.obj.demo2.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 工具类
 */
public class ProductUtil {

	/**
	 * 格式化金额，精度为0.05
	 * 金额a.ax精确到2位小数-->获取金额最后一位数字x-->
	 * 如果不能整除5，result = a.ax - 0.0x + 0.1-->
	 * 如果能整除5，result = a.ax
	 *
	 * @param bd 金额
	 * @return 舍入到0.05后的金额
	 */
	public static BigDecimal roundTax(BigDecimal bd){
		if(bd == null || BigDecimal.ZERO.compareTo(bd) == 1){
			return BigDecimal.ZERO.setScale(2);
		}
		bd = bd.setScale(2,RoundingMode.HALF_UP);
		String strBd = bd.toString();
		String strLastBit = strBd.substring(strBd.length()-1,strBd.length());
		BigDecimal bdTemp = BigDecimal.ZERO;
		bdTemp.setScale(2);
		int iLastBit = Integer.valueOf(strLastBit);
		if(iLastBit%5 != 0){
			bdTemp = BigDecimal.valueOf(iLastBit).divide(BigDecimal.valueOf(100));
			bdTemp = bdTemp.multiply(BigDecimal.valueOf(-1));
			bdTemp = bdTemp.add(iLastBit>5 ? new BigDecimal("0.1") : new BigDecimal("0.05"));
		}
		bd = bd.add(bdTemp);
		return bd;
	}
	
	public static void main(String[] args) {
        for(BigDecimal bd = new BigDecimal("-0.01"); bd.compareTo(new BigDecimal("1.11"))<0; bd = bd.add(new BigDecimal("0.01"))){
            System.out.println(bd + "\t=>\t" + roundTax(bd));
        }
    }
}
