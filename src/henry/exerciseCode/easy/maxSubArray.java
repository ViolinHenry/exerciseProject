/**
 * maxSubArray
 * 2020/2/27
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

/**
 * @Title: ${ENCLOSING_METHOD}   
 * @Description: 给定一个整数数组（有正数有负数），找出总和最大的连续数列，并返回总和。
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/2/27      
 * @throws
 */
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int b = nums[0];
        int sum = b;
        for (int i = 1; i <nums.length; i++){
            if (b < 0){
                b = nums[i];
            }
            else{
                b += nums[i];
            }
            if (b > sum){
                sum = b;
            }
        }
        return sum;
    }

    //It toke 22m28s to solve this question.


    public static void main(String args[]){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray a = new maxSubArray();
        System.out.println(a.maxSubArray(nums));
    }
}
