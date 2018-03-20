package com.shijc.ctci.Chapter01.Question1_3;

/**
 * 1.3确定两串乱序同构
 * 题目描述
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 这里规定大小写为不同字符，且考虑字符串重点空格。
 * 给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新
 * 排列后可相同。保证两串的长度都小于等于5000。
 * 测试样例：
 * "This is nowcoder","is This nowcoder"
 * 返回：true
 * "Here you are","Are you here"
 * 返回：false
 *
 * @author shijiacheng
 * @date 2018/03/20
 */
public class Solution {
    public boolean checkSam(String s, String t) {
        // write code here
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128];

        char[] s_array = s.toCharArray();
        for (char c : s_array) { // count number of each char in s.
            letters[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
