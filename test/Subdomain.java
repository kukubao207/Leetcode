import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subdomain {
    public static void main(String[] args){
        String[] inputs ={"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisits(inputs);
    }
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> m = new HashMap<>();
        for(int i=0;i<cpdomains.length;i++){
            String[] cp = cpdomains[i].split(" ");
            int count = Integer.parseInt(cp[0]);
            String[] domains = cp[1].split("[.]");
            String temp = domains[domains.length-1];
            m.put(temp,m.getOrDefault(temp,0)+count);
            for(int j=domains.length-2;j>=0;j--){
                temp = domains[j]+'.'+temp;
                m.put(temp,m.getOrDefault(temp,0)+count);
            }
        }
        List<String> res = new ArrayList<>();
        for(String key:m.keySet()){
            int count = m.get(key);
            String t = count + " " + key;
            res.add(t);
        }
        return res;
    }
}
