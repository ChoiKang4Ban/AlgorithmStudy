import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
//			String asis = st.nextToken();
			int asis = Integer.parseInt(st.nextToken());
//			String tobe = st.nextToken();
			int tobe = Integer.parseInt(st.nextToken());
			sb.append(solve(asis, tobe)).append("\n");
		}
		System.out.println(sb);
	}

	static String solve(int asis, int tobe) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[10000];
		String[] result = new String[10000];
		q.offer(asis);
		visited[asis]=true;
		result[asis] = "";
		while (!q.isEmpty()) {
			int str = q.poll();
			if (str == tobe)
				return result[str];

			int D = (str * 2) % 10000;
			if (!visited[D]) {
				q.add(D);
				result[D] = result[str] + "D";
				visited[D] = true;
			}

			int S = (str) - 1;
			if (S == -1)
				S = 9999;
			if (!visited[S]) {
				q.add(S);
				result[S] = result[str] + "S";
				visited[S] = true;
			}
			int L = (str % 1000) * 10 + str / 1000;
			if (!visited[L]) {
				q.add(L);
				result[L] = result[str] + "L";
				visited[L] = true;
			}
			int R = (str % 10) * 1000 + str / 10;
			if (!visited[R]) {
				q.add(R);
				result[R] = result[str] + "R";
				visited[R] = true;
			}

		}
		return result[tobe];
	}

}
