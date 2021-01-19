package org.ssm.common.utility;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class CommonUtils {

    /**
     * splitAry方法<br>
     * @param ary 要分割的数组
     * @param subSize 分割的块大小
     * @return
     */
    public static<T> List<T[]> splitArray(T[] ary, int subSize) {
        int count = ary.length % subSize == 0 ? ary.length / subSize
                : ary.length / subSize + 1;
        //存放【子list】的list
        List<List<T>> subAryList = new ArrayList<List<T>>();
        //1.将原长数组拆成指定分割大小的【子list】，并把所有【子list】放入subAryList中
        for (int i = 0; i < count; i++) {
            int index = i * subSize;
            List<T> list = new ArrayList<T>();
            int j = 0;
            while (j < subSize && index < ary.length) {
                list.add(ary[index++]);
                j++;
            }
            subAryList.add(list);
        }

        //2.将subAryList中的【子list】变成数组 放入retList中返回
        List<T[]> retList = new ArrayList<T[]>();
        for (int i = 0; i < subAryList.size(); i++) {
            List<T> subList = subAryList.get(i);
            @SuppressWarnings("unchecked")
            T[] subAryItem = (T[]) getArray(ary.getClass().getComponentType(), subList.size());
            for (int j = 0; j < subList.size(); j++) {
                subAryItem[j] = (T)subList.get(j);
            }
            retList.add(subAryItem);
        }
        return retList;
    }

    public static <T>  T[] getArray(Class<T> componentType,int length) {
        return (T[]) Array.newInstance(componentType, length);
    }
    /**
     * splitAry方法<br>
     * @param ary 要分割的数组
     * @param subSize 分割的块大小
     * @return
     */
    public static List<String[]> splitArrayString(String[] ary, int subSize) {
        int count = ary.length % subSize == 0 ? ary.length / subSize
                : ary.length / subSize + 1;
        //存放【子list】的list
        List<List<String>> subAryList = new ArrayList<List<String>>();
        //1.将原长数组拆成指定分割大小的【子list】，并把所有【子list】放入subAryList中
        for (int i = 0; i < count; i++) {
            int index = i * subSize;
            List<String> list = new ArrayList<String>();
            int j = 0;
            while (j < subSize && index < ary.length) {
                list.add(ary[index++]);
                j++;
            }
            subAryList.add(list);
        }

        //2.将subAryList中的【子list】变成数组 放入retList中返回
        List<String[]> retList = new ArrayList<String[]>();
        for (int i = 0; i < subAryList.size(); i++) {
            List<String> subList = subAryList.get(i);
            String[] subAryItem = new String[subList.size()];
            for (int j = 0; j < subList.size(); j++) {
                subAryItem[j] = subList.get(j);
            }
            retList.add(subAryItem);
        }
        return retList;
    }

    public static String stringToMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

}
