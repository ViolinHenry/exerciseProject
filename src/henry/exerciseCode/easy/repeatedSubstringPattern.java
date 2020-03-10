/**
 * repeatedSubstringPattern
 * 2020/3/10
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

/**
 * @Title: ${ENCLOSING_METHOD}
 * @Description: 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * @author: hehaoyuan
 * @param: ${TAGS}
 * @return: ${RETURN_TPYE}
 * @date: 2020/3/10
 * @throws
 */
public class repeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    public static void main (String args[]){
        String a = "abab";
        repeatedSubstringPattern b = new repeatedSubstringPattern();
        System.out.println(b.repeatedSubstringPattern(a));
    }
}
