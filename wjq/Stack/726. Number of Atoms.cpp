726. Number of Atoms
Given a chemical formula (given as a string), return the count of each atom.

An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.

Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.

A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.

Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.

Example 1:
Input:
formula = "H2O"
Output: "H2O"
Explanation:
The count of elements are {'H': 2, 'O': 1}.
Example 2:
Input:
formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation:
The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
Example 3:
Input:
formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
Explanation:
The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
Note:

All atom names consist of lowercase letters, except for the first character which is uppercase.
The length of formula will be in the range [1, 1000].
formula will only consist of letters, digits, and round parentheses, and is a valid formula as defined in the problem.

我的思路
做法1： 内存超限
class Solution {
public:
    string stringXnum(string str,int num){
        string temp=str;
        for(int i=0;i<num-1;i++)
            str+=temp;
        return str;
    }
    string tongji(string s){
        map<string,int> m;
        vector<string> v;
        for(int i=0;i<s.length();){
            string alp="";
            alp=alp+s[i++];
            while(s[i]>='a'&&s[i]<='z')
                alp=alp+s[i++];
            if(m[alp]==0)
                v.push_back(alp);
            m[alp]++;
        }
        sort(v.begin(),v.end());
        string res="";
        for(int i=0;i<v.size();i++){
            res+=v[i];
            if(m[v[i]]>1)
                res+=to_string(m[v[i]]);
        }
        return res;
    }
    string countOfAtoms(string formula) {
        string s=formula;
        stack<string> st;
        for(int i=0;i<formula.length();){
            if(isdigit(s[i])){
                //parse number
                string num="";
                while(isdigit(s[i]))
                    num=num+s[i++];
                //string X number
                if(!st.empty()&&st.top()!=")"){
                    string temp=stringXnum(st.top(),atoi(num.c_str()));
                    st.pop();
                    st.push(temp);
                }
                else if(!st.empty()&&st.top()==")"){
                    st.pop();   //pop the ')'
                    string temp="";
                    while(st.top()!="("){
                        temp=st.top()+temp;
                        st.pop();
                    }
                    st.pop();    //pop the '('
                    temp=stringXnum(temp,atoi(num.c_str()));
                    st.push(temp);

                }
            }
            else if(s[i]>='A'&&s[i]<='Z'){
                string alp="";
                alp=alp+s[i++];
                while(s[i]>='a'&&s[i]<='z')
                    alp=alp+s[i++];
                st.push(alp);
                continue;
            }
            else{
                string temp="";
                temp=temp+s[i++];
                st.push(temp);
            }

        }
        string resultS="";
        while(!st.empty())
        {
            resultS=st.top()+resultS;
            st.pop();
        }
        return tongji(resultS);
    }
};

别人的做法 JAVA代码

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String,Integer>> stack = new Stack<>();
        Map<String,Integer> map = new HashMap<>();
        int i=0,n=formula.length();
        while(i<n)
        {
            char c=formula.charAt(i++);
            if(c=='(')
            {
                stack.push(map);
                map=new HashMap<>();
            }
            else if(c==')')
            {
                //parse number
                int val=0;
                while(i<n&&Character.isDigit(formula.charAt(i)))
                    val=val*10+formula.charAt(i++)-'0';
                if(val==0)
                    val=1;

                //merge the cur map and the stack top map.                      ↓
                //for example,(S5O3(E2O2)3B8),convert it to (S5O9E6B8)
                //when we meet the first ')',
                //map=(<E,2>,<O,2>)
                //stack.peek()=(<S,5>,<O,3>)
                //after this :
                //map=(<S,5>,<O,9>,<E,6>)
                //stack,peek()=()
                //"B8" has not been computed,it will be computed in 'else' branch.
                if(!stack.isEmpty())
                {
                    Map<String,Integer> temp=map;
                    map=stack.pop();
                    for(String s: temp.keySet())
                        map.put(s,map.getOrDefault(s,0)+temp.get(s)*val);
                }
            }
            else
            {
                //parse word
                int start=i-1;
                while(i<n&&Character.isLowerCase(formula.charAt(i)))
                    i++;
                String s=formula.substring(start,i);

                //parse number
                int val=0;
                while(i<n&&Character.isDigit(formula.charAt(i)))
                    val=val*10+formula.charAt(i++)-'0';
                if(val==0)
                    val=1;

                //push the pair<string,int> into HashMap
                map.put(s,map.getOrDefault(s,0)+val);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        StringBuilder result=new StringBuilder();
        for(String s: list)
        {
            result.append(s);
            if(map.get(s)>1)
                result.append(map.get(s));
        }
        return result.toString();
    }
}


