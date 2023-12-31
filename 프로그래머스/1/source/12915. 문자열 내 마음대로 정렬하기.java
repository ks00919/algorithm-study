import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings,
                (o1, o2) -> (o1.charAt(n) - o2.charAt(n)) == 0 ? o1.compareTo(o2) : (o1.charAt(n) - o2.charAt(n)));
        return strings;
    }
}