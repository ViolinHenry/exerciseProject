/**
 * integerReplacement
 * 2020/5/19
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

/**
 * @Title: ${ENCLOSING_METHOD}   
 * @Description: 给定一个正整数 n，你可以做如下操作：
 *
 * 1. 如果 n 是偶数，则用 n / 2替换 n。
 * 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
 * n 变为 1 所需的最小替换次数是多少？
 *
 * 示例 1:
 *
 * 输入:
 * 8
 *
 * 输出:
 * 3
 *
 * 解释:
 * 8 -> 4 -> 2 -> 1
 *
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/5/19      
 * @throws
 */
public class integerReplacement {
    public int integerReplacement(int n) {
        return (int)func((long)n);
    }
    public long func(long n){
        if(n ==1) return 0;
        if(n%2==0){
            return  1 + func(n/2);
        }else  {
            return 1 + Math.min(func(n+1),func(n-1));
        }
    }
}
