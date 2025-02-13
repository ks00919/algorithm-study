import java.util.*;

class Solution {
    int answer;
    int[] password = new int[5];
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        dfs(0, 1, n, q, ans);
        return answer;
    }
    
    private void dfs(int depth, int number, int n, int[][] q, int[] ans) {
        if (depth == 5) {
            check(q, ans);
            return;
        }
        
        for (int i = number; i <= n; i++) {
            password[depth] = i;
            dfs(depth + 1, i + 1, n, q, ans);
        }
    }
    
    private void check(int[][] q, int[] ans) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i<5; i++) {
            set.add(password[i]);
        }
        
        for (int i = 0; i < q.length; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (set.contains(q[i][j])) count++;
            }
            if (count != ans[i]) return;
        }
        
        answer++;
    }
}