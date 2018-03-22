package com.shijc.ctci.Chapter03.Question3_6;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 3.6双栈排序
 * 题目描述
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈
 * 存放临时数据，但不得将元素复制到别的数据结构中。给定一个int[] numbers
 * (C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，
 * 意味着排序过程中你只能访问到第一个元素。
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：[5,4,3,2,1]
 *
 * @author shijiacheng
 * @date 2018/03/22
 */
public class Solution {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {

        ArrayList<Integer> result = new ArrayList<>();
        if (numbers == null || numbers.length <= 0) {
            return result;
        }

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            stack1.push(numbers[i]);
        }

        while (!stack1.isEmpty()) {
            int temp = stack1.pop();
            while (!stack2.isEmpty() && stack2.peek() > temp) {
                stack1.push(stack2.pop());
            }
            stack2.push(temp);
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop());
        }

        return result;
    }
}
