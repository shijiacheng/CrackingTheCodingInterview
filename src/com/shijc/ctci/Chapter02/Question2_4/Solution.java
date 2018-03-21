package com.shijc.ctci.Chapter02.Question2_4;

import com.shijc.ctci.library.ListNode;

/**
 * 2.4链表分割
 * 题目描述
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
 * 注意：分割以后保持原来的数据顺序不变。
 *
 * @author shijiacheng
 * @date 2018/03/21
 */
public class Solution {
    public ListNode partition(ListNode pHead, int x) {

        ListNode small = new ListNode(-1);
        ListNode small2 = small;
        ListNode big = new ListNode(-1);
        ListNode big2 = big;
        if (pHead == null) {
            return null;
        }
        while (pHead != null) {
            if (pHead.val < x) {
                small.next = pHead;
                small = pHead;
            } else {
                big.next = pHead;
                big = pHead;
            }
            pHead = pHead.next;
        }
        big.next = null;
        small.next = big2.next;
        return small2.next;
    }
}
