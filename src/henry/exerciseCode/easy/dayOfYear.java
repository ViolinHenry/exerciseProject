/**
 * dayOfYear
 * 2020/3/23
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Title: ${ENCLOSING_METHOD}   
 * @Description: 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
 *
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/3/23      
 * @throws
 */
public class dayOfYear {
    public int dayOfYear(String date) {
        try {
            Calendar ca = Calendar.getInstance();
            ca.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
            return ca.get(Calendar.DAY_OF_YEAR);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
