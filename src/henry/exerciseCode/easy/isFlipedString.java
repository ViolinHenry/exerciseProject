/**
 * isFlipedString
 * 2020/3/2
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

/**
 * @Title: ${ENCLOSING_METHOD}   
 * @Description: 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * @author: hehaoyuan
 * @param: ${TAGS}      
 * @return: ${RETURN_TPYE}
 * @date: 2020/3/2      
 * @throws
 */
public class isFlipedString {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length()!=s2.length())return false;
        if(s1.equals(s2))return true;
        s1+=s1;
        return s1.contains(s2);
    }

    public static void main(String args[]){
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        isFlipedString a = new isFlipedString();
        System.out.println(a.isFlipedString(s1, s2));
    }
}
