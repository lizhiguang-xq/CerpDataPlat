package org.ssm.common.utility;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title: StringUtil.java
 * @Company GINFO
 * @Description: 字符串的工具类
 * @author @高云鹏（yunpeng.gao@heliteq.com）
 * @date 2014-3-21 上午11:36:23
 * @version v1.0.9
 */
public final class StringUtil {

    /**
     * @Title: isEmpty
     * @Description: 验证字符串是否为空
     * @author ginfo003
     * @date 2014-3-21 上午11:40:02
     * @version v1.0.9
     * @param string
     * @return boolean
     */
    public static boolean isEmpty(String string) {
        boolean result = false;
        if (string == null || "".equals(string.trim()) || "null".equals(string.trim()) || "\"null\"".equals(string.trim())) {
            result = true;
        }
        return result;
    }

    /**
     * @Title: null2Empty
     * @Description: 将空字符串转换为""，防止空指针异常
     * @author ginfo003
     * @date 2014-3-21 上午11:40:21
     * @version v1.0.9
     * @param string
     * @return String
     */
    public static String null2Empty(String string) {
        String result = "";
        if (!isEmpty(string)) {
            result = string;
        }
        return result;
    }

    /**
     * @Title: isNumeric
     * @Description:验证是否是数字字符串
     * @author ginfo003
     * @date 2014-3-21 上午11:40:43
     * @version v1.0.9
     * @param str
     * @return boolean
     */
    public static boolean isNumeric(String str) {
        if (!isEmpty(str)) {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(str);
            if (!isNum.matches()) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * @Title: doNullInt
     * @Description:将数字字符串转化为int型
     * @author ginfo003
     * @date 2014-3-21 上午11:40:52
     * @version v1.0.9
     * @param srcInt
     * @return int
     */
    public static int doNullInt(String srcInt) {
        if (srcInt == null || "".equals(srcInt))
            return 0;
        return Integer.parseInt(srcInt);
    }

    public static int doNullInt(Object obj) {
        String srcInt = doNullStr(obj);
        if (srcInt == null || "".equals(srcInt))
            return 0;
        return Integer.parseInt(srcInt);
    }

    /**
     * @Title: doNullLong
     * @Description: 将数字字符串转化为long型
     * @author ginfo003
     * @date 2014-3-21 上午11:41:04
     * @version v1.0.9
     * @param srcInt
     * @return long
     */
    public static long doNullLong(String srcInt) {
        if (srcInt == null || "".equals(srcInt))
            return 0;
        return Long.parseLong(srcInt);
    }

    public static long doNullLong(Object obj) {
        String srcInt = doNullStr(obj);
        if (srcInt == null || "".equals(srcInt))
            return 0;
        return Long.parseLong(srcInt);
    }

    /**
     * @Title: doNullStr
     * @Description:转化为字符串
     * @author ginfo003
     * @date 2014-3-21 上午11:41:41
     * @version v1.0.9
     * @param obj
     * @return String
     */
    public static String doNullStr(Object obj) {
        String str = "";
        if (obj != null) {
            str = String.valueOf(obj);
            if (str.equals("null")) {
                str = "";
            }
        }
        return str;
    }

    /**
     * @Title: doNullInteger
     * @Description: 将数字型对象转换为Integer类型
     * @author ginfo003
     * @date 2014-3-21 上午11:42:09
     * @version v1.0.9
     * @param obj
     * @return Integer
     */
    public static Integer doNullInteger(Object obj) {
        String str = doNullStr(obj);
        if (isEmpty(str)) {
            str = "0";
        } else {
            int i = str.indexOf(".");
            if (i > 0) {
                str = str.substring(0, i);
            }
        }
        return Integer.valueOf(str);
    }

    /**
     * @Title: isEmpty
     * @Description: 验证字符串数组是否为空
     * @author ginfo003
     * @date 2014-3-21 上午11:42:33
     * @version v1.0.9
     * @param string
     * @return boolean
     */
    public static boolean isEmpty(String[] string) {
        return string == null || string.length == 0;
    }

    /**
     * @Title: isEmpty
     * @Description: 验证BEAN是否为空
     * @author ginfo003
     * @date 2014-3-21 上午11:42:43
     * @version v1.0.9
     * @param o
     * @return boolean
     */
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof List) {
            return isEmpty((List) o);
        }
        if (o instanceof Map) {
            return isEmpty((Map) o);
        }
        return o == null || "".equals(o) || "null".equals(o);
    }

