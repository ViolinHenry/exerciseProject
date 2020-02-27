/**
 * reverseLeftWords
 * 2020/2/27
 * Copy Right 2020 Shenzhen Qianhai Dashu Financial Service Co.Ltd.
 * All Copyright Reserved
 */

package easy;

/**
 * @Title:
 * @Description: 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * @author: hehaoyuan
 * @param:
 * @return: ${RETURN_TPYE}
 * @date: 2020/2/27      
 * @throws
 */

public class reverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0,n);
    }

    public static void main(String args[]){
        String s = "abcdefg";
        reverseLeftWords a = new reverseLeftWords();
        System.out.println(a.reverseLeftWords(s, 2));
    }
}


