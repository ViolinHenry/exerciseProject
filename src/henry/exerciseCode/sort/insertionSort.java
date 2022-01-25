/**
 * insertionSort
 * 2020/5/25
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package sort;

/**
 * @Title: 插入排序（Insertion Sort）
 * @Description: 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/5/25      
 * @throws
 */


/**
 1.从第一个元素开始，该元素可以认为已经被排序；
 2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
 3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 5.将新元素插入到该位置后；
 6.重复步骤2~5。
 */
public class insertionSort {
    /**
     * 插入排序
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}