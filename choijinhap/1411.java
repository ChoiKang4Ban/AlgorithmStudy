import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1411 {
	static String[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();

		}
		int ans = 0;
		/*
		 * 모든 입력값을 돌면서 비슷한단어인지 체크
		 * 
		 * 쌍을 찾기 때문에 앞에서 찾은걸 카운트하면 중복되서
		 * j=i+1부터 시작
		 * 
		 * */
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (check(i, j)) {
					ans++;
				}
			}

		}
		System.out.println(ans);
	}

	/*
	 *  스트링 a,b를 길이만큼 돌면서
	 *  앞글자부터 숌스럽게 바꿀수 있는지 확인
	 *  
	 *  현재 a의 앞글자와 같은 문자를 아직 바꾼적이 없을때
	 *  현재 b의 앞글자를 전에 어떤 글자가 바꿨는지 확인
	 *  아니라면 a는 글자 b로 바꾼다
	 *  맞다면 a,b는 비슷한단어가 될수없다
	 *  
	 *  현재 a의 앞글자와 같은 문자를 바꾼적이 있으면
	 *  현재 a의 앞글자와 같은 문자가 바꾸려는 글자가 현재 b의 앞글자와 같은지 확인
	 * 
	 * */
	static boolean check(int i, int j) {
		int tobe[] = new int[27];
		boolean[] visited = new boolean[27];
		boolean ret = true;
		String a = arr[i];
		String b = arr[j];
		for (int k = 0; k < a.length(); k++) {
			int aNum = a.charAt(k) - 96;
			int bNum = b.charAt(k) - 96;
			if (tobe[aNum] == 0) {
				if (visited[bNum])
					return false;
				tobe[aNum] = bNum;
				visited[bNum] = true;
			} else {
				if (tobe[aNum] != bNum) {
					return false;
				}
			}
		}
		return ret;

	}
}
