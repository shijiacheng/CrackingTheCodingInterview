package com.shijc.ctci.Chapter02.Question2_7;

import com.shijc.ctci.library.ListNode;

import java.util.Stack;

/**
 * 2.7回文链表
 * 题目描述
 * 请编写一个函数，检查链表是否为回文。
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 * 测试样例：
 * {1,2,3,2,1}
 * 返回：true
 * {1,2,3,2,3}
 * 返回：false
 *
 * @author shijiacheng
 * @date 2018/03/21
 */
public class Solution {
    public boolean isPalindrome(ListNode pHead) {

        ListNode fast = pHead;
        ListNode slow = pHead;

        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // 如果有奇数个元素，跳过中间的元素
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop().intValue();
            if (top != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}
