import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args){
        List<Interval> origin = new ArrayList<>();
        origin.add(new Interval(1,3));
        origin.add(new Interval(2,6));
        origin.add(new Interval(8,10));
        origin.add(new Interval(15,18));
        merge(origin);
    }
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        boolean[] vis = new boolean[intervals.size()];
        while(true){
            int before = res.size();
            for(int i=0;i<intervals.size();i++){
                if(vis[i]==true)
                    continue;
                Interval v1 = intervals.get(i);
                Interval newV = null;
                for(int j=0;j<intervals.size();j++){
                    if(vis[j]==true)
                        continue;
                    Interval v2 = intervals.get(j);
                    if(v1==v2)
                        continue;
                    if(v1.start>v2.end||v1.end<v2.start)
                        continue;
                    newV= mergeTwo(v1,v2);
                    vis[i]=true;
                    vis[j]=true;
                    break;
                }
                if(newV != null){
                    res.add(newV);
                    intervals.add(newV);
                }else{
                    res.add(v1);
                    vis[i]=true;
                }
            }
            int after = res.size();
            if(before==after)
                break;
        }
        return res;
    }
    public static Interval mergeTwo(Interval v1,Interval v2){
        int s1=v1.start,e1=v1.end,s2=v2.start,e2=v2.end;
        if(e1>=s2&&s1<=s2&&e2>=e1)
            return new Interval(s1,e2);
        if(s2<=s1&&s1<=e2&&e1>=e2)
            return new Interval(s2,e1);
        if(s2<=s1&&e1<=e2)
            return v2;
        if(s2>=s1&&e1>=e2)
            return v1;
        return new Interval(0,0);
    }
}
