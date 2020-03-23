/**
 * constructRectangle
 * 2020/3/23
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

/**
 * @Title: ${ENCLOSING_METHOD}   
 * @Description: 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
 *
 * 1. 你设计的矩形页面必须等于给定的目标面积。
 *
 * 2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
 *
 * 3. 长度 L 和宽度 W 之间的差距应当尽可能小。
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/3/23      
 * @throws
 */
public class constructRectangle {
    public int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area); //转换成int后 是向下取整的
        while (area % width != 0) {
            width--;
        }
        return new int[]{area / width, width};
    }

    public static void main (String args[]){
        int area = 4;
        constructRectangle a = new constructRectangle();
        System.out.println(a.constructRectangle(area));
    }
}
