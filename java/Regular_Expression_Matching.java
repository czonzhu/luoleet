public class Solution {
    public boolean isMatch(String s, String p) {
        if(p == null || p.isEmpty())
            return (s == null || s.isEmpty());
        // Normal match
        if(p.length() == 1 || p.charAt(1) != '*'){
            if((s== null || s.isEmpty()) || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0)))
                return false;
            return isMatch(s.substring(1), p.substring(1));
        }
        // Match with '*'
        while(!(s == null || s.isEmpty()) && (s.charAt(0) == p.charAt(0)|| p.charAt(0) == '.')){
            if(isMatch(s, p.substring(2))) return true;// '*' plays 0 when equal
            s = s.substring(1);// '*' plays > 0
        }
        return isMatch(s, p.substring(2)); // *plays 0 when inequal.
    }
}
