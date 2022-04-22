import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16953 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		long answer = -1;
		
		Queue<long[]> queue = new LinkedList<>();
		queue.add(new long[] {A,0});
		
		while(!queue.isEmpty()) {
			long[] info = queue.poll();
			long value = info[0];
			long cnt = info[1];
			
			if(value>=B) {
				if(value == B) {
					answer = cnt+1;
					break;
				}
				continue;
			} 
			
			queue.add(new long[] {value*2,cnt+1});
			queue.add(new long[] {value*10+1, cnt+1});
			
		}
		
		System.out.println(answer);
	}

}
