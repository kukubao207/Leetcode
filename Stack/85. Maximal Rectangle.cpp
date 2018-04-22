85. Maximal Rectangle

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6

�����������������֮��д��һ������һ��DP�⡣
��ÿһ�е����ݶ�����left[],right[],height[]��������,ͨ���������߼����max_area��
height[j]�Ǵӵ�ǰ��������Ͽ���������1�ĸ����������ǰ��Ϊ0����ֱ��height[j]����0��
left[j]���Ե�ǰ���height[j]Ϊ�߶ȵľ��ε���߽磨�����±꣩��
right[j]���Ե�ǰ���height[j]Ϊ�߶ȵľ��ε��ұ߽磨�����±�+1����

class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        if(matrix.empty())
            return 0;
        int m=matrix.size(),n=matrix[0].size();
        int left[n],right[n],height[n];
        fill_n(left,n,0);fill_n(right,n,n);fill_n(height,n,0);
        int max_area=0;
        for(int i=0;i<m;i++){
            int cur_left=0,cur_right=n;
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1')
                    height[j]++;
                else
                    height[j]=0;
            }
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    left[j]=max(left[j],cur_left);
                }else{
                    left[j]=0;
                    cur_left=j+1;
                }
            }
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    right[j]=min(right[j],cur_right);
                }else{
                    right[j]=n;
                    cur_right=j;
                }
            }
            for(int j=0;j<n;j++)
                max_area=max(max_area,height[j]*(right[j]-left[j]));
        }
        return max_area;
    }
};
