package org.ssm.common.utility;

public class test {
    public static void main(String[] args) {
        String md5String = CommonUtils.stringToMD5("mobile=13800138000jianyibao123");
        System.out.println(md5String);
    }
}
