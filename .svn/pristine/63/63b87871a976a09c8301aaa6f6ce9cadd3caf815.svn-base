package com.hrbb.loan.pos.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 金额转换工具类.
 * 
 * @author xiongshaogang
 * @version $Id: MoneyUtils.java, v 0.1 2015年5月14日 下午5:58:25 xiongshaogang Exp $
 */
public class MoneyUtils {

    /**
     * 数字金额大写转换，思想先写个完整的然后将如零拾替换成零
     * 要用到正则表达式
     */
    public static String digitUppercase(double n) {
        String fraction[] = { "角", "分" };
        String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        String unit[][] = { { "元", "万", "亿" }, { "", "拾", "佰", "仟" } };

        String head = n < 0 ? "负" : "";
        n = Math.abs(n);

        String s = "";
        for (int i = 0; i < fraction.length; i++) {
            s += (digit[(int) (Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i])
                .replaceAll("(零.)+", "");
        }
        if (s.length() < 1) {
            s = "整";
        }
        int integerPart = (int) Math.floor(n);

        for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
            String p = "";
            for (int j = 0; j < unit[1].length && n > 0; j++) {
                p = digit[integerPart % 10] + unit[1][j] + p;
                integerPart = integerPart / 10;
            }
            s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
        }
        return head
               + s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零")
                   .replaceAll("^整$", "零元整");
    }
    
    /**
     * 金额格式化，返回带逗号的金额
     * @param money 金额（单元为元）
     * @return
     */
    public static String format(BigDecimal money){
        String partern = "0,000.00";
        if(null == money){
            return "";
        }
        DecimalFormat format = new DecimalFormat();
        format.applyPattern(partern);
        return format.format(money);
    }
}
