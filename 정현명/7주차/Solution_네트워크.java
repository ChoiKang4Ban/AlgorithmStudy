
public class Solution_네트워크 {

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(solution(n,computers));
	}
	
	
	static void dfs(int node, int n, int[][] computers) {
		visited[node] = true;
		
		for(int i=0;i<n;i++) {
			if(!visited[i] && computers[node][i] == 1) {
				dfs(i, n, computers);
			}
		}
	}
	
	static boolean visited[];
	static int solution(int n, int[][] computers) {

		int answer = 0;
		visited = new boolean[n];
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				answer++;
				dfs(i, n, computers);
			}
		}
		
		return answer;
		
	}

}
