import java.io.*;
import java.util.*;

public class Main_1411 {

    static int n;
    static int ans;
    static int[] numbers;
    static String[] strs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        numbers = new int[2];
        strs = new String[n];

        for(int i=0;i<n;i++){
            strs[i] = mapping(br.readLine());
        }

        ans = 0;
        combi(0,0);

        System.out.println(ans);

    }

    // 입력된 값을 변환시키는 함수
    public static String mapping(String str){
        String answer="";

        Map<Character,Character> map = new HashMap<>();
        char c = 'a';

        for(int i=0;i<str.length();i++){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),(char)(c++));
            }
            answer+=map.get(str.charAt(i));
        }

        return answer;
    }

    public static void combi(int start,int cnt){

        if(cnt==2){
            if(strs[numbers[0]].equals(strs[numbers[1]])){
                ans++;
            }
            return;
        }

        for(int i=start;i<n;i++){
            numbers[cnt] = i;
            combi(i+1, cnt+1);
        }
    }

}
