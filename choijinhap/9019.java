import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			String asis = st.nextToken();
			String tobe = st.nextToken();
			sb.append(solve(asis, tobe)).append("\n");
		}
		System.out.println(sb);
	}

	static String solve(String asis, String tobe) {
		Queue<String> q = new LinkedList<String>();
		boolean[] visited = new boolean[10000];
		q.offer(asis);
		q.offer("");
		while (!q.isEmpty()) {
			String str = q.poll();
			String ans = q.poll();
			if (str.equals(tobe))
				return ans;
			while (str.length() < 4) {
				str = "0" + str;
			}
			int D = ((Integer.parseInt(str) * 2) % 10000);
			if (!visited[D]) {
				q.add(Integer.toString(D));
				q.add(ans + "D");
				visited[D] = true;
			}
			int S = (Integer.parseInt(str) - 1);
			if (S == -1)
				S = 9999;
			if (!visited[S]) {
				q.add(Integer.toString(S));
				q.add(ans + "S");
				visited[S] = true;
			}
			int L = Integer.parseInt(str.substring(1, str.length()) + str.substring(0, 1));
			if (!visited[L]) {
				q.add(Integer.toString(L));
				q.add(ans + "L");
				visited[L] = true;
			}
			int R = Integer
					.parseInt(str.substring(str.length() - 1, str.length()) + str.substring(0, str.length() - 1));
			if (!visited[R]) {
				q.add(Integer.toString(R));
				q.add(ans + "R");
				visited[R] = true;
			}

		}
		return "";
	}

}
