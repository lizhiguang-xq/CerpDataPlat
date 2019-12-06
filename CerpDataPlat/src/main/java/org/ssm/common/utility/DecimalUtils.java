package org.ssm.common.utility;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DecimalUtils {
	public DecimalUtils()
    {
    }
	
	public static BigDecimal toDec(String s)
    {
        try
        {
            if(s == null)
                s = "";
            if(s.indexOf(",") >= 0)
                s = s.replaceAll(",", "");
            return new BigDecimal(s);
        }
        catch(Exception exception)
        {
            return new BigDecimal(0);
        }
    }

    public static String add(String s1, String s2, int scale)
    {
        BigDecimal bigdecimal = toDec(s1);
        BigDecimal bigdecimal1 = toDec(s2);
        BigDecimal bigdecimal2 = bigdecimal.add(bigdecimal1);
        bigdecimal2 = bigdecimal2.setScale(scale, 4);
        return bigdecimal2.toPlainString();
    }

    public static String sub(String s1, String s2, int scale)
    {
        BigDecimal bigdecimal = toDec(s1);
        BigDecimal bigdecimal1 = toDec(s2);
        BigDecimal bigdecimal2 = bigdecimal.subtract(bigdecimal1);
        bigdecimal2 = bigdecimal2.setScale(scale, 4);
        return bigdecimal2.toPlainString();
    }

    public static String multi(String s1, String s2, int scale)
    {
        BigDecimal bigdecimal = toDec(s1);
        BigDecimal bigdecimal1 = toDec(s2);
        BigDecimal bigdecimal2 = bigdecimal.multiply(bigdecimal1);
        bigdecimal2 = bigdecimal2.setScale(scale, 4);
        return bigdecimal2.toPlainString();
    }

    public static String divide(String s1, String s2, int scale)
    {
        MathContext mathcontext = new MathContext(20, RoundingMode.HALF_UP);
        BigDecimal bigdecimal = toDec(s1);
        BigDecimal bigdecimal1 = toDec(s2);
        BigDecimal bigdecimal2 = bigdecimal.divide(bigdecimal1, mathcontext);
        bigdecimal2 = bigdecimal2.setScale(scale, 4);
        return bigdecimal2.toPlainString();
    }

    public static String format(String s, int scale)
    {
        BigDecimal bigdecimal = toDec(s);
        bigdecimal = bigdecimal.setScale(scale, 4);
        return bigdecimal.toPlainString();
    }

    public static String format(String s, String format)
    {
        if(format == null || format.length() == 0)
        {
            return s;
        } else
        {
            DecimalFormat decimalformat = new DecimalFormat(format);
            return decimalformat.format(toDec(s));
        }
    }

    public static String format(DecimalFormat decfmt, String s)
    {
        return decfmt.format(toDec(s));
    }

    public static String toNego(String s)
    {
        BigDecimal bigdecimal = toDec(s);
        bigdecimal = (new BigDecimal(0)).subtract(bigdecimal);
        return bigdecimal.toPlainString();
    }

    public static String trimZero(String s)
    {
        int i = s.lastIndexOf(".");
        if(i < 0)
            return s;
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(s);
        int j = stringbuffer.length() - 1;
        do
        {
            if(j <= i)
                break;
            char c = stringbuffer.charAt(j);
            if(c != '0')
                break;
            stringbuffer.deleteCharAt(j);
            j--;
        } while(true);
        if(stringbuffer.charAt(stringbuffer.length() - 1) == '.')
            stringbuffer.deleteCharAt(stringbuffer.length() - 1);
        return stringbuffer.toString();
    }

    public static String removeZero(String s)
    {
        int i = s.indexOf(".");
        if(i < 0)
            return s;
        int j;
        for(j = s.length() - 1; j > i && s.charAt(j) == '0'; j--);
        s = s.substring(0, j + 1);
        if(s.endsWith("."))
            s = s.substring(0, s.length() - 1);
        return s;
    }

    public static int comparaDecimal(String s1, String s2)
    {
        BigDecimal bigdecimal = toDec(s1);
        BigDecimal bigdecimal1 = toDec(s2);
        return bigdecimal.compareTo(bigdecimal1);
    }

    public static void test1()
    {
        String s = "1";
        String s1 = "6";
        for(int i = 1; i <= 20; i++)
            System.out.println((new StringBuilder()).append(i).append(":").append(divide(s, s1, i)).toString());

    }

    public static void main(String argv[])
    {
        test1();
    }

    public static BigDecimal zero = new BigDecimal("0");
}
