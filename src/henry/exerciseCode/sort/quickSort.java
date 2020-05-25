/**
 * quickSort
 * 2020/5/25
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package sort;

import java.util.Arrays;

/**
 * @Title: 快速排序
 * @Description: https://blog.csdn.net/TesuZer/article/details/80969006
 * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/5/25      
 * @throws
 */

/**
 1.从数列中挑出一个元素，称为 “基准”（pivot）；
 2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。

        */
public class quickSort {

        public static void main(String[] args) {
            Integer a[] = {3, 2, 1, 4, 5, 6, 7, 1};
            //递归调用
            QuickSort(a, 0, a.length-1);
            System.out.println(Arrays.toString(a));

        }

        private static void QuickSort(Integer[] a, int l, int r) {

            if (l >= r) {
                return;//l和r代表左右两边的的萝卜下标
            }

            int key = a[l];//挖出第一个萝卜备用
            int left = l, right = r;//工人A和B分别站在最左边和最右边位置开始寻找需要交换位置的萝卜


            while (left < right) {
                while (right > left && a[right] >= key) {
                    //B往左走寻找比挖出来的第一个萝卜轻，且位置在A右边的萝卜
                    right--;
                }
                a[left] = a[right];
                while (left < right && a[left] <= key) {
                    //A要往右寻找比一个萝卜重，且位置在B左边的萝卜
                    left++;
                }
                a[right] = a[left];
            }

            a[left] = key;

            QuickSort(a, l, left);
            QuickSort(a, left + 1, r);

        }


}
