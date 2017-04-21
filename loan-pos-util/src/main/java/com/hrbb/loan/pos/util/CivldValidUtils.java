package com.hrbb.loan.pos.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 身份证编号校验工具类.
 * 
 * @author xiongshaogang
 * @version $Id: CivldValidUtils.java, v 0.1 2015年2月28日 下午5:48:07 xiongshaogang Exp $
 */
public class CivldValidUtils {

    private String eighteenId;
    private String fifteenId;
    private String birthday;
    private boolean isMale;

    private static Pattern ID_CARD_18 = Pattern.compile("\\d{17}(\\d|X)");
    private static Pattern ID_CARD_15 = Pattern.compile("\\d{15}");
    /**
     * 日期检查 yyyyMMdd 年：1600－9999 会检查闰月
     */
    Pattern DATE_YYYYMMDD = Pattern
            .compile("^((1[6-9]|[2-9]\\d)\\d{2})(((0[13578]|1[02])31)|((0[1,3-9]|1[0-2])(29|30)))$|^(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00)))(0229)$|^((1[6-9]|[2-9]\\d)\\d{2})((0[1-9])|(1[0-2]))(0[1-9]|1\\d|2[0-8])$");

    /**
     * 验证15/18位身份证号码
     * 
     * @return 验证通过返回true
     */
    public boolean validate(String str) {
        if (StringUtil.isEmpty(str)) {
            return true;
        }
        boolean success = (str.length() == 18 && check18(str))
                || (str.length() == 15 && check15(str));
        if (success) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取18位证件号
     * 
     * @return
     */
    public String getEighteenId() {
        return eighteenId;
    }

    /**
     * 获取15位证件号
     * 
     * @return
     */
    public String getFifteenId() {
        return fifteenId;
    }

    /**
     * 是否是男性
     * 
     * @return
     */
    public boolean isMale() {
        return isMale;
    }

    /**
     * 校验15位长身份号
     * 
     * @param str
     * @return
     */
    private boolean check15(String str) {
        String id15 = str;
        Matcher matcher = ID_CARD_15.matcher(id15);
        if (!matcher.matches()) {
            return false;
        }
        // 检查生日
        this.birthday = "19" + id15.substring(6, 12);
        // 检查年份月份日期合法性
        matcher = DATE_YYYYMMDD.matcher(this.birthday);
        if (!matcher.matches()) {
            return false;
        }
        // 生日不得大于当期日期
        long currentDate = Long.parseLong(DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMdd"));
        long birthday = Long.parseLong(this.birthday);
        if (currentDate < birthday) {
            return false;
        }
        // 计算校验位
        String verifyCode = getVerify(id15.substring(0, 6) + "19" + id15.substring(6));
        // 计算18位身份证
        fifteenId = str;
        eighteenId = new StringBuffer(id15.substring(0, 6)).append("19").append(id15.substring(6))
                .append(verifyCode).toString();
        // 计算性别
        String sex = eighteenId.substring(16, 17);
        isMale = "1".equals(sex) || "3".equals(sex) || "5".equals(sex) || "7".equals(sex)
                || "9".equals(sex);
        return true;
    }

    /**
     * 校验18位长身份号
     * 
     * @param str
     * @return
     */
    private boolean check18(String str) {
        String id18 = str;
        // 将小写x转换成大写X
        id18 = id18.replace('x', 'X');
        Matcher matcher = ID_CARD_18.matcher(id18);
        if (!matcher.matches()) {
            return false;
        }
        // 检查生日
        this.birthday = id18.substring(6, 14);
        // 检查年份月份日期合法性
        matcher = DATE_YYYYMMDD.matcher(this.birthday);
        if (!matcher.matches()) {
            return false;
        }
        // 生日不得大于当期日期
        long currentDate = Long.parseLong(DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMdd"));
        long birthday = Long.parseLong(this.birthday);
        if (currentDate < birthday) {
            return false;
        }
        // 检查校验位
        String verifyCode = id18.substring(17);
        if (verifyCode == null || !verifyCode.equals(this.getVerify(id18.substring(0, 17)))) {
            return false;
        }
        // 计算15位身份证
        eighteenId = id18;
        fifteenId = id18.substring(0, 6) + id18.substring(8, 17);
        // 计算性别
        String sex = eighteenId.substring(16, 17);
        isMale = "1".equals(sex) || "3".equals(sex) || "5".equals(sex) || "7".equals(sex)
                || "9".equals(sex);
        return true;
    }

    /**
     * 获取校验位
     * 
     * @param eightcardid
     * @return
     */
    private String getVerify(String eightcardid) {
        int remaining = 0;
        int[] wi = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
        int[] vi = { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };
        int[] ai = new int[18];
        try {
            if (eightcardid.length() == 18) {
                eightcardid = eightcardid.substring(0, 17);
            }
            if (eightcardid.length() == 17) {
                int sum = 0;
                String k;
                for (int i = 0; i < 17; i++) {
                    k = eightcardid.substring(i, i + 1);
                    ai[i] = Integer.parseInt(k);
                }
                for (int i = 0; i < 17; i++) {
                    sum = sum + wi[i] * ai[i];
                }
                remaining = sum % 11;
            }
            return remaining == 2 ? "X" : String.valueOf(vi[remaining]);
        } catch (Exception e) {
            return null;
        }
    }
}
