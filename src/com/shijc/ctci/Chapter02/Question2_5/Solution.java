package com.shijc.ctci.Chapter02.Question2_5;

import com.shijc.ctci.library.ListNode;

/**
 * 2.5链式A+B
 * 题目描述
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位
 * 排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
 * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 * 测试样例：
 * {1,2,3},{3,2,1}
 * 返回：{4,4,4}
 *
 * @author shijiacheng
 * @date 2018/03/21
 */
public class Solution {
    ListNode head = null;
    ListNode result = null;

    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        int flag = 0;
        while (a != null && b != null) {

            insert((a.val + b.val + flag) % 10);
            flag = (a.val + b.val + flag) / 10;
            a = a.next;
            b = b.next;


        }
        //当进行到最后一位时，还有进位，需要增加一个新的出来把这个进位存储起来
        if ((a == null) && (b == null) && (flag == 1)) {
            insert(flag);

        }
        if (a == null) {
            while (b != null) {
                insert((b.val + flag) % 10);
                flag = (b.val + flag) / 10;
                b = b.next;
            }
        }
        if (b == null) {
            while (a != null) {
                insert((a.val + flag) % 10);
                flag = (a.val + flag) / 10;
                a = a.next;
            }
        }


        return head;
    }

    public void insert(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            result = node;
        } else {
            result.next = node;
            result = node;
        }
    }

}
