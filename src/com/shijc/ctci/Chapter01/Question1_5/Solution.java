package com.shijc.ctci.Chapter01.Question1_5;

/**
 * 1.5基本字符串压缩
 * 题目描述
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，
 * 字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有
 * 变短，则返回原先的字符串。
 * 给定一个string iniString为待压缩的串(长度小于等于10000)，保证串
 * 内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变
 * 化的串。
 * 测试样例
 * "aabcccccaaa"
 * 返回："a2b1c5a3"
 * "welcometonowcoderrrrr"
 * 返回："welcometonowcoderrrrr"
 *
 * @author shijiacheng
 * @date 2018/03/23
 */
public class Solution {
    public String zipString(String iniString) {
        if (iniString == null || iniString.length() <= 0) {
            return "";
        }

        String copystr = iniString;
        char[] chars = iniString.toCharArray();
        char temp = chars[0];
        int count = 1;

        StringBuilder sb = new StringBuilder();
        sb.append(temp);
        for (int i = 1; i < chars.length; i++) {

            if (chars[i] == temp) {
                count++;
            } else {
                sb.append(count);
                count = 1;
                temp = chars[i];
                sb.append(temp);
            }
        }
        sb.append(count);

        String result = sb.toString();
        if (result.length() > copystr.length()) {
            return copystr;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.zipString("aaabcc"));
    }
}