    /**
     * @Title: isEmpty
     * @Description: 验证list是否为空
     * @author ginfo003
     * @date 2014-3-21 上午11:42:51
     * @version v1.0.9
     * @param o
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    public static boolean isEmpty(List o) {
        return o == null || o.isEmpty() || o.size() == 0;
    }

    /**
     * @Title: isEmpty
     * @Description: 验证map是否为空
     * @author ginfo003
     * @date 2014-3-21 上午11:43:07
     * @version v1.0.9
     * @param o
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    public static boolean isEmpty(Map o) {
        return o == null || o.isEmpty() || o.size() == 0;
    }

    /**
     * 
     * 
     * <pre>
     * 示例：
     * 	String stringUtils = &quot;abc&quot;;
     * 	System.out.println(StringUtils.padRight(stringUtils, 5, '0'));
     * 输出结果为：abc00；
     * </pre>
     * 
     * @param value
     *            输入值
     * @param totalWidth
     *            总长度
     * @param paddingChar
     *            不足时填充的字符
     * @return 重新计算后的字符。
     */
    /**
     * @Title: padRight
     * @Description:对字符串进行操作，对于小于指定长度的字符，在其右方按特定字符进行补足。
     * @author ginfo003
     * @date 2014-3-21 上午11:43:21
     * @version v1.0.9
     * 
     *          <pre>
     * 示例：
     * 	String stringUtils = &quot;abc&quot;;
     * 	System.out.println(StringUtils.padRight(stringUtils, 5, '0'));
     * 输出结果为：abc00；
     * </pre>
     * 
     * @param value
     *            输入值
     * @param totalWidth
     *            总长度
     * @param paddingChar
     *            不足时填充的字符
     * @return String 重新计算后的字符。
     */
    public static String padRight(String value, int totalWidth, char paddingChar) {
        String temp = value;
        if (value.length() > totalWidth) {
            return value;
        } else {
            while (temp.length() < totalWidth) {
                temp = temp + paddingChar;
            }
            return temp;
        }
    }

    /**
     * 
     * 
     
     */
    /**
     * @Title: padLeft
     * @Description: 对字符串进行操作，对于小于指定长度的字符，在其左方按特定字符进行补足。
     * @author ginfo003
     * @date 2014-3-21 上午11:43:57
     * @version v1.0.9
     * 
     *          <pre>
     * 示例：
     * String stringUtils = &quot;abc&quot;;
     * System.out.println(StringUtils.padLeft(stringUtils, 5, '0'));
     * 输出结果为：00abc；
     * </pre>
     * 
     * @param value
     *            输入值
     * @param totalWidth
     *            总长度
     * @param paddingChar
     *            不足时填充的字符
     * @return String 重新计算后的字符。
     */
    public static String padLeft(String value, int totalWidth, char paddingChar) {
        String temp = value;
        if (value.length() > totalWidth) {
            return value;
        } else {
            while (temp.length() < totalWidth) {
                temp = paddingChar + temp;
            }
            return temp;
        }
    }

    /**
     * @Title: reTrimByString
     * @Description: java trim()重写，取出字符串前后空格，处理了空指针异常。
     * @author ginfo003
     * @date 2014-3-21 上午11:45:34
     * @version v1.0.9
     * @param value
     * @return String
     */
    public static String reTrimByString(String value) {
        String reValue;
        if (value == null || value.equals("")) {
            reValue = "";
        } else {
            reValue = value.trim();
        }
        return reValue;
    }

    public static String reTrimByObject(Object obj) {
        String reValue;
        if (obj == null || obj.equals("")) {
            reValue = "";
        } else {
            reValue = String.valueOf(obj).trim();
        }
        return reValue;
    }

