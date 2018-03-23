package com.shijc.ctci.Chapter01.Question1_8;

/**
 * 1.8翻转子串
 * 题目描述
 * 假定我们都知道非常高效的算法来检查一个单词是否为其他字符串的子串。请将这个
 * 算法编写成一个函数，给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而
 * 成，要求只能调用一次检查子串的函数。
 * 给定两个字符串s1,s2,请返回bool值代表s2是否由s1旋转而成。字符串中字符为
 * 英文字母和空格，区分大小写，字符串长度小于等于1000。
 * 测试样例：
 * "Hello world","worldhello "
 * 返回：false
 * "waterbottle","erbottlewat"
 * 返回：true
 *
 * @author shijiacheng
 * @date 2018/03/23
 */
public class Solution {
    public boolean checkReverseEqual(String s1, String s2) {

        if (s1.length() == s2.length() && s1.length() > 0) {
            String s1s1 = s1 + s1;
            return isSubString(s1s1, s2);
        }
        return false;

    }

    private boolean isSubString(String big, String small) {
        if (big.indexOf(small) >= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(s.checkReverseEqual(s1, s2));
    }
}
