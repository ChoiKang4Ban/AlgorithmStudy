import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] prices = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}
		
		//dp : i개를 가장 비싸게 지불해서 살 수 있는 금액
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int max = prices[i];
			for (int j = 1; j <= i / 2; j++) {
				max = Math.max(dp[j] + dp[i - j], max);
			}
			dp[i] = max;
		}
		System.out.println(dp[N]);
	}
}
