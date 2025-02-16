class Solution {
    
    public int solution(int[] players, int m, int k) {
        int[] servers = new int[24];
        int answer = 0;
        
        for (int i = 0; i < 24; i++) {
            if (players[i] > servers[i] * m) {
                int add = (players[i] - servers[i] * m) / m;
                answer += add;
                for (int j = 0; j < k; j++) {
                    if (i + j >= 24) break;
                    servers[i + j] += add;
                }
            }
            
        }
        
        return answer;
    }
}