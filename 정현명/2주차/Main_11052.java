import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11052 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 카드 배열 
		int[] cards = new int[N+1];
		
		// 입력 받기
		for(int i=1;i<=N;i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp 생성 및 초깃값 넣기
		int[] dp = new int[N+1];
		dp[1] = cards[1];
		
		
		for(int i= 2;i<=N;i++) {
			dp[i] = cards[i];
			for(int j=1;j<i;j++) {
				dp[i] = Math.max(dp[i],dp[j] + dp[i-j]);
			}
		}
		
		System.out.println(dp[N]);
		

	}
}
