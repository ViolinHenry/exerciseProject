/**
 * hammingWeight
 * 2020/2/27
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

/**
 * @Title: ${ENCLOSING_METHOD}   
 * @Description: ${TODO}(这里用一句话描述这个方法的作用)
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/2/27      
 * @throws
 */
public class hammingWeight {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0){
            sum++;
            n &= (n - 1); //将n-1进行与运算 00000000000000000000000000001011 & 00000000000000000000000000001010 = 00000000000000000000000000001010 个数加1，然后与运算进行一次
        }
        return sum;
    }


    //It toke 11m55s to solve this question.

    public static void main(String args[]){
        int n = 00000000000000000000000000001011;
        hammingWeight a = new hammingWeight();
        System.out.println(a.hammingWeight(n));
    }
}
