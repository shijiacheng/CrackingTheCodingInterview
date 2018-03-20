package com.shijc.ctci.Chapter01.Question1_2;

/**
 * 1.2原串翻转
 * 题目描述
 * 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
 * 给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
 * 测试样例：
 * "This is nowcoder"
 * 返回："redocwon si sihT"
 *
 * @author shijiacheng
 * @date 2018/03/19
 */
public class Solution {
    public String reverseString(String iniString) {

        char[] chars = iniString.toCharArray();
        reverse(chars, 0, iniString.length() - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseString("google"));
    }
}
