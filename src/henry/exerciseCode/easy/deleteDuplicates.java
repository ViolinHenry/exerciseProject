/**
 * deleteDuplicates
 * 2020/5/22
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

/**
 * @Title: ${ENCLOSING_METHOD}   
 * @Description: 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 输入: 1->1->2
 * 输出: 1->2
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/5/22      
 * @throws
 */
public class deleteDuplicates {


     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    //递归方法
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val) head = head.next;
        return head;
    }
}
