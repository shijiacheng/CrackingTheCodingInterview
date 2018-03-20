package com.shijc.ctci.Chapter01.Question1_1;

/**
 * 1.1确定字符互异
 * 题目描述
 * 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
 * 给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在
 * 相同的字符。保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
 * 测试样例：
 * "aeiou"
 * 返回：True
 * "BarackObama"
 * 返回：False
 *
 * @author shijiacheng
 * @date 2018/03/19
 */
public class Solution {

    /**
     * 这个方法没有通过牛客网
     *
     * @param iniString
     * @return
     */
    public boolean checkDifferent(String iniString) {

        if (iniString == null) {
            return true;
        }

        if (iniString.length() > 256) {
            return false;
        }

        boolean[] result = new boolean[256];
        for (int i = 0; i < iniString.length(); i++) {
            if (result[iniString.charAt(i)]) {
                return false;
            }
            result[iniString.charAt(i)] = true;
        }

        return true;
    }

    /**
     * 使用异或,因为让支持ASCII所以判断下长度，长度超了，肯定重复
     *
     * @param iniString
     * @return
     */
    public boolean checkDifferent2(String iniString) {

        if (iniString.length() > 256) {
            return false;
        }

        for (int i = 0; i < iniString.length(); i++) {
            for (int j = i + 1; j < iniString.length(); j++) {
                if ((iniString.charAt(i) ^ iniString.charAt(j)) == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        if (s.checkDifferent("acbdbesy")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