    /**
     * @Title: indexOfStringArray
     * @Description: 类似String.indexOf() 返回字符串在数组中的位置，处理了空指针异常
     * @author ginfo003
     * @date 2014-3-21 上午11:46:26
     * @version v1.0.9
     * @param strArr
     * @param str
     * @return int
     */
    public static int indexOfStringArray(String[] strArr, String str) {
        int index = -1;
        if (strArr != null && str != null) {
            for (int i = 0; i < strArr.length; i++) {
                if (str.equals(strArr[i])) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    /**
     * @Title: replaceFirst
     * @Description: 替换特定的字符串，替换位置为第一次遇到的
     * @author ginfo003
     * @date 2014-3-21 上午11:47:03
     * @version v1.0.9
     * @param whole
     *            完整的字符串
     * @param strold
     *            要被替换的字符串
     * @param strnew
     *            替换的字符串
     * @return String
     */
    public static String replaceFirst(String whole, String strold, String strnew) {

        if (whole.indexOf(strold) > -1 && strnew != null) {
            String whole_one = whole.substring(0, whole.indexOf(strold));
            String whole_two = whole.substring(whole.indexOf(strold) + strold.length());
            whole = whole_one + strnew + whole_two;
        }

        return whole;
    }

    /**
     * @Title: convertionToLong
     * @Description: 将String数组转换为Long类型数组
     * @author ginfo003
     * @date 2014-3-21 上午11:47:31
     * @version v1.0.9
     * @param strs
     * @return Long[]
     */
    public static Long[] convertionToLong(String[] strs) {
        Long[] longs = null;
        if (!isEmpty(strs)) {
            longs = new Long[strs.length];
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                long thelong = Long.valueOf(str);
                longs[i] = thelong;
            }
        }
        return longs;
    }

    /**
     * @Title: convertionToLongArr
     * @Description: 将String转换为Long类型数组
     * @author ginfo003
     * @date 2014-3-21 上午11:48:03
     * @version v1.0.9
     * @param strs
     *            源字符串
     * @param splitChar
     *            分割字符
     * @return Long[]
     */
    public static Long[] convertionToLongArr(String strs, String splitChar) {
        if (isEmpty(splitChar))
            splitChar = ",";
        Long[] result = null;
        if (!StringUtil.isEmpty(strs)) {
            String[] ids = strs.split(splitChar);
            result = new Long[ids.length];
            for (int i = 0; i < ids.length; i++) {
                result[i] = new Long(ids[i]);
            }
        }
        return result;
    }

    /**
     * @Title: convertionLongToString
     * @Description: Long[] 转成 String
     * @author ginfo003
     * @date 2014-3-21 上午11:48:26
     * @version v1.0.9
     * @param l
     *            long型数组
     * @param splitChar
     *            字符串分隔符
     * @return String
     */
    public static String convertionLongToString(Long[] l, String splitChar) {
        String result = null;
        if (l != null) {
            result = Arrays.toString(l);
            result = result.substring(1, result.length() - 1);
            if (!StringUtil.isEmpty(splitChar)) {
                result = result.replaceAll(",", splitChar);
            }
        }
        return result;
    }

    /**
     * @Title: charEncoding
     * @Description: 字符编码转换 ，默认为utf-8
     * @author ginfo003
     * @date 2014-3-21 上午11:49:03
     * @version v1.0.9
     * @param str
     * @return String
     */
    public static String charEncoding(String str) {
        try {
            str = java.net.URLDecoder.decode(str, "UTF-8");
        } catch (Exception e) {
            str = null;
        }
        return str;
    }

    /**
     * @Title: getStrTransMean
     * @Description: 将字符串str里的某些字符sregex转义成指定的字符sreplace
     * @author ginfo003
     * @date 2014-3-21 上午11:49:25
     * @version v1.0.9
     * @param str
     *            源字符串
     * @param sregex
     *            需要转换的字符
     * @param sreplace
     *            指定转换后的字符
     * @return String
     */
    public static String getStrTransMean(String str, String sregex, String sreplace) {
        if (!StringUtil.isEmpty(str)) {
            str = str.replaceAll(sregex, sreplace);
        }
        return str;
    }

    /**
     * @Title: replaceSpecialChar
     * @Description: 将字符串中的特殊字符去掉
     * @author ginfo003
     * @date 2014-3-21 上午11:50:17
     * @version v1.0.9
     * @param s
     * @return String
     */
    public static String replaceSpecialChar(String s) {
        return s.replaceAll("/|\\\\|\\$|#|&|%|\\*|\\^|;|<|>|&|'|\"", "");
    }

    /**
     * @Title: replaceIllegalChar
     * @Description: 替换非法字符
     * @author ginfo003
     * @date 2014-4-15 上午9:34:28
     * @version v1.0.9
     * @param s
     * @return String
     */
    public static String replaceIllegalChar(String s) {
        return s.replaceAll("\\\\|\\^|<|>|'|\"", "");
    }

    /**
     * @Title: getMapValue
     * @Description: 遍历所有MAP的Value组合成String
     * @author ginfo003
     * @date 2014-3-21 上午11:50:30
     * @version v1.0.9
     * @param map
     * @return String
     */
    public static String getMapValue(Map<String, Object> map) {
        StringBuffer str = new StringBuffer();
        Iterator<Object> it = map.values().iterator();
        while (it.hasNext()) {
            String val = String.valueOf(it.next());
            str.append(val);
        }
        return str.toString();
    }

    /**
     * @Title: bSubstring
     * @Description: 根据特定长度截取字符串 （可以截取中文）
     * @author ginfo003
     * @date 2014-3-21 上午11:50:48
     * @version v1.0.9
     * @param s
     * @param length
     * @return String
     */
    public static String bSubstring(String s, int length) {
        try {
            byte[] bytes = s.getBytes("Unicode");
            int n = 0; // 表示当前的字节数
            int i = 2; // 要截取的字节数 ，从第3个字节开始
            for (; i < bytes.length && n < length; i++) {
                // 奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节
                if (i % 2 == 1) {
                    n++; // 在UCS2第二个字节时n加1
                } else {
                    // 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
                    if (bytes[i] != 0) {
                        n++;
                    }
                }
            }
            // 如果i为奇数时，处理成偶数
            if (i % 2 == 1) {
                // 该UCS2字符是汉字时，去掉这个截一半的汉字
                if (bytes[i - 1] != 0)
                    i = i - 1;
                // 该UCS2字符是字母或数字，则保留该字符
                else
                    i = i + 1;
            }
            return new String(bytes, 0, i, "Unicode");
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * @Title: splitStringRep
     * @Description: 字符串按字节省略替换
     * @author ginfo003
     * @date 2014-3-21 上午11:51:25
     * @version v1.0.9
     * @param str
     *            源字符
     * @param len
     *            显示长度
     * @return String
     */
    public static String splitStringRep(String str, Integer len) {
        String cstr = splitStringSub(str, len, "...");
        return cstr;
    }

    /**
     * @Title: splitString
     * @Description: 字符串按字节省略替换
     * @author ginfo003
     * @date 2014-3-21 上午11:52:01
     * @version v1.0.9
     * @param str
     *            源字符
     * @param len
     *            显示长度
     * @return String
     */
    public static String splitString(String str, Integer len) {
        String cstr = splitStringSub(str, len, "");
        return cstr;
    }

    /**
     * @Title: splitStringSub
     * @Description: 字符串的截取并连接
     * @author ginfo003
     * @date 2014-3-21 上午11:52:32
     * @version v1.0.9
     * @param str
     *            原始字符串
     * @param len
     *            显示长度
     * @param suffix
     *            后面追加的字符串
     * @return String
     */
    public static String splitStringSub(String str, Integer len, String suffix) {
        if (isEmpty(str) || len < 1)
            return str;
        String cstr = bSubstring(str, len);
        if (str.length() > cstr.length()) {
            cstr = cstr + suffix;
        }
        return cstr;

    }

    private static String sChi = "零壹贰叁肆伍陆柒捌玖整分角元拾佰仟万拾佰仟亿拾佰仟万拾佰仟";

    /**
     * @Title: R2C
     * @Description: 人民币转大写
     * @author ginfo003
     * @date 2014-5-7 下午6:51:40
     * @version v1.0.9
     * @param manayStr
     * @return String
     */
    public static String R2C(String manayStr) // 参数规范问题不在这里处理
    {

        double doubNum = Double.parseDouble(manayStr);
        BigDecimal bd = new BigDecimal(doubNum);
        int L = (bd.setScale(0, BigDecimal.ROUND_HALF_UP).longValue() + "").length();
        boolean Z = false;
        boolean zL = Long.valueOf(manayStr.substring(0, L)) == 0; // 整数部分是否为零
        boolean zR = Long.valueOf(manayStr.substring(L + 1, L + 3)) == 0; // 小数部分是否为零
        if (zL && zR)
            return "零"; // 零值退出
        char s0, s1;
        StringBuffer sL = new StringBuffer(); // 转换后的整数串
        StringBuffer sR = new StringBuffer(); // 转换后的小数串
        int n;
        for (int i = 0; i < L; i++) // 整数部分
        {
            s0 = 0;
            s1 = 0;
            n = manayStr.charAt(L - i - 1) - '0'; // 数值 数字字符转换成数字数值
            if (!(n == 0 && (Z || i == 8 || i == 4 || i == 0) || zL)) // Z：前一个字符是否为0
                s0 = sChi.charAt(n); // 值字符
            if (!(n == 0 && (i != 8 && i != 4 && i != 0 || Z && i == 1) || zL))
                s1 = sChi.charAt(i + 13); // 单位字符
            if (s1 > 0)
                sL.insert(0, s1);
            if (s0 > 0)
                sL.insert(0, s0);
            Z = n == 0; // 当前处理的字符是否为0
        }
        int pos = sL.indexOf("亿万"); // 是否有"亿万"
        if (pos > 0) {
            sL.deleteCharAt(pos + 1); // 如有则删除
        }
        boolean isInt = false;
        for (int i = 0; i < 2; i++) // 小数部分
        {
            s0 = 0;
            s1 = 0;
            n = manayStr.charAt(L + 2 - i) - '0'; // 数值
            if (n > 0 || (n == 0 && i == 1 && !Z && !zL)) // 大于零、或角位为零而分位大于零
            {
                s0 = sChi.charAt(n); // 值
            }

            if (n > 0) {
                s1 = sChi.charAt(i + 11); // 单位
            }

            if (n == 0 && i == 0) // 分位为零
            {
                isInt = true;
            }
            if (isInt && (n == 0 && i == 1)) {
                s1 = '整';
            }
            if (s1 > 0)
                sR.insert(0, s1);
            if (s0 > 0)
                sR.insert(0, s0);
            Z = n == 0;
        }
        sL.append(sR);
        return sL.toString();
    } // R2C



    public static void main(String[] args) {
    }
}
