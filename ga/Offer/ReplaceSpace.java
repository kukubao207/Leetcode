package Offer;

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
