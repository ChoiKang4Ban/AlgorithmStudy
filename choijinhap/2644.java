import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2644 {
	static List<Integer>[] edgeList;
	static boolean[] visited;
	static int N;
	static int answer = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		edgeList = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			edgeList[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			edgeList[from].add(to);
			edgeList[to].add(from);
		}
		dfs(a, b, 0);
		System.out.println(answer);
	}

	static void dfs(int start, int end, int cnt) {
		if (start == end) {
			answer = cnt;
			return;
		}
		for (int i = 0; i < edgeList[start].size(); i++) {
			int child = edgeList[start].get(i);
			if (!visited[child]) {
				visited[child] = true;
				dfs(child, end, cnt + 1);
			}
		}

	}
}
