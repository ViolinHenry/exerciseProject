/**
 * smallestRangeI
 * 2020/3/2
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
 * @date: 2020/3/2      
 * @throws
 */
public class smallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        int min = A[0], max = A[0];
        for (int i : A){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return Math.max(0, max -  min - 2 * K);
    }

    public static void main (String args[]){
        int[] A = {0, 10};
        int K = 2;
        smallestRangeI a = new smallestRangeI();
        System.out.println(a.smallestRangeI(A, K));
    }
}
