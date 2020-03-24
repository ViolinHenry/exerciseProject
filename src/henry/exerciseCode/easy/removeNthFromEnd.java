/**
 * removeNthFromEnd
 * 2020/3/24
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

/**
 * @Title: ${ENCLOSING_METHOD}
 * @Description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/3/24      
 * @throws
 */


public class removeNthFromEnd {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }


        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            int length  = 0;
            ListNode first = head;
            while (first != null) {
                length++;
                first = first.next;
            }
            length -= n;
            first = dummy;
            while (length > 0) {
                length--;
                first = first.next;
            }
            first.next = first.next.next;
            return dummy.next;
        }

}
