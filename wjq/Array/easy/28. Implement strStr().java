28. Implement strStr()

        Implement strStr().

        Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

        Example 1:

        Input: haystack = "hello", needle = "ll"
        Output: 2
        Example 2:

        Input: haystack = "aaaaa", needle = "bba"
        Output: -1
        Clarification:

        What should we return when needle is an empty string? This is a great question to ask during an interview.

        For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().


解题思路
KMP算法
昨天面试问到了KMP算法，我说不会
早上补了一下KMP算法的实现原理

主串：ABDABCAS
模式串： ABCAB
暴力法，每次将ABCAB向右滑动一个位置，然后判断是否相同
        ABDABCAB
        ABCAB
        不匹配
        ABDABCAB
         ABCAB
        不匹配
        ABDABCAB
          ABCAB
        不匹配
        ABDABCAB
           ABCAB
        匹配
假设主串长度为n，模式串长度为m，时间复杂度：O（n)*O(m)

说说我对KMP算法的理解
        第一个问题 ：如何（滑动模式串B）回溯指针j，能够避免一些重复的比较？
        当主串和模式串部分匹配后，可以利用已匹配部分推导出一些信息，
        使得下一次向右滑动模式串可以跳跃多个位置，而不是每次向右滑动一个位置。
        那么下面看一下 什么信息 可以让我们每次滑动模式串不仅仅只是一个位置
例子1：
        ABCAC
        ABCAB
匹配到最后一个 发现 C！=B
我们观察以下已匹配部分的串： ABCA，他的前缀和 后缀 相同的  最大长度 =1  第一个A与最后一个A匹配
所以j指针回溯到[0,j-1] 最大长度   的位置
也就是要求next[j]数组中保存的是 模式串中[0,j-1]的子串 的  前缀和后缀 相同的 最大长度

例子2：
        ABABD
        ABABC
匹配到 D！=C后
ABAB的最大相同前后缀长度为2
所以j指针回溯到 2 的位置
        ABABD
          ABABC
D！=A
AB的最大相同前后缀长度为0
j回溯到0
        ABABD
            ABABC

        第二个问题：怎么求解next数组？
根据以上的分析，next[j]中保存的是 [0,j-1]子串的 相同前后缀的最大长度
ABCABD

next[0] 保存 -1
next[1] 保存 [0,0] 也就是"A" 的相同前后缀， 这里的前后缀的定义是不包含本身的子串，所以"A"没有前缀也没后缀
next[2] 保存 [0,1] 也就是"AB"的相同前后缀， 0
next[3] 保存 [0,2] 也就是"ABC" 0
next[4] 保存 [0,3] 也就是"ABCA" 1
next[5] 保存 [0,4] 也就是"ABCAB" 2

求解next数组其实和主串匹配模式串的原理相同，就是要把模式串看做两个串进行匹配
BCABD
ABCAB




class Solution {

    public int strStr(String haystack, String needle) {
        if(needle.equals(""))
            return 0;
        //1.kmp算法第一步，求解next数组
        int[] next = new int[needle.length()];
        cal_next(needle,next);

        //2.kmp算法第二步，根据next数组匹配主串与模式串
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int i=0,j=0;
        while(i<h.length&&j<n.length){
            if(j==-1||h[i]==n[j]){
                i++;
                j++;
            }else{
                j=next[j];
            }
        }
        if(j==n.length){
            return i-j;
        }else{
            return -1;
        }
    }

    public void cal_next(String str,int[] next){
        char[] p = str.toCharArray();
        next[0]=-1;
        int i=0,j=-1;
        while(i<str.length()-1){
            if(j==-1||p[i]==p[j]){
                i++;
                j++;
                next[i]=j;
            }
            else{
                j=next[j];
            }
        }
    }
}