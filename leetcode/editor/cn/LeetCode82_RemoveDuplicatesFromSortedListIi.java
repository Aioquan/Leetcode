//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 513 👎 0

package leetcode.editor.cn;

public class LeetCode82_RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new LeetCode82_RemoveDuplicatesFromSortedListIi().new Solution();
        int[] testCase = new int[]{1, 2, 3, 3, 4, 4, 5};
        ListNode head = new ListNode(testCase[0]);
        ListNode next = head;
        for (int i = 1; i < testCase.length; i++) {
            next.next = new ListNode(testCase[i]);
            next = next.next;
        }
        System.out.println(solution.deleteDuplicates(head));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode vNode = new ListNode();
            vNode.next = head;
            int duplicateNum;
            while (head.next != null && head.next.next != null) {
                if (head.next.val == head.next.next.val) {
                    duplicateNum = head.next.val;
                    while (head.next != null && duplicateNum == head.next.val) {
                        head.next = head.next.next;
                    }
                } else {
                    head = head.next;
                }

            }

            return vNode.next;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}