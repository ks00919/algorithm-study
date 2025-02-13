class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i = 0; i < schedules.length; i++) {
            if(validate(schedules[i], timelogs[i], startday)) answer++;
        }
        return answer;
    }
    
    private boolean validate(int schedule, int[] timelog, int startday) {
        int hour = schedule / 100;
        int minute = schedule % 100 + 10;
            
        if (minute >= 60) {
            hour += 1;
            minute -= 60;
        }
        
        schedule = hour * 100 + minute;
        
        for (int i = 0; i < timelog.length; i++) {
            int date = (startday + i) % 7;
            if (date == 6 || date == 0) continue;
            
            if (schedule < timelog[i]) return false;
        }
        return true;
    }
}