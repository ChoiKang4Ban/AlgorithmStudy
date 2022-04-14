import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int nums[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 0;
		int r = 0;
		int sum = 0;
		int max = -1001;
		
		while(r<n) {
			sum += nums[r];
			max = Math.max(max, sum);
			
			if(sum < 0) {
				l = r+1;
				r = l;
				if(l == n) break;
				sum = 0;
			}else {
				
				r++;
			}
			
			
		}
		max = Math.max(max, sum);
		System.out.println(max);
		
	}

}
