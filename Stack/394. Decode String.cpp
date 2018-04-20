394. Decode String

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

�ҵĽⷨ
�����Ľ���˼·���ڣ�
����һ������ʱ����num�����ֽ���ͳ�ƣ���Ϊ���ܴ��������кܶ�λ�����ͳ������ܵõ�һ��ֵnum��
����һ����ĸʱ����result�Ը���ĸ����ͳ�ƣ�result��ͳ�ƵĽ����һ���������ַ�����
����һ��[ʱ������Ҫ��ǰ���������ַ���ѹ���ַ���ջ����numѹ������ջ�С�
����һ��]ʱ���ȵ�������ջ��ֵk���Ե�ǰ[]�ǵ��ַ����ظ�k��,Ȼ����ַ����е����ݵ�������ӵ���ǰ�ַ�������ߡ�


class Solution {
public:

    string decodeString(string s) {
        stack<string> chars;
        stack<int> nums;
        string result;
        int num=0;
        for(int i=0;i<s.length();i++)
        {
            if(s[i]>='0'&&s[i]<='9')
                num=num*10+s[i]-'0';
            else if(isalpha(s[i]))
                result+=s[i];
            else if(s[i]=='[')
            {
                nums.push(num);
                chars.push(result);
                num=0;
                result="";
            }
            else if(s[i]==']')
            {
                string temp=result;
                for(int i=0;i<nums.top()-1;i++)
                    result+=temp;
                result=chars.top()+result;
                nums.pop();
                chars.pop();
            }
        }

        return result;
    }
};


