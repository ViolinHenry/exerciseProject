/**
 * convertInteger
 * 2020/5/18
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

/**
 * @Title: ${ENCLOSING_METHOD}   
 * @Description: 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 *
 * 示例1:
 *
 *  输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 *  输出：2
 *
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/5/18      
 * @throws
 */
public class convertInteger {
    public int convertInteger(int A, int B) {
        int x = A ^ B, cnt = 0;  //异或运算，比如1001和0011计算异或，结果为1010
        while (x != 0) {
            x &= (x - 1);
            cnt++;
        }
        return cnt;
    }
}
