/**
 * constructArr
 * 2020/3/2
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

/**
 * @Title: ${ENCLOSING_METHOD}   
 * @Description: 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/3/2      
 * @throws
 */
public class constructArr {
    public int[] constructArr(int[] a) {
        int[] ans = new int[a.length];
        int left = 1, right = 1;
        for (int i = 0; i < ans.length; i++) {
            ans[i] = left;
            left *= a[i];
        }
        for (int j = ans.length - 1; j >= 0; j--) {
            ans[j] *= right;
            right *= a[j];
        }
        return ans;
    }

    public static void main (String args[]){
        int[] a = {1, 2, 3, 4, 5};
        constructArr b = new constructArr();
        System.out.println(b.constructArr(a));
    }
}
