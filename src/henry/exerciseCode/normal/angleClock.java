/**
 * angleClock
 * 2020/5/15
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package normal;

/**
 * @Title: ${ENCLOSING_METHOD}
 * @Description: 给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/5/15      
 * @throws
 * 详解见https://wenku.baidu.com/view/c4da90d85ef7ba0d4a733b85.html
 */
public class angleClock {

    public double angleClock(int hour, int minutes) {
        double a = Math.abs(5.5 * minutes - 30 * hour);
        if(a > 180) {
            return 360 - a;
        }
        return a;
    }
}
