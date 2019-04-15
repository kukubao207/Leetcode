1025. Divisor Game

        Alice and Bob take turns playing a game, with Alice starting first.

        Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:

        Choosing any x with 0 < x < N and N % x == 0.
        Replacing the number N on the chalkboard with N - x.
        Also, if a player cannot make a move, they lose the game.

        Return True if and only if Alice wins the game, assuming both players play optimally.



        Example 1:

        Input: 2
        Output: true
        Explanation: Alice chooses 1, and Bob has no more moves.
        Example 2:

        Input: 3
        Output: false
        Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.


        Note:

        1 <= N <= 1000


简单DP

class Solution {
    public boolean divisorGame(int N) {
        if(N==1)
            return false;
        boolean[] dp = new boolean[N+1];
        dp[1]=false;
        dp[2]=true;
        for(int i=3;i<=N;i++){
            for(int j=1;j<i;j++){
                if(i%j==0&&!dp[i-j])
                    dp[i]=true;
            }
        }
        return dp[N];
    }

}

大佬思路
当N为1，必输
当N为2，必胜
当N为3，可选为(1)，必输
当N为4，可选为(1，2)，我们只要选1，就能让对方到达 N=3 必输的情况，所以我们必胜
当N为5，可选为(1)，必输
当N为6，可选为(1,2,3)，选1，对方到达N=5的情况，我们必胜
当N为7，可选为(1)，对方到达N=6，我们必输
当N为8，我们必胜
当N为9，可选为(1,3)，因此对方可达(8,6)，我们必输

由上述递推可以知道
        当对方给我的 N为奇数时，N的因子也必为奇数，因此N-因子必得偶数，我还给对方的一定是一个偶数
        那对方拿到偶数X之后，必定做最优决策X-1，得到一个奇数Y，还给我这个奇数Y。

        重复上述过程，最后我一定会拿到奇数1，那我必输。

        因此代码为
        return N % 2 == 0;
