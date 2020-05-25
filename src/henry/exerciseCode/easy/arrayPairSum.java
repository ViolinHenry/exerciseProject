/**
 * arrayPairSum
 * 2020/5/21
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

import java.util.Arrays;

/**
 * @Title: ${ENCLOSING_METHOD}   
 * @Description: 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 其实就是把从a1到an数组下标为奇数的数都加起来，题目花里胡哨的
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/5/21      
 * @throws
 */
public class arrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i=i+2){
            sum+=nums[i];
        }
        return sum;
    }
}
