/**
 * search
 * 2020/3/9
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

/**
 * @Title: 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * @Description: ${TODO}(这里用一句话描述这个方法的作用)
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/3/9      
 * @throws
 */
public class search {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target) return i;
        }
        return -1;
    }//自己写的垃圾方法

    public int search1(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }//二分查找，效率会高很多


    public static void main(String args[]){
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        search a = new search();
        System.out.println(a.search(nums, target));
        System.out.println(7/2);
    }
}
