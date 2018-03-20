package com.shijc.ctci.Chapter01.Question1_4;

/**
 * 1.4空格替换
 * 题目描述
 * 请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字
 * 符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 * 给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 * 测试样例：
 * "Mr John Smith”,13
 * 返回："Mr%20John%20Smith"
 * ”Hello  World”,12
 * 返回：”Hello%20%20World”
 *
 * @author shijiacheng
 * @date 2018/03/20
 */
public class Solution {
    public String replaceSpace(String iniString, int length) {

        if (iniString == null || length <= 0) {
            return "";
        }

        int blankCount = 0;
        for (int i = 0; i < length; i++) {
            if (iniString.charAt(i) == ' ') {
                blankCount++;
            }
        }
        //从后向前遍历
        int oldStrIndex = length - 1;
        int newStrLength = length + 2 * blankCount;
        int newStrIndex = newStrLength - 1;
        StringBuilder sb = new StringBuilder(iniString);
        sb.setLength(newStrLength);

        while (oldStrIndex >= 0 && oldStrIndex < newStrIndex) {
            if (sb.charAt(oldStrIndex) == ' ') {
                sb.setCharAt(newStrIndex--, '0');
                sb.setCharAt(newStrIndex--, '2');
                sb.setCharAt(newStrIndex--, '%');
            } else {
                sb.setCharAt(newStrIndex--, iniString.charAt(oldStrIndex));
            }
            oldStrIndex--;
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.replaceSpace("Mr John Smith", 13));
    }
}
