import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = arr[0];

		int sum = dp[0];
		for (int i = 1; i < N; i++) {
			if (sum < 0)
				sum = 0;
			sum += arr[i];
			dp[i] = Math.max(sum, dp[i - 1]);
		}
		System.out.println(dp[N - 1]);
	}
}
