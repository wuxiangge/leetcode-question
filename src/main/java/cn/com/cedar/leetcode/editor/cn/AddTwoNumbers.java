/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * <p>
 * <p>
 * Related Topics 递归 链表 数学 👍 8707 👎 0
 */

package cn.com.cedar.leetcode.editor.cn;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
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

        // 用来取模
        private static final int ten_number = 10;

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            // 创建一个虚拟头结点来承载结果
            ListNode dummyHead = new ListNode(0);
            ListNode prev = dummyHead;

            ListNode p = l1;
            ListNode q = l2;

            int carry = 0;
            // 开始遍历处理
            while (p != null || q != null) {
                int pVal = p != null ? p.val : 0;
                int qVal = q != null ? q.val : 0;

                int sum = pVal + qVal + carry;

                // 进位
                carry = sum / ten_number;
                // 余数
                int mode = sum % ten_number;

                prev.next = new ListNode(mode);
                prev = prev.next;

                // 递推
                if (p!=null) {
                    p = p.next;
                }
                if (q!=null) {
                    q = q.next;
                }
            }
            if (carry != 0) {
                prev.next = new ListNode(carry);
            }

            return dummyHead.next;
        }


        public class ListNode {
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
//leetcode submit region end(Prohibit modification and deletion)

}