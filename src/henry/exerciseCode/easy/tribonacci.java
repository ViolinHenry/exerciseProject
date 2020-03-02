/**
 * tribonacci
 * 2020/3/2
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

/**
 * @Title: ${ENCLOSING_METHOD}   
 * @Description: 泰波那契序列 Tn 定义如下： 
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/3/2      
 * @throws
 */
public class tribonacci {
    public int tribonacci(int n) {
        int tmp, x = 0, y = 1, z = 1;
        if (n < 3) return n == 0 ? 0 : 1;

        for (int i = 3; i <= n; i++){
            tmp = x + y + z;
            x = y;
            y = z;
            z= tmp;
        }
        return z;
    }

    public static void main (String args[]){
        int n = 25 ;
        tribonacci a = new tribonacci();
        System.out.println(a.tribonacci(n));
    }
}
