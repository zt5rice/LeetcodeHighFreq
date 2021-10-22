import java.util.*;
public class IsIPV {
    public static void main(String[] args) {
        IsIPV sol = new IsIPV();
        String str = "172.16.254.1";
        String[] strs = str.split(".");
        System.out.println(Arrays.deepToString(strs));
        System.out.println(sol.validIPAddress(str));
    }
    public String validIPAddress(String IP) {
        if (isIPV4(IP)) {
            return "IPv4";
        } else if (isIPV6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }
    public boolean isIPV4(String IP) {
        if (IP == null || IP.length() < 7) {
            return false;
        }
        String[] strs = IP.split(".");
        if (strs.length != 4) {
            return false;
        }
        for (int i = 0; i < strs.length; i++) {
            if (Integer.parseInt(strs[i]) > 255 || Integer.parseInt(strs[i]) < 0) {
                return false;
            }
        }
        return true;
    }
    private boolean isIPV6(String IP) {
        if (IP == null) {
            return false;
        }
        String[] strs = IP.split(":");
        if (strs.length != 8) {
            return false;
        }
        // check each part
        for (int i = 0; i < 8; i++) {
            int count = 0;
            for (char c : strs[i].toCharArray()) {
                if (!isPv6Char(c)) {
                    return false;
                }
                count++;
            }
            if (count < 1 || count > 4) {
                return false;
            }
        }
        return true;
    }
    private boolean isPv6Char(char c) {
        return Character.isDigit(c) || ((c <= 'f' && c >= 'a') || (c <= 'F' && c >= 'A'));
    }    
}
