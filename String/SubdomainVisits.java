import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;



public class SubdomainVisits {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String cd : cpdomains) {
            int i = cd.indexOf(' ');
            int n = Integer.valueOf(cd.substring(0, i));
            String s = cd.substring(i + 1);
            for (i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '.') {
                    String d = s.substring(i + 1);
                    count.put(d, count.getOrDefault(d, 0) + n);
                }
            }
            count.put(s, count.getOrDefault(s, 0) + n);
        }

        List<String> res = new ArrayList<>();
        for (String d : count.keySet()) res.add(count.get(d) + " " + d);
        return res;
    }    

    public static void main(String[] args) {
        
        SubdomainVisits sol = new SubdomainVisits();
        String[] cpdomains;
        List<String> res;

        cpdomains = new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        res = sol.subdomainVisits(cpdomains);
        System.out.println("Input  : " + Arrays.toString(cpdomains));
        System.out.println("Output : " + Arrays.toString(res.toArray()));
    }
}
/*abstract


*/