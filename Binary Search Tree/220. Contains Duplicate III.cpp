220. Contains Duplicate III
Given an array of integers, find out whether there are two distinct indices i and j in the array
such that the absolute difference between nums[i] and nums[j] is at most t and the absolute
difference between i and j is at most k.

����
�ڸ����������У��ҳ����� nums[i]-nums[j]<=t ͬʱ i-j<=k ��һ��Ԫ�أ����ҵ�����true�����򷵻�false

˼·
ά��һ����СΪk��window������Ϊset����ΪsetĬ������������û���ظ�Ԫ�أ���
�ƶ����window��ֱ��window������ĩβ��
    ��Ԫ��nums[i]�������window֮ǰ�ж�
    �Ƿ�����window���ҵ�һ������x���� |x-nums[i]|<=t
    ��x-nums[i]<=-t && x-nums[i]<=t
    ��nums[i]-t<=x  && x-nums[i]<=t
    ���ȶ���nums[i]-t ������ֻҪ��window���ҵ���һ����nums[i]-t���Ԫ�ؼ��ɣ�����Ĭ�����򣩡�

����
class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {
        set<long long> window;
        for(int i=0;i<nums.size();i++)
        {
            if(i>k&&i-k-1<nums.size())
                window.erase(nums[i-k-1]);
            //|x-nums[i]|<=t   ==>     x-nums[i] >= -t  &&  x-nums[i] <= t

            //x-nums[i] >= -t  ==>  nums[i]-t <= x ��window�ҵ���һ����nums[i]-t���������
            auto it = window.lower_bound((long long)nums[i]-t);

            //��֤�ҵ��������㹫ʽ x-num[i] <=t
            if(it != window.end() && (*it-nums[i]) <= t)
                return true;

            window.insert(nums[i]);
        }
        return false;


    }
};
