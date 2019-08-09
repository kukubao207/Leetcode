package Stack.medium;

import java.util.Stack;

//71. Simplify Path
//Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
//
//In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
//
//Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
//
//
//
//Example 1:
//
//Input: "/home/"
//Output: "/home"
//Explanation: Note that there is no trailing slash after the last directory name.
//Example 2:
//
//Input: "/../"
//Output: "/"
//Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
//Example 3:
//
//Input: "/home//foo/"
//Output: "/home/foo"
//Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
//Example 4:
//
//Input: "/a/./b/../../c/"
//Output: "/c"
//Example 5:
//
//Input: "/a/../../b/../c//.//"
//Output: "/c"
//Example 6:
//
//Input: "/a//b////c/d//././/.."
//Output: "/a/b/c"
public class SimplifyPath {
    public static void main(String[] args){
        test();
    }

    //ugly
    public static String simplifyPath(String path) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < path.length(); i++){
            char c = path.charAt(i);
            if(c == '/' && !stack.isEmpty() && stack.peek() == '/'){
                continue;
            }
            else if(c == '.' && i + 2 < path.length() && path.charAt(i + 1) == '.' && path.charAt(i + 2) == '.'){
                while(i < path.length() && path.charAt(i) == '.'){
                    stack.push(path.charAt(i));
                    i++;
                }
                i--;
            }
            else if(c == '.' && i + 1 < path.length() && path.charAt(i + 1) == '.' &&
                    ((i + 2 < path.length() && path.charAt(i + 2) == '/') || i + 2 >= path.length())){
                int count = 0;
                while(stack.size() > 1 && count < 2){
                    if(stack.pop() == '/')
                        count++;
                }
                i++;
            }
            else if(c == '.' && ((i + 1 < path.length() && path.charAt(i + 1) == '/') || i + 1 >= path.length())){
                if(stack.size() > 1)
                    stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        StringBuffer result = new StringBuffer();
        if(stack.size() == 1)
            return stack.pop()+"";
        boolean flag = false;
        while(!stack.isEmpty()){
            char c = stack.pop();
            if(c != '/' || flag){
                flag = true;
                result.append(c);
            }
        }
        return result.reverse().toString();
    }

    public static void test(){
        String s1 = "/home/";
        String s2 = "/../";
        String s3 = "/home//foo/";
        String s4 = "/a//b////c/d//././/..";
        String s5 = "/a/../../b/../c//.//";
        String s6 = "/a/./b/../../c/";
        String s7 = "/.";
        String s8 = "/...";
        String s9 = "/..hidden";
        String s10 = "/.....hidden";
        System.out.println(simplifyPath(s1));
        System.out.println(simplifyPath(s2));
        System.out.println(simplifyPath(s3));
        System.out.println(simplifyPath(s4));
        System.out.println(simplifyPath(s5));
        System.out.println(simplifyPath(s6));
        System.out.println(simplifyPath(s7));
        System.out.println(simplifyPath(s8));
        System.out.println(simplifyPath(s9));
        System.out.println(simplifyPath(s10));
    }
}
