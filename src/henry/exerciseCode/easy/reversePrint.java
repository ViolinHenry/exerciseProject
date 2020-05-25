/**
 * reversePrint
 * 2020/5/22
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

/**
 * @Title: ${ENCLOSING_METHOD}   
 * @Description: 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/5/22      
 * @throws
 */
public class reversePrint {


     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }


    // 执行用时 : 0 ms, 在所有 Java 提交中击败了 100.00% 的用户
    // 内存消耗 : 39.8 MB, 在所有 Java 提交中击败了 100.00% 的用户
    // 我就不使用栈，就不使用递归，反正怎么样也是扫描两趟，为什么要额外分配空间呢？
    // 感谢 @谢飞机 的灵感。
    public static int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            ++count;
            node = node.next;
        }
        int[] nums = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; --i) {
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }
}
