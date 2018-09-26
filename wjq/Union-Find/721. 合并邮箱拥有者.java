721. Accounts Merge
Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Input:
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation:
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].

题意,给定一系列用户账户列表,
对于一个List,下标为0的位置表示用户名,后面的位置表示该用户拥有的邮箱.
只要两个List中有一个邮箱账号相同,说明这两个List同属于一个用户,把这样的邮箱合并.

思路1:
使用并查集,对每一个List下标从1-末尾的元素做Union操作,把这些String合并成几棵树.
Map<String,String> parent = new HashMap<String,String>;                 //表示某个节点邮箱对应的父亲邮箱
Map<String,TreeSet<String>> map = new HashMap<String,TreeSet<String>>();//表示某个根节点邮箱对应的子节点Set

class Solution {
    Map<String,String> parent = new HashMap<String,String>();
    Map<String,String> own = new HashMap<String,String>();
    Map<String,TreeSet<String>> map = new HashMap<String,TreeSet<String>>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        
        for(List<String> account: accounts){
            for(int i=0;i<account.size();i++){
                parent.put(account.get(i),account.get(i));
                own.put(account.get(i),account.get(0));
            }
        }
        
        for(List<String> account: accounts){
            String p = Find(account.get(1));
            for(int i=2;i<account.size();i++){
                parent.put(Find(account.get(i)),p);
            }
        }
        
        for(List<String> account: accounts){
            String p = Find(account.get(1));
            if(map.containsKey(p)==false)
                map.put(p,new TreeSet<String>());
            for(int i=1;i<account.size();i++){
                map.get(p).add(account.get(i));
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for(String root : map.keySet()){
            ArrayList<String> acc = new ArrayList<String>(map.get(root));
            acc.add(0,own.get(root));
            res.add(acc);
        }
        return res;
    }
    private String Find(String x){
        while(parent.get(x)!=x)
            x=parent.get(x);
        return x;
    }
    
}

思路2:
1.建图,一个账户下的所有邮箱两两建边.遍历每一个账户,得到一张邮箱关联图.
若某个邮箱即出现在账户1,也出现在账户3,显然这个邮箱就是图中关联邮箱1和邮箱3所有节点的中间节点.
2.不断对map中的邮箱做深度优先搜索,每一次搜索,都可以把已访问过的邮箱标记为已访问,并加入list.
每一次DFS完毕得到的list就是合并完的list.这样不断深搜直到所有节点都访问过,也即是求出所有合并的节点.

class Solution {
    Map<String, Set<String>> graph = new HashMap<>();  //<email node, neighbor nodes>
    Map<String, String> own = new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //1.build graph
        for(List<String> account:accounts){
            String owner = account.get(0);
            for(int i=1;i<account.size();i++){
                String cur = account.get(i);
                own.put(cur,owner);
                if(graph.containsKey(cur)==false)
                    graph.put(cur,new HashSet<String>());
                if(i==1)
                    continue;
                graph.get(cur).add(account.get(i-1));
                graph.get(account.get(i-1)).add(cur);
            }
        }
        //2.do dfs
        Set<String> vis = new HashSet<>();
        List<List<String>> res= new ArrayList<>();
        for(String email: own.keySet()){
            List<String> emails = new LinkedList<>();
            if(vis.add(email)){
                dfs(email,emails,vis);
                Collections.sort(emails);
                emails.add(0,own.get(email));
                res.add(emails);
            }
        }
        return res;
    }
    void dfs(String email,List<String> emails,Set<String> vis){
        emails.add(email);
        for(String next: graph.get(email)){
            if(vis.add(next)){
                dfs(next,emails,vis);
            }
        }
    }
    
}

这段代码可以学习的地方,java中不需要用boolean vis[]来去标记一个节点是否已经访问过.
可以直接用Set<String> vis 来标记这个String是否被访问过.每当要访问时,直接把他add进Set
如果add返回true,说明之前没访问过,如果add返回false,说明之前访问过.
