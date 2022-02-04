package easy;


/**
 * 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * */

public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if (0 == size || size == 1) return size == 0 ? 0 : 1;
        int i = 0, j = 1;
        while (j < size){
            if(nums[i] == nums[j]){
                j++;
            }
            else{
                if(j != i + 1){
                    nums[i + 1] = nums[j];
                }
                i++;
                j++;
            }
        }
        return i + 1;
    }
}
