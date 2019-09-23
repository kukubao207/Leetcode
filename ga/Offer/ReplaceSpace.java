package Offer;

//替换空格
//请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        String result = new String();
        int i = str.length() - 1;
        while (i >= 0) {
            if (str.charAt(i) != ' ')
                result = str.charAt(i) + result;
            else
                result = "%20" + result;
            i--;
        }
        return result;
    }
}
