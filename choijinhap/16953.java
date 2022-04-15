import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int answer = find(A, B);
		System.out.println(answer);
	}

	static int find(int a, int b) {
		Queue<Integer[]> q = new LinkedList<Integer[]>();
		//시작할때 카운트1 주의
		q.offer(new Integer[] { a, 1 });
		
		while (!q.isEmpty()) {
			Integer[] poll = q.poll();
			int newA = poll[0];
			int cnt = poll[1];
			
			if (newA == b)
				return cnt;
			if (newA * 2 <= b)
				q.offer(new Integer[] { newA * 2, cnt + 1 });
			//newA * 10 + 1 이 int 범위넘어가는거 방지 10^8초과한 범위에선 검사할 필요가 없다.
			if (newA<=100000000&& newA * 10 + 1 <= b)
				q.offer(new Integer[] { newA * 10 + 1, cnt + 1 });
		}

		return -1;
	}
}
