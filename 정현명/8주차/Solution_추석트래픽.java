import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution_추석트래픽 {

	public static void main(String[] args) {
		String[] lines = {
				"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"
				};
		System.out.println(solution(lines));
		
	}

	static class Log implements Comparable<Log>{
		int startTime;
		int endTime;
		
		Log(int startTime, int endTime){
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Log o) {
			// TODO Auto-generated method stub
			return this.endTime == o.endTime?  this.startTime - o.startTime : this.endTime-o.endTime ;
		}
	}
	
	public static int solution(String[] lines) {
        List<Log> logList = new ArrayList<>();
        
        for(String line : lines) {
        	int endTime = 0;
        	endTime += Integer.parseInt(line.substring(11,13))*3600000;
        	endTime += Integer.parseInt(line.substring(14,16))*60000;
        	endTime += Integer.parseInt(line.substring(17,19))*1000;
        	endTime += Integer.parseInt(line.substring(20,23));
        	
        	int startTime = endTime - (int)(1000*Double.parseDouble(line.substring(24).replace("s",""))) + 1; 
        	logList.add(new Log(startTime, endTime));
        	
//        	System.out.println(startTime + " " + endTime);
        }
        
        Collections.sort(logList);
        
        // 특정 로그의 끝난 시간으로부터 1000을 더한 수 안에 있는 로그 수
        
        int answer = 0;
        for(int i=0;i<logList.size();i++) {
        	int cnt = 1;
        	Log startLog = logList.get(i);
        	for(int j=i+1;j<logList.size();j++) {
        		Log tempLog = logList.get(j);
        		if(tempLog.startTime<=startLog.endTime+999) cnt++;
        	}
        	
        	answer = Math.max(answer, cnt);
        }
        
        
        return answer;
    }
}
