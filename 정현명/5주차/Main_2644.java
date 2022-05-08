import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644 {

	
	/*
	 * 풀이 아이디어
	 * 두 사람(target1, target2의 연결 상태와 연결 길이를 구하면 되는 문제이다.
	 * target1에서 bfs로 탐색하여 target2를 찾으면 해당 길이를 출력하고 찾지 못하면 -1을 출력한다.  
	 */
	
	static int N,M;
	static int target1, target2;
	static List<Integer>[] edgeLists;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		target1 = Integer.parseInt(st.nextToken());
		target2 = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		edgeLists = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			edgeLists[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			edgeLists[v1].add(v2);
			edgeLists[v2].add(v1);
		}
		
		System.out.println(bfs());
		
	}
	
	public static int bfs() {
		boolean visited[] = new boolean[N+1];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {target1,0});
		visited[target1] = true;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int person = info[0];
			int dist = info[1];
			
			if(person==target2) {
				return dist;
			}
			
			for(int nextPerson : edgeLists[person]) {
				if(!visited[nextPerson]) {
					visited[nextPerson] = true;
					queue.add(new int[] {nextPerson,dist+1});
				}
			}
		}
		
		return -1;
	}

}
